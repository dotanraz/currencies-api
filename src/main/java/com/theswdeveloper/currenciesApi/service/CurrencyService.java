package com.theswdeveloper.currenciesApi.service;

import com.theswdeveloper.currenciesApi.db.QueryExecutor;
import com.theswdeveloper.currenciesApi.modelObjects.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CurrencyService {

    @Autowired
    public CurrencyService() throws SQLException {
        createCurrencyTableIfNotExist();
    }

    public void createCurrencyTableIfNotExist() throws SQLException {
        String query = "CREATE TABLE IF NOT EXISTS currencies " +
                "(ID SERIAL PRIMARY KEY, currencyName varchar(100) NOT NULL, " +
                "price DOUBLE PRECISION NOT NULL)";
        QueryExecutor.executeQuery(query);
    }

    public void addCurrency(Currency currency) throws SQLException {
        String query = String.format("INSERT INTO currencies(currencyName,price) "
                + "VALUES('%s','%s')", currency.getCurrencyName(), currency.getPrice());
        QueryExecutor.executeQuery(query);
    }

    public List<Currency> getAllCurrencies() throws SQLException {
        List<Currency> currencies = new ArrayList<>();
        String query = "SELECT * FROM currencies";
        List<Map<String, Object>> rows = QueryExecutor.executeQueryWithResults(query);
        if (rows.isEmpty()) {
            return null;
        }
        rows.stream().forEach(row -> {
            int id = (int)row.get("id");
            String currency = row.get("currencyName").toString();
            Double price = Double.parseDouble(row.get("price").toString());
            currencies.add(new Currency(currency, price));
        });
        return currencies;
    }

}
