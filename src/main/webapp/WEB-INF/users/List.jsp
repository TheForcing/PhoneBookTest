<%@page import="PhonebookPJ.PhoneBookVo" %>
<%@page import= "java.util.List" %>  
<%@page import="PhonebookPJ.PhoneBookDAOImpl"%>
<%@page import="PhonebookPJ.PhoneBookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
PhoneBookDAO dao = new PhoneBookDAOImpl();
//	이메일 리스트 받아오기
List<PhoneBookVo> list = dao.getlist();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PhoneBookList</title>
</head>
<body>
     <h1>주소록 Servlet</h1>
      <h3>목록</h3>
     
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
          <form action="<%= request.getContextPath() %>/WEB-INF/user/delete.jsp"
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
         <a href="<%= request.getContextPath() %>/pb?a=form">새 주소 추가</a>
       </p>
</body>
</html>