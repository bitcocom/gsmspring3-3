package kr.gsm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.gsm.model.Calc;
// JavaSE->JavaEE(Servlet)
public class HelloServlet extends HttpServlet{
	//                            클라이언트의 요청정보                             클라이언트에응답하기위한객체
	public void service(HttpServletRequest request,  HttpServletResponse response) 
			                      throws ServletException, IOException {
		// 처리로직코딩
		Calc c=new Calc();
		int sum=c.hap();
		// HelloServlet
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<table border='1'>");
		out.println("<tr>");
		out.println("<td>total</td>");	
		out.println("<td>"+sum+"</td>");
		out.println("</tr>");	
		out.println("</table>");	
		out.println("</body>");
		out.println("</html>");
	}
}
