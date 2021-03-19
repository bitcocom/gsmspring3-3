package kr.gsm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc.do")
public class CalcController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			                                throws ServletException, IOException {
		  int su1=Integer.parseInt(request.getParameter("su1"));
		  int su2=Integer.parseInt(request.getParameter("su2"));
		  int sum=0;
		  for(int i=su1;i<=su2;i++) {
			  sum+=i;
		  }
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
