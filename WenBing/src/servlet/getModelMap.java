package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.hpl.jena.ontology.OntModel;

import query.getAnswer;
import query.getSymptom;
import module.*;
/**
 * Servlet implementation class getModelMap
 */
public class getModelMap extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getModelMap() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/xml;charset=UTF-8");
		PrintWriter ou;
		ou = response.getWriter();
	//	ou.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		OntModel model = new Module().getInfmodel();
		modelMap modelmap = new modelMap();	
		String xml = modelmap.getmodelMap(model);
		ou.write(xml);
		System.out.println(xml);
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
