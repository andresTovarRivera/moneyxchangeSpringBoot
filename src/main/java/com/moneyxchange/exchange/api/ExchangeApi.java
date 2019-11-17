package com.moneyxchange.exchange.api;

import com.moneyxchange.exchange.dao.*;
import com.moneyxchange.exchange.dto.*;
import java.util.Date;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/servicesREST/money")
public class ExchangeApi {
    
    private CurrenciesRepository currenciesRepo;
    
    @RequestMapping(value="/testConection", method=RequestMethod.GET)
    public @ResponseBody String testConection(){
        return "works at " + new Date().toString(); 
    }
    
    @RequestMapping(method = RequestMethod.POST, path = "/exchange",
                    consumes="application/json",
                    produces = "application/json")
    public @ResponseBody Currency currencyExchange(@RequestBody ExchangeRequest request                                                                  
    ) {
        Currency currencyExchanged = new Currency();
        
        try{ 
                   
            Currencies resp = currenciesRepo.findByCurrencyID(request.getCurrencyIdExchange());
            
            currencyExchanged.setCurrencyID(resp.getCurrencyID());
            currencyExchanged.setCurrencyName(resp.getCurrencyName());
            currencyExchanged.setCurrencySymbol(resp.getCurrencySymbol());
            currencyExchanged.setExchangeRate(resp.getExchangeRate());
            
            double exchangedAmount = request.getAmount() * currencyExchanged.getExchangeRate();
            
            currencyExchanged.setAmount( exchangedAmount );
        }
        catch(Exception e){
            System.err.print(e.getMessage());
        }
        
        return currencyExchanged;
    }
}
