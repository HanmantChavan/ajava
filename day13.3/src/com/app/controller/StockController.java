package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IStockDao;
import com.app.pojos.Stock;

@RestController//=@Controller + @RespBody
@RequestMapping("/stocks")
public class StockController {
	//dep
	@Autowired
	private IStockDao dao;//i/f ref.
	public StockController() {
		System.out.println("in cnstr of "+getClass().getName());
	}
	//REST req handling method to show all stocks
	@GetMapping
	public List<Stock> getAllStocks()
	{
		System.out.println("in get stocks...");
		return dao.listAllStocks();
	}

}
