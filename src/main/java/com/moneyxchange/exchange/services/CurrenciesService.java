package com.moneyxchange.exchange.services;

import com.moneyxchange.exchange.dao.Currencies;
import java.util.List;

public interface CurrenciesService {
    List<Currencies> findAll();
    Currencies findByCurrencyID(String currencyID);
}
