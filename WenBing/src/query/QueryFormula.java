package query;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.RDFNode;

import java.util.Set;
import java.util.HashSet;
import java.util.Map;

import module.Constant;
import module.Module;
import java.util.ArrayList;
public class QueryFormula {
	public String getQuerystr(String treatment){
		String str = "PREFIX wenbing:<"+Constant.prex+"> "+ 
		//	String str = "PREFIX wenbing:<http://www.semanticweb.org/ontologies/2009/11/test.owl#> "+
				"PREFIX rdfs:<http://www.w3.org/2000/01/rdf-schema#> "+ 
				"PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#> "+
				"SELECT ?fj " +
				"WHERE {	wenbing:"+treatment+ 
				"  wenbing:选用 ?fj.}";
			
		System.out.println("query str is: "+str);
		return str;
	}
	public static ArrayList<String> getResultsList(OntModel model,String querystr){
		ArrayList<String> formula = new ArrayList<String>();
		Query query = QueryFactory.create(querystr);
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		ResultSet rs = qe.execSelect();
		System.out.println("rs.getResultVar--"+rs.getResultVars());
		QuerySolution qs;
		Set<RDFNode> resultset = new HashSet<RDFNode>();
		System.out.println("result length: "+ rs.hasNext());
		String temp = null;
		while(rs.hasNext()){
			qs = rs.nextSolution();
			RDFNode fj = qs.get("fj");
			if(fj != null)
				resultset.add(fj);
			temp = fj.toString();
			System.out.println("result 方剂 is :"+temp);
			temp = temp.substring(temp.indexOf("#")+1);
			formula.add(temp);
		}
		qe.close();
		return formula;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OntModel model = new Module().getInfmodel();
		QueryFormula query = new QueryFormula();
		String querystr = query.getQuerystr("清气泻热");
		query.getResultsList(model, querystr);
	}

}
