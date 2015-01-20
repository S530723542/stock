package com.key.stock.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.key.stock.db.dao.StockCollectMapper;
import com.key.stock.db.model.StockCollect;
import com.key.stock.service.StockCollectingService;
import com.key.tools.common.Constant;
import com.key.tools.common.ErrCode;

public class StockCollectingServiceImpl implements StockCollectingService
{

	@Autowired
	StockCollectMapper stockCollectMapper;

	@Transactional
	public int addStockCollection(long userId, long stockId)
	{
		Date now = new Date();
		StockCollect record = new StockCollect();
		record.setUserId(userId);
		record.setStockId(stockId);
		StockCollect stockCollect = stockCollectMapper
				.selectByUniqueKeyForUpdate(record);
		if (stockCollect != null)
		{
			if (Constant.IS_AVAILABLE.equals(stockCollect.getIsDelete()))
			{
				return ErrCode.STOCK_COLLECTING_EXIST;
			} else
			{
				int highest = stockCollectMapper
						.getFirstPriorityByUserId(userId);
				stockCollect.setCreateTime(now);
				stockCollect.setMotifyTime(now);
				stockCollect.setIsDelete(Constant.IS_AVAILABLE);
				stockCollect.setPriority(highest + 1);
				stockCollectMapper.updateByPrimaryKeySelective(stockCollect);
			}

		} else
		{
			int highest = stockCollectMapper.getFirstPriorityByUserId(userId);
			record.setCreateTime(now);
			record.setMotifyTime(now);
			record.setIsDelete(Constant.IS_AVAILABLE);
			record.setPriority(highest + 1);
			stockCollectMapper.insertSelective(record);
		}
		return ErrCode.SUCCESS;
	}
	
	@Transactional
	public int deleteStockCollection(long userId, long stockId)
	{
		Date now = new Date();
		StockCollect record = new StockCollect();
		record.setUserId(userId);
		record.setStockId(stockId);
		StockCollect stockCollect = stockCollectMapper
				.selectByUniqueKeyForUpdate(record);
		if (stockCollect == null
				|| Constant.IS_DELETE.equals(stockCollect.getIsDelete()))
		{
			return ErrCode.STOCK_COLLECTING_NOT_EXIST;
		} else
		{
			stockCollect.setMotifyTime(now);
			stockCollect.setIsDelete(Constant.IS_DELETE);
			stockCollectMapper.priorityAutoReduce(stockCollect);
			stockCollectMapper.updateByPrimaryKeySelective(stockCollect);
		}
		return ErrCode.SUCCESS;
	}

	public List<StockCollect> getStockCollectsByUserId(long userId,
			int pageNum, int pageSize)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public int upStockCollection(long id)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	public int downStockCollection(long id)
	{
		// TODO Auto-generated method stub
		return 0;
	}

}
