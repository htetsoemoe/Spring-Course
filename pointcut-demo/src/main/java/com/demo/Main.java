package com.demo;

import com.demo.bls.AlternativeCurrenciesRepository;
import com.demo.bls.CurrenciesRepository;
import com.demo.bls.CurrencyService;
import com.demo.ds.CurrencyId;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        context.registerShutdownHook();

        CurrenciesRepository currenciesRepository = context.getBean(CurrenciesRepository.class);
        currenciesRepository.getCurrenciesCount();

        AlternativeCurrenciesRepository alternativeCurrenciesRepository =
                context.getBean(AlternativeCurrenciesRepository.class);
        alternativeCurrenciesRepository.getCurrenciesCount();

        CurrencyService currencyService = context.getBean(CurrencyService.class);
        currencyService.getExchangeRate("ERU", "USD");
        currencyService.getExchangeRate("EUR", "USD", 100);
        currencyService.getCurrencyLongName(CurrencyId.EUR);

        try {
            currencyService.getCurrencyCountryName(CurrencyId.EUR);
        } catch (Exception e) {

        }

        currencyService.getCurrencyCountryName(CurrencyId.USD);
    }
}
