<%@page import="kr.gsm.model.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib   prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     
<%
   //Controller에서 작업을 이렇게 했다고 가정을 하자.
   String[] str={"사과","바나나","오랜지","포도","귤"};
   request.setAttribute("str", str);   
%>
<%
   ArrayList<MemberVO> list=new ArrayList<MemberVO>();
   MemberVO vo=new MemberVO();
   vo.setName("홍길동");
   vo.setEmail("bit@naver.com");
   vo.setPhone("010-1111-1111");   
   list.add(vo);
   list.add(vo);
   list.add(vo);   
   request.setAttribute("list", list);   
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="f"  items="${str}">
   ${f}<br>
</c:forEach>
<c:forEach var="vo"  items="${list}">
   ${vo.name}, ${vo.email }, ${vo.phone}<br>
</c:forEach>
</body>
</html>