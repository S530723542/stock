package com.key.stock.controller.rest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.key.stock.pojo.StockVO;
import com.key.stock.service.StockShowService;
import com.key.tools.common.ErrCode;
import com.key.tools.common.ListRecord;
import com.key.tools.common.RestResult;
import com.key.tools.stock.pojo.ExCode;

@RequestMapping("/key/web/")
@Controller
public class StockControllerRest
{

	@Autowired
	StockShowService	stockShowService;

	@RequestMapping(value = "stock/show", method = RequestMethod.GET)
	public @ResponseBody RestResult<ListRecord<StockVO>> showStock(

			ModelMap model,
			HttpSession session,
			@RequestParam(value = "source", required = true) String source,
			@RequestParam(value = "type", required = true) String type,
			@RequestParam(value = "exCode", required = false) String exCodeString,
			@RequestParam(value = "pageNum", required = false) Integer pageNum,
			@RequestParam(value = "pageSize", required = false) Integer pageSize)
	{
		RestResult<ListRecord<StockVO>> restResult = new RestResult<ListRecord<StockVO>>();
		ListRecord<StockVO> listRecord = new ListRecord<StockVO>();
		try
		{

			Long userId = (Long) session.getAttribute("userId");

			if (exCodeString != null)
			{
				ExCode exCode = new ExCode();
				exCode = exCode.parseExCode(exCodeString);
				if (exCode == null)
				{
					restResult.setErrCode(ErrCode.STOCK_NOT_EXIST);
					restResult.setErrMsg("该股票不存在！");
					return restResult;
				}

				StockVO stockVO = stockShowService.getStockVOByExCode(
						exCode.getExChange(), exCode.getCode(), source, type);
				if (stockVO == null)
				{
					restResult.setErrCode(ErrCode.STOCK_NOT_EXIST);
					restResult.setErrMsg("该股票不存在！");
					return restResult;
				}
				if (userId != null)
				{
					boolean isExist = stockShowService.isExistStockCollect(
							userId, stockVO.getId());

					stockVO.setIsCollected(isExist);

				} else
				{
					stockVO.setIsCollected(false);
				}
				List<StockVO> list = new ArrayList<StockVO>();
				list.add(stockVO);
				listRecord.setList(list);
				restResult.setData(listRecord);

			} else
			{
				List<StockVO> list = stockShowService.getStockCollectsByUserId(
						userId, source, type, pageNum, pageSize);
				int count = stockShowService.countStockCollectsByUserId(userId);
				listRecord.setTotalNum(count);
				listRecord.setList(list);
				restResult.setData(listRecord);
			}
		} catch (Exception e)
		{
			restResult.setErrCode(ErrCode.SYSTEM_ERROR);
			restResult.setErrMsg(e.getMessage());
			restResult.setData(null);
		}
		return restResult;
	}

	@RequestMapping(value = "stock/collect", method = RequestMethod.POST)
	public @ResponseBody RestResult<Boolean> collectStock(ModelMap model,
			HttpSession session,
			@RequestParam(value = "stockId", required = true) Long stockId)
	{
		RestResult<Boolean> restResult = new RestResult<Boolean>();
		try
		{

			Long userId = (Long) session.getAttribute("userId");
			if (userId == null)
			{
				restResult.setErrCode(ErrCode.NOT_EXIST);
				restResult.setErrMsg("用户不存在，请先登录！");
				restResult.setData(false);
			}
			int errCode = stockShowService.collectStock(userId, stockId);
			restResult.setErrCode(errCode);
			if (errCode != 0)
			{
				restResult.setData(false);
			}
		} catch (Exception e)
		{
			restResult.setErrCode(ErrCode.SYSTEM_ERROR);
			restResult.setErrMsg(e.getMessage());
			restResult.setData(null);
		}
		return restResult;
	}

}
