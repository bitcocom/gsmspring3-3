<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="kr.gsm.model.*" %>   
<%
     MemberVO vo=(MemberVO)request.getAttribute("vo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script type="text/javascript">
    function golist(){
       location.href="/m32/memberList.do";	
    }
  
  </script>

</head>
<body>
<%=vo.getName()%>의 상세보기 페이지
<form action="/m32/memberUpdate.do"  method="post">
<input type="hidden" name="num" value="<%=vo.getNum()%>"/>
<table class="table table-bordered table-hover">
  <tr>
    <td>번호</td>
    <td><%=vo.getNum()%></td>
  </tr>
  <tr>
    <td>아이디</td>
    <td><%=vo.getId()%></td>
  </tr>
    <tr>
    <td>비밀번호</td>
    <td><%=vo.getPass()%></td>
  </tr>
     <tr>
    <td>이름</td>
    <td><%=vo.getName()%></td>
  </tr>
      <tr>
    <td>나이</td>
    <td><input type="text" id="age" name="age" value="<%=vo.getAge()%>"/></td>
  </tr>
     <tr>
    <td>전화번호</td>
    <td><input type="text" id="phone" name="phone" value="<%=vo.getPhone()%>"/></td>
  </tr>
       <tr>
    <td>이메일</td>
    <td><input type="text" id="email" name="email" value="<%=vo.getEmail()%>"/></td>
  </tr>
  <tr>
    <td colspan="6" align="center">
       <input type="submit" value="수정" class="btn btn-primary"/>
       <input type="reset" value="취소" class="btn btn-warning"/>
       <input type="button" value="목록" class="btn btn-success" onclick="golist()"/>
    </td>
  </tr>
</table>
</form>
</body>
</html>



