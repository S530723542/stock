package com.key.stock.db.dao;

import com.key.stock.db.model.StockCollect;

public interface StockCollectMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock_collect
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock_collect
     *
     * @mbggenerated
     */
    int insert(StockCollect record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock_collect
     *
     * @mbggenerated
     */
    int insertSelective(StockCollect record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock_collect
     *
     * @mbggenerated
     */
    StockCollect selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock_collect
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(StockCollect record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock_collect
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(StockCollect record);
}