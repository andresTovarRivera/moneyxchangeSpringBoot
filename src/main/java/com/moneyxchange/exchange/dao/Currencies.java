package com.moneyxchange.exchange.dao;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "currencies")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Currencies.findAll", query = "SELECT c FROM Currencies c")
    , @NamedQuery(name = "Currencies.findByCurrencyID", query = "SELECT c FROM Currencies c WHERE c.currencyID = :currencyID")
    , @NamedQuery(name = "Currencies.findByCurrencySymbol", query = "SELECT c FROM Currencies c WHERE c.currencySymbol = :currencySymbol")
    , @NamedQuery(name = "Currencies.findByExchangeRate", query = "SELECT c FROM Currencies c WHERE c.exchangeRate = :exchangeRate")})
public class Currencies implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "currencyID")
    private String currencyID;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "currencyName")
    private String currencyName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "currencySymbol")
    private String currencySymbol;
    @Basic(optional = false)
    @NotNull
    @Column(name = "exchangeRate")
    private double exchangeRate;

    public Currencies() {
    }

    public Currencies(String currencyID) {
        this.currencyID = currencyID;
    }

    public Currencies(String currencyID, String currencyName, String currencySymbol, double exchangeRate) {
        this.currencyID = currencyID;
        this.currencyName = currencyName;
        this.currencySymbol = currencySymbol;
        this.exchangeRate = exchangeRate;
    }

    public String getCurrencyID() {
        return currencyID;
    }

    public void setCurrencyID(String currencyID) {
        this.currencyID = currencyID;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (currencyID != null ? currencyID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Currencies)) {
            return false;
        }
        Currencies other = (Currencies) object;
        if ((this.currencyID == null && other.currencyID != null) || (this.currencyID != null && !this.currencyID.equals(other.currencyID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.moneyxchange.exchange.dao.Currencies[ currencyID=" + currencyID + " ]";
    }
    
}
