package com.moneyxchange.exchange.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface CurrenciesRepository extends JpaRepository<Currencies, String> {
    public List<Currencies> findAll();
    public Currencies findByCurrencyID(@Param("currencyID") String currencyID);
}
