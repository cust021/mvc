package com.mvc.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.repository.ClassInfoRepository;

public class ClassinfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClassInfoRepository ciRepo = new ClassInfoRepository();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/")+1;
		uri = uri.substring(idx);
		String path = "/WEB-INF/views/";
		if("list".equals(uri)) {
			path += "class-info/class-info-list.jsp";
			request.setAttribute("classInfoList", ciRepo.selectClassInfoList());
		}else if("view".equals(uri)) {
			path += "class-info/view.jsp";
			String ciNum = request.getParameter("ciNum");
			Map<String,String> classInfo = ciRepo.selectclassInfo(ciNum);
			request.setAttribute("classInfo", classInfo);
		}else if("insert".equals(uri)) {
			path += "class-info/insert.jsp";
		}else if("update".equals(uri)) {
			path += "class-info/update.jsp";
			String ciNum = request.getParameter("ciNum");
			Map<String,String> classInfo = ciRepo.selectclassInfo(ciNum);
			request.setAttribute("classInfo", classInfo);
		}else if("delete".equals(uri)) {
			path += "class-info/delete.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/")+1;
		uri = uri.substring(idx);
		String path = "/WEB-INF/views/common/msg.jsp";
		if("insert".equals(uri)) {
			Map<String,String> param = new HashMap<>();
			param.put("ciName", request.getParameter("ciName"));
			param.put("ciDesc", request.getParameter("ciDesc"));
			int result = ciRepo.insertClassInfo(param);
			request.setAttribute("msg", "회원등록이 실패하였습니다.");
			request.setAttribute("url", "/class-info/insert");
			if(result==1) {
				request.setAttribute("msg", "회원등록이 성공하였습니다.");
				request.setAttribute("url", "/class-info/list");
			}
		}else if("update".equals(uri)) {
			Map<String,String> param = new HashMap<>();
			param.put("ciName", request.getParameter("ciName"));
			param.put("ciDesc", request.getParameter("ciDesc"));
			param.put("ciNum", request.getParameter("ciNum"));
			int result = ciRepo.updateClassInfo(param);
			request.setAttribute("msg", "회원수정이 실패하였습니다.");
			request.setAttribute("url", "/class-info/update?ciNum=" + request.getParameter("ciNum"));
			if(result==1) {
				request.setAttribute("msg", "회원수정이 성공하였습니다.");
				request.setAttribute("url", "/class-info/list");
			}
		}else if("delete".equals(uri)) {
			String ciNum = request.getParameter("ciNum");
			int result = ciRepo.deleteClassInfo(ciNum);
			request.setAttribute("msg", "회원삭제가 실패하였습니다.");
			request.setAttribute("url", "/class-info/view?ciNum=" + request.getParameter("ciNum"));
			if(result==1) {
				request.setAttribute("msg", "회원삭제가 성공하였습니다.");
				request.setAttribute("url", "/class-info/list");
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
