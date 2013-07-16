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

public class QueryInvasionWay {

	public static String getQueryCauseofDisease(String disease){
		String str = "PREFIX wenbing:<"+Constant.prex+"> "+ 
	//	String str = "PREFIX wenbing:<http://www.semanticweb.org/ontologies/2009/11/test.owl#> "+
			"PREFIX rdfs:<http://www.w3.org/2000/01/rdf-schema#> "+ 
			"PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#> "+
			"SELECT ?wb " +
			"WHERE {	wenbing:暑热  wenbing:入侵人体的途径是 ?wb.}";
		
		System.out.println("query str is: "+str);
		return str;
	}
	private static Map getResultsList(OntModel model,String querystr){
		Query query = QueryFactory.create(querystr);
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		ResultSet rs = qe.execSelect();
		System.out.println("rs.getResultVar--"+rs.getResultVars());
		QuerySolution qs;
		Set<RDFNode> ganxietujing = new HashSet<RDFNode>();
		System.out.println("result length: "+ rs.hasNext());
		while(rs.hasNext()){
			qs = rs.nextSolution();
			RDFNode re = qs.get("wb");
			if(re != null)
				ganxietujing.add(re);
			System.out.println("result is :"+re.toString());
		}
		qe.close();
		return null;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OntModel model = new Module().getInfmodel();
		QueryInvasionWay query = new QueryInvasionWay();
		String querystr = query.getQueryCauseofDisease("暑热");
		query.getResultsList(model, querystr);
	}

}
