package com.frc.investment.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.frc.investment.bean.Investment;
import com.frc.investment.bean.SampleRequest;
import com.frc.investment.bean.SampleResponse;
import com.frc.investment.model.InvestmentModel;
import com.frc.investment.service.InvestmentConverterService;
import com.frc.investment.service.InvestmentService;
import com.frc.log.WFCommonLog;
import com.frc.utils.ReadCSVUtil;

@Controller
@RequestMapping("/Sample")
public class SampleService implements ServletContextAware {
	private ServletContext servletContext;
	
	@Resource(name="InvestmentService")
	private InvestmentService investmentService = null;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public String upload(@RequestParam("file")CommonsMultipartFile file, 
			HttpServletRequest request, @RequestParam(value="type") final String type,
			ModelMap model) throws UnsupportedEncodingException {
		if(!file.isEmpty()){
			request.setCharacterEncoding("UTF-8");
			String name="acm";
			String path=this.servletContext.getRealPath("/upload/"); //获取本地存储路径
			String fileName=file.getOriginalFilename();
			String fileType=fileName.substring(fileName.lastIndexOf("."));
			File file2=new File(path, new Date().getTime()+fileType); //新建一个文件
			System.out.println(fileType);
			String contentType = file.getContentType();
			System.out.println("content-Type = " + contentType);
			try {
				file.getFileItem().write(file2);//将上传的文件写入新建的文件中
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("文件名:"+fileName+"本地存储路径为:"+path);
			
			InvestmentConverterService service = new InvestmentConverterService();
				
			ReadCSVUtil csv = new ReadCSVUtil();
			List<String[]> rs = csv.getResultFromCSVFile(file2.getAbsolutePath(), ReadCSVUtil.CHARAC_TAB);
			List<Investment> result = service.convertTradeDetailFromRaw(rs);
			int saveCount = investmentService.saveInvestment(type, result);
			
			List<InvestmentModel> responseModel = service.convertToModel(result);
			
			JSONObject jsObj = new JSONObject();
			jsObj.put("response", responseModel);
			
			String resp = jsObj.toString();
			String ret = "<html><body><textarea>" + resp + "</textarea></body></html>";
			return ret;
		} else{
			Investment inv = new Investment();
			inv.setAcountOfDeal(5555555L);
			inv.setDate("1986/11/03");
			inv.setMinPrice(321.65);
			JSONObject jsObj = new JSONObject();
			jsObj.put("response", inv);
			
			
			String resp = jsObj.toString();
			String ret = "<html><body><textarea>" + resp + "</textarea></body></html>";
			return ret;
		}		
	}

	@RequestMapping(value = "/getSample", method = RequestMethod.POST)
	public @ResponseBody SampleResponse getSample(
			@RequestBody SampleRequest request,
			@RequestParam(value = "_guid") final String guid) {
		SampleResponse response = new SampleResponse();
		response.setName(request.getName());
		response.setNumber(String.format("%20d", new java.util.Date().getTime()));
		response.setStatus("OK");
		response.setResult(String.format("guid = %s", guid));
		return response;
	}

	@RequestMapping(value = "/test")
	@ResponseBody
	public String test() {
		WFCommonLog.info(this, "HOHOHO");
		return "111";
	}

	@Override
	public void setServletContext(ServletContext context) {
		System.out.println(context);
		this.servletContext=context;
	}
}
