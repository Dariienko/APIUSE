
package com.example.apiuse.data;

import java.util.HashMap;
import java.util.Map;

public class ListPrice__1 {

    private Double amountInMicros;
    private String currencyCode;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Double getAmountInMicros() {
        return amountInMicros;
    }

    public void setAmountInMicros(Double amountInMicros) {
        this.amountInMicros = amountInMicros;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
