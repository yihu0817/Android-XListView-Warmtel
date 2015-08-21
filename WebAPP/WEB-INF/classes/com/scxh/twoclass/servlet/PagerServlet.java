package com.scxh.twoclass.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

public class PagerServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8"); // 防止中文乱码
		
		String pageNo = req.getParameter("pageNo");//获取客户端请求页号
		String pageSizes = req.getParameter("pageSize");
		
		
		int pageCount = 100; //总记录数
		List<String> list = new ArrayList<String>();
		for(int i = 0; i < pageCount; i++){
			list.add("第"+i+"数据习近平：彻查天津港爆炸事故责任并严肃追责");
		}
		
		int currentPage = Integer.parseInt(pageNo);
		
		int pageSize = Integer.parseInt(pageSizes);   //每页记录数
		
		System.out.println(" pageSize :"+pageSize);
		
		PageUtil pageUtil = new PageUtil(pageSize, pageCount, currentPage);
		
		int startRecoder = pageUtil.getFromIndex();
		int endRecoder = pageUtil.getToIndex();
		
		List<String> subList = list.subList(startRecoder, endRecoder);
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("listData", subList);
		map.put("pageCount", pageUtil.getPageCount());
		
		String json = JSON.toJSONString(map);
		System.out.println("json :"+json);
		
		PrintWriter pw = resp.getWriter();
		pw.write(json);
		pw.flush();
		pw.close();
	}
}
