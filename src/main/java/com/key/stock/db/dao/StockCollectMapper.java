package com.key.stock.db.dao;

import java.util.List;

import com.key.stock.db.model.StockCollect;
import com.key.tools.common.ListRecord;

public interface StockCollectMapper
{
	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table stock_collect
	 *
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table stock_collect
	 *
	 * @mbggenerated
	 */
	int insert(StockCollect record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table stock_collect
	 *
	 * @mbggenerated
	 */
	int insertSelective(StockCollect record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table stock_collect
	 *
	 * @mbggenerated
	 */
	StockCollect selectByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table stock_collect
	 *
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(StockCollect record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table stock_collect
	 *
	 * @mbggenerated
	 */
	int updateByPrimaryKey(StockCollect record);

	StockCollect selectByUniqueKeyForUpdate(StockCollect record);

	int getFirstPriorityByUserId(Long userId);

	int priorityAutoReduce(StockCollect record);
	
	StockCollect selectByUniqueKey(StockCollect record);
	
	List<StockCollect> selectBySelectiveLimit(ListRecord<StockCollect> listRecord);
	
	int countBySelective(StockCollect record);
	
	StockCollect selectByPrimaryKeyForUpdate(Long id);

}