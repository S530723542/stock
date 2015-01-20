package com.key.stock.service;

import java.util.List;

import com.key.stock.db.model.StockCollect;

public interface StockCollectingService
{
	public int addStockCollection(long userId,long stockId);
	
	public int deleteStockCollection(long userId,long stockId);
	
	public List<StockCollect> getStockCollectsByUserId(long userId,int pageNum,int pageSize);
	
	public int upStockCollection(long id);
	
	public int downStockCollection(long id);
}
