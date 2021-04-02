package kr.gsm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.gsm.model.MemberDAO;
import kr.gsm.model.MemberVO;
@WebServlet("/memberList.do")
public class MemberListController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO dao=new MemberDAO();
		List<MemberVO> list=dao.memberList();
		// 객체바인딩
		request.setAttribute("list", list);
		// jsp로 forward(포워딩=요청의뢰) : memberList.jsp
		RequestDispatcher rd=request.getRequestDispatcher("member/memberList.jsp");
		rd.forward(request, response);	
	}
}
