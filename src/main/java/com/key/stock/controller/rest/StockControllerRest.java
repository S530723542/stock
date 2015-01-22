package com.key.stock.controller.rest;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.key.stock.common.Constant;
import com.key.stock.common.ImageType;
import com.key.stock.common.SourceType;
import com.key.stock.db.model.StockCollect;
import com.key.stock.pojo.StockVO;
import com.key.stock.service.StockCollectingService;
import com.key.tools.common.ErrCode;
import com.key.tools.common.RestResult;
import com.key.tools.stock.db.model.Stock;
import com.key.tools.stock.pojo.ExCode;
import com.key.tools.stock.service.StockService;

@RequestMapping("/key/web/")
@Controller
public class StockControllerRest
{

	@Autowired
	StockService stockService;

	@Autowired
	StockCollectingService stockCollectingService;

	@RequestMapping(value = "stock/show", method = RequestMethod.GET)
	public @ResponseBody RestResult<StockVO> createUserResource(
			ModelMap model,
			HttpSession session,
			@RequestParam(value = "source", required = true) String source,
			@RequestParam(value = "type", required = true) String type,
			@RequestParam(value = "exCode", required = false) String exCodeString,
			@RequestParam(value = "pageNum", required = false) String pageNum,
			@RequestParam(value = "pageSize", required = false) String pageSize)
	{
		RestResult<StockVO> restResult = new RestResult<StockVO>();
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
			Stock stock = stockService.getStockByExCode(exCode.getExChange(),
					exCode.getCode());
			// StockCollect stockCollect=stockCollectingService.
		} else
		{

		}

		return restResult;
	}

	private StockVO transToStockVO(Stock stock, StockCollect stockCollect,
			String source, String type)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		StockVO stockVO = new StockVO();
		switch (source)
		{
		case SourceType.SINA:
			stockVO.setUrl(generateSinaUrl(stock, type));
			break;

		case SourceType.LOCAL:
			return null;

		default:
			return null;
		}
		stockVO.setAddTime(sdf.format(stockCollect.getCreateTime()));
		stockVO.setCode(stock.getStockCode());
		stockVO.setExChange(stock.getStockExchange());
		stockVO.setId(stock.getId());
		stockVO.setName(stock.getName());
		return stockVO;
	}

	private String generateSinaUrl(Stock stock, String type)
	{
		String url = null;
		url = Constant.SINA_IMAGE_URL_STRING + type + "/n/"
				+ stock.getStockExchange() + stock.getStockCode() + ImageType.SUFFIX;
		return url;
	}

}
