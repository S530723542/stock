package com.key.stock.service;

import java.util.List;

import com.key.stock.pojo.StockVO;

public interface StockCollectingService
{
	public int addStockCollection(long userId,long stockId);
	
	public int deleteStockCollection(long userId,long stockId);
	
	public List<StockVO> getStockCollectsByUserId(long userId,int pageNum,int pageSize);
	
	public int countStockCollectsByUserId(long userId);
	
	public int upStockCollection(long id);
	
	public int downStockCollection(long id);
}
