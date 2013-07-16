package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import query.getAnswer;

/**
 * Servlet implementation class getAnswer
 */
public class getAnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String syms = request.getParameter("syms");
		try{
			syms = new String(syms.getBytes("ISO-8859-1"), "UTF-8");
		}catch(UnsupportedEncodingException e){
			System.out.println("cannot decode word: " + syms);
			e.printStackTrace();
		}
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/xml;charset=UTF-8"); 
		PrintWriter ou;
		ou = response.getWriter();
		ou.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		System.out.println(syms);
		String[] strs = syms.split(",");
		System.out.println("parameters number:"+strs.length);
		getAnswer ga = new getAnswer();		
		ou.write(ga.getanswer(strs));
		ou.flush();
		ou.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
