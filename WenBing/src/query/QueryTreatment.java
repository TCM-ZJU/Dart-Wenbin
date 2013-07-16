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
import java.util.List;
import java.util.ArrayList;

import module.Constant;
import module.Module;
public class QueryTreatment {
	public static String getQuerystr(String Syndrome){
		String str = "PREFIX wenbing:<"+Constant.prex+"> "+ 
	//	String str = "PREFIX wenbing:<http://www.semanticweb.org/ontologies/2009/11/test.owl#> "+
			"PREFIX rdfs:<http://www.w3.org/2000/01/rdf-schema#> "+ 
			"PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#> "+
			"SELECT ?zf " +
			"WHERE {	?zf"+ 
			"  wenbing:依据  wenbing:"+Syndrome+
			".}";
		
		System.out.println("query str is: "+str);
		return str;
	}
	public static ArrayList<String> getResultsList(OntModel model,String querystr){
		ArrayList<String> treatment = new ArrayList<String>();
		String temp = null;
		Query query = QueryFactory.create(querystr);
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		ResultSet rs = qe.execSelect();
		System.out.println("rs.getResultVar--"+rs.getResultVars());
		QuerySolution qs;
		Set<RDFNode> resultset = new HashSet<RDFNode>();
		System.out.println("result length: "+ rs.hasNext());
		while(rs.hasNext()){
			qs = rs.nextSolution();
			RDFNode zf = qs.get("zf");
			if(zf != null)
				resultset.add(zf);
			temp = zf.toString();
			System.out.println("result 治法 is :"+temp);
			temp = temp.substring(temp.indexOf("#")+1);
			treatment.add(temp);
		}
		qe.close();
		return treatment;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OntModel model = new Module().getInfmodel();
		QueryTreatment query = new QueryTreatment();
		String querystr = query.getQuerystr("暑入阳明");
		query.getResultsList(model, querystr);
	}
}
