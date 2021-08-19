<%@page import="PhonebookPJ.PhoneBookVo" %>
<%@page import="PhonebookPJ.PhoneBookDAO" %>
<%@page import="PhonebookPJ.PhoneBookDAOImpl" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

    Long pk= Long.valueOf(request.getParameter("id"));
     

    PhoneBookDAO dao= new PhoneBookDAOImpl();
    
    dao.delete(pk);
     
     response.sendRedirect(request.getContextPath()+"/WEB-INF/users/index.jsp");
 %>   