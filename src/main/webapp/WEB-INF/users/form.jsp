<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소록 servlet</title>
</head>
<body>
  <h1>목록</h1>
  <form action="<%= request.getContextPath() %>/pb"
   method="POST">
   
   <input type="hidden" value="add" name="a"/>
   <label for="Name">이름</label>
   <input type="text" name="name" id="name" /><br/>
   <label for= "hp">휴대전화</label>
   <input type="text" name="hp" id="hp"/><br/>
   <label for="tel">전화번호</label>
   <input type="text" name="tel" id="tel"/><br/>
   
   
   <input type="submit" value="주소 등록" >
   
   </form>
   
   <p>
      <a href="<%= request.getContextPath() %>/pb?a=List">목록 보기</a>
   </p> 
   
</body>
</html>