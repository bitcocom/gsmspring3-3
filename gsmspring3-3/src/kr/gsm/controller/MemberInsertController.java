package kr.gsm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.gsm.model.MemberDAO;
import kr.gsm.model.MemberVO;
@WebServlet("/memberInsert.do")
public class MemberInsertController extends HttpServlet {	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 클라이언트에서 넘어온 파라메터를 수집(VO)
		request.setCharacterEncoding("utf-8");
	    String id=request.getParameter("id");	
	    String pass=request.getParameter("pass");
	    String name=request.getParameter("name");
	    int age=Integer.parseInt(request.getParameter("age"));
	    String phone=request.getParameter("phone");
	    String email=request.getParameter("email");
	    MemberVO vo=new MemberVO();
	    vo.setId(id);
	    vo.setPass(pass);
	    vo.setName(name);
	    vo.setAge(age);
	    vo.setPhone(phone);
	    vo.setEmail(email);
	    // Model연동
	    MemberDAO dao=new MemberDAO();
	    int cnt=dao.memberInsert(vo);
	    if(cnt>0) {
	    	// 회원가입이 성공후에는 다시 회원리스트보기(/m3/memberList.do)가 되어한다.
	    	// redirect기법
	    	response.sendRedirect("/m3/memberList.do");
	    }else {
	       throw new ServletException("error");	
	    }
	}
}
