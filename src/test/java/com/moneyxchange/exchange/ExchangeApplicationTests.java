package com.moneyxchange.exchange;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.moneyxchange.exchange.api.ExchangeApi;
import com.moneyxchange.exchange.dto.Currency;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ExchangeApplicationTests {

        static ExchangeApi api = new ExchangeApi();
                
        @Test
	void exchange() {
            Currency currency = new Currency();
            
            currency.setCurrencyID("EUR");
            currency.setDollarAmount(10);
            
            Currency currencyExchanged = api.currencyExchange(currency);
            
            assertEquals(currencyExchanged.getDollarAmount() 
                         * currencyExchanged.getExchangeRate()
                         , currencyExchanged.getAmount() ); 
	}
        
	@Test
	void exchangeWithoutAmount() {
            Currency currency = new Currency();
            
            currency.setCurrencyID("EUR");
            currency.setDollarAmount(0);
            
            Currency currencyExchanged = api.currencyExchange(currency);
            
            assertEquals(0, currencyExchanged.getAmount()); 
	}
        
        @Test
	void exchangeWithoutCurrencyID() {
            Currency currency = new Currency();
            
            currency.setCurrencyID("");
            currency.setDollarAmount(10);
            
            Currency currencyExchanged = api.currencyExchange(currency);
            
            assertEquals("", currencyExchanged.getCurrencyName()); 
            assertEquals(0, currencyExchanged.getExchangeRate()); 
            assertEquals(0, currencyExchanged.getAmount()); 
	}
        

}
