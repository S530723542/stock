package com.key.stock.db.model;

import java.util.Date;

public class StockCollect {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column stock_collect.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column stock_collect.user_id
     *
     * @mbggenerated
     */
    private Long userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column stock_collect.stock_id
     *
     * @mbggenerated
     */
    private Long stockId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column stock_collect.priority
     *
     * @mbggenerated
     */
    private Integer priority;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column stock_collect.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column stock_collect.motify_time
     *
     * @mbggenerated
     */
    private Date motifyTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column stock_collect.is_delete
     *
     * @mbggenerated
     */
    private Byte isDelete;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column stock_collect.id
     *
     * @return the value of stock_collect.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column stock_collect.id
     *
     * @param id the value for stock_collect.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column stock_collect.user_id
     *
     * @return the value of stock_collect.user_id
     *
     * @mbggenerated
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column stock_collect.user_id
     *
     * @param userId the value for stock_collect.user_id
     *
     * @mbggenerated
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column stock_collect.stock_id
     *
     * @return the value of stock_collect.stock_id
     *
     * @mbggenerated
     */
    public Long getStockId() {
        return stockId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column stock_collect.stock_id
     *
     * @param stockId the value for stock_collect.stock_id
     *
     * @mbggenerated
     */
    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column stock_collect.priority
     *
     * @return the value of stock_collect.priority
     *
     * @mbggenerated
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column stock_collect.priority
     *
     * @param priority the value for stock_collect.priority
     *
     * @mbggenerated
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column stock_collect.create_time
     *
     * @return the value of stock_collect.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column stock_collect.create_time
     *
     * @param createTime the value for stock_collect.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column stock_collect.motify_time
     *
     * @return the value of stock_collect.motify_time
     *
     * @mbggenerated
     */
    public Date getMotifyTime() {
        return motifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column stock_collect.motify_time
     *
     * @param motifyTime the value for stock_collect.motify_time
     *
     * @mbggenerated
     */
    public void setMotifyTime(Date motifyTime) {
        this.motifyTime = motifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column stock_collect.is_delete
     *
     * @return the value of stock_collect.is_delete
     *
     * @mbggenerated
     */
    public Byte getIsDelete() {
        return isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column stock_collect.is_delete
     *
     * @param isDelete the value for stock_collect.is_delete
     *
     * @mbggenerated
     */
    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }
}