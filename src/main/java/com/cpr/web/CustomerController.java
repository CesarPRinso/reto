package com.cpr.web;

import com.cpr.service.model.Customer;
import com.cpr.service.service.CustomerService;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.hibernate.exception.SQLGrammarException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.persistence.RollbackException;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar(@RequestParam(value="dni", required = false) String dni,
                                       @RequestParam(value="correo", required = false) String email) {
        Map<String, Object> responseError = new HashMap<>();
        Map<String, Object> response = new HashMap<String, Object>();

        try {
            response.put("result", 1);
            response.put("data", customerService.findBy(dni,email));
            response.put("mensaje", "Consulta Exitosa.");
        } catch (Exception e) {
            responseError.put("result", "-1");
            responseError.put("mensaje", "Error al ejecutar consulta en base de datos");
            return new ResponseEntity<Map<String, Object>>(responseError, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @GetMapping("/kpis")
    public ResponseEntity<?> kpis() {
        Map<String, Object> responseError = new HashMap<>();
        Map<String, Object> response = new HashMap<String, Object>();

        try {
            response.put("result", 1);
            response.put("data", customerService.getkpi());
            response.put("mensaje", "Consulta Exitosa.");
        } catch (Exception e) {
            responseError.put("result", "-1");
            responseError.put("mensaje", "Error al ejecutar consulta en base de datos");
            return new ResponseEntity<Map<String, Object>>(responseError, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> guardarCustomer(@RequestBody Customer customer) {
        Map<String, Object> responseError = new HashMap<>();
        Map<String, Object> response = new HashMap<String, Object>();
        try {
            response.put("result", 1);
            customerService.saveCustomer(customer);
            response.put("mensaje", "Se registro correctamente.");
        } catch (RollbackException f) {
            return new ResponseEntity<Map<String, Object>>(responseError, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            responseError.put("mensaje", "Error al ejecutar consulta en base de datos");
            return new ResponseEntity<Map<String, Object>>(responseError, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
}
