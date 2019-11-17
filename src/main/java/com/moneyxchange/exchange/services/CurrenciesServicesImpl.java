package com.moneyxchange.exchange.services;

import com.moneyxchange.exchange.dao.Currencies;
import com.moneyxchange.exchange.dao.CurrenciesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrenciesServicesImpl implements CurrenciesService {
    
    @Autowired
    private CurrenciesRepository currenciesRepository;     
    
    @Override
    public List<Currencies> findAll() {          
        try {
            return currenciesRepository.findAll();
        } 
        catch (Exception e) {
            System.err.print(e.getMessage());
            return null;
        }     
    }
    
    @Override
    public Currencies findByCurrencyID(String currencyID) {          
        try {
            return currenciesRepository.findByCurrencyID(currencyID);
        } 
        catch (Exception e) {
            System.err.print(e.getMessage());
            return new Currencies();
        }     
    }
}
