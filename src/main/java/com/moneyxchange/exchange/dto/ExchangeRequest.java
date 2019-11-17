/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moneyxchange.exchange.dto;

/**
 *
 * @author Andres
 */
public class ExchangeRequest {
    private double amount;
    private String currencyIdtoChange; 

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrencyIdtoChange() {
        return currencyIdtoChange;
    }

    public void setCurrencyIdtoChange(String currencyIdtoChange) {
        this.currencyIdtoChange = currencyIdtoChange;
    }

    public String getCurrencyIdExchange() {
        return currencyIdExchange;
    }

    public void setCurrencyIdExchange(String currencyIdExchange) {
        this.currencyIdExchange = currencyIdExchange;
    }
    private String currencyIdExchange;
}
