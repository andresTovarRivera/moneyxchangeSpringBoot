package com.moneyxchange.exchange.api;

import com.moneyxchange.exchange.dao.*;
import com.moneyxchange.exchange.dto.*;
import com.moneyxchange.exchange.services.CurrenciesService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/servicesREST/money")
public class ExchangeApi {
    
    @Autowired
    private CurrenciesService currenciesService;
    
    @RequestMapping(value="/testConection", method=RequestMethod.GET)
    public @ResponseBody String testConection(){
        return "works at " + new Date().toString(); 
    }
    
    @RequestMapping(value="/allCurrencies", method=RequestMethod.GET)
    public @ResponseBody List<Currency> getAll(){
        
         List<Currency> currencyList = new ArrayList<>();
        
        try{
             List<Currencies> resp = currenciesService.findAll();
             
             for (Currencies currency : resp) {
                Currency c = new Currency();  
                c.setCurrencyID(currency.getCurrencyID());            
                c.setCurrencyName(currency.getCurrencyName());
                c.setCurrencySymbol(currency.getCurrencySymbol());
                c.setExchangeRate(currency.getExchangeRate());
                currencyList.add(c);
            }             
        }
        catch(Exception e){
            System.err.print(e.getMessage());
        }
        
        return currencyList; 
    }
    
    @RequestMapping(method = RequestMethod.POST, path = "/exchange",
                    consumes="application/json",
                    produces = "application/json")
    public @ResponseBody Currency currencyExchange(@RequestBody Currency request                                                                  
    ) {
        Currency currencyExchanged = new Currency();
        
        try{ 
                   
            Currencies resp = currenciesService.findByCurrencyID(request.getCurrencyID());
            
            currencyExchanged.setCurrencyID(resp.getCurrencyID());
            
            currencyExchanged.setCurrencyName(resp.getCurrencyName());
            currencyExchanged.setCurrencySymbol(resp.getCurrencySymbol());
            currencyExchanged.setExchangeRate(resp.getExchangeRate());
            currencyExchanged.setDollarAmount( request.getDollarAmount() );
            
            double exchangedAmount = request.getDollarAmount() * currencyExchanged.getExchangeRate();
            
            currencyExchanged.setAmount( exchangedAmount );
        }
        catch(Exception e){
            System.err.print(e.getMessage());
        }
        
        return currencyExchanged;
    }
}
