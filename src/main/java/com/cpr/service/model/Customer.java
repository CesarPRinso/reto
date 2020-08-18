package com.cpr.service.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

@Entity
@Table(name = "CUSTOMERS")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    @JsonProperty("nombre")
    @NotNull(message = "El campo nombre no puede estar vacío ")
    @Column(name="NAME")
    private String name;

    @JsonProperty("apellidos")
    @NotNull(message = "El campo apellido no puede estar vacío ")
    @Column(name="LASTNAME")
    private String lastName;

    @JsonProperty("correo")
    @Email(message = "el correo debe de ser válido")
    @Column(name="EMAIL")
    private String email;

    @JsonProperty("dni")
    @NotNull(message = "El campo dni no puede estar vacío ")
    @Column(name="DNI")
    private String dni;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(name="CREATIONDATE")
    private LocalDate creationDate =  LocalDate.now();

    @JsonProperty("fechaNacimiento")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(name="BIRTHDATE")
    private LocalDate birthdate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }


    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public int calculateAge(){
        return Period.between(this.birthdate, LocalDate.now()).getYears();
    }
}
