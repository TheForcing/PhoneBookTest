<%@page import="PhonebookPJ.PhoneBookVo" %>
<%@page import= "java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
List<PhoneBookVo> list =(List<PhoneBookVo>)request.getAttribute("list");
%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소록 Servlet</title>
</head>
<body>
   <h1>새 주소 등록</h1>
   
   <% for (PhoneBookVo vo: list) { %>
   <table border="1">
   <tr>
       <th>이름</th>
       <td>vo.getName()</td>
    </tr>
   <tr>
       <th>휴대전화</th>
       <td>vo.getHp()</td>
   </tr>
   <tr>
       <th>전화번호</th>
       <td>vo.getTel()</td>
    </tr>
    <tr>
       <td colspan="2">
          <form action="<%= request.getContextPath() %>/ph"
          method="Post">
          <input type="hidden" name="a" value="delete" />
          <input type="hidden" name="id" value="<%= vo.getId() %>" />
          <input type="submit" value="삭제"/>
          </form>
        </td>
       </tr>
       </table> 
<br />
<% } %>
       <p>
         <a href="<%= request.getContextPath() %>/pb?a=form">삭제 후 목록</a>
       </p>
</body>
</html>