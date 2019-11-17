package com.moneyxchange.exchange.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrenciesRepository extends JpaRepository<Currencies, Long> {
    Currencies findByCurrencyID(String id);
}
