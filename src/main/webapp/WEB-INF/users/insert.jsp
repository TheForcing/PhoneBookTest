<%@page import="PhonebookPJ.PhoneBookDAOImpl"%>
<%@page import="PhonebookPJ.PhoneBookDAO"%>
<%@page import="PhonebookPJ.PhoneBookVo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String name= request.getParameter("name");
    String hp= request.getParameter("hp");
    String tel=request.getParameter("tel");
    
    PhoneBookDAO dao = new PhoneBookDAOImpl();
    
    PhoneBookVo vo = new PhoneBookVo();
    vo.setName(name);
    vo.setHp(hp);
    vo.setTel(tel);
    
    dao.insert(vo);
    
    response.sendRedirect(request.getContextPath()+"/WEB-INF/users/List.jsp");
   
   %> 
    
    