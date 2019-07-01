package com.app.dao;

import java.util.List;

import com.app.pojos.Stock;

public interface IStockDao {
	List<Stock> listAllStocks();
}
