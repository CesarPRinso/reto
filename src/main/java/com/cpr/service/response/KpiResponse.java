package com.cpr.service.response;

import com.cpr.service.model.Customer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.Builder;

public class KpiResponse {

    @JsonProperty("promedioEdad")
    private Integer average;

    @JsonProperty("edadMinima")
    private Integer minumEdge;

    @JsonProperty("clienteEdadMinima")
    private Customer customerMinumEdge;

    @JsonProperty("edadMaxima")
    private Integer maximunEdge;

    @JsonProperty("clienteEdadMaxima")
    private Customer customerMaximunEdge;

    public KpiResponse() {
    }

    public Integer getAverage() {
        return average;
    }

    public void setAverage(Integer average) {
        this.average = average;
    }

    public Integer getMinumEdge() {
        return minumEdge;
    }

    public void setMinumEdge(Integer minumEdge) {
        this.minumEdge = minumEdge;
    }

    public Customer getCustomerMinumEdge() {
        return customerMinumEdge;
    }

    public void setCustomerMinumEdge(Customer customerMinumEdge) {
        this.customerMinumEdge = customerMinumEdge;
    }

    public Integer getMaximunEdge() {
        return maximunEdge;
    }

    public void setMaximunEdge(Integer maximunEdge) {
        this.maximunEdge = maximunEdge;
    }

    public Customer getCustomerMaximunEdge() {
        return customerMaximunEdge;
    }

    public void setCustomerMaximunEdge(Customer customerMaximunEdge) {
        this.customerMaximunEdge = customerMaximunEdge;
    }
}
