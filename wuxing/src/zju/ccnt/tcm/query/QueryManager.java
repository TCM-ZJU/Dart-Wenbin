package zju.ccnt.tcm.query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import zju.ccnt.tcm.model.OntoModel;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSetFormatter;
import com.hp.hpl.jena.rdf.model.RDFNode;

public class QueryManager {
	private OntModel ontoModel;
	private static String queryHead = "PREFIX fe:<http://www.semanticweb.org/ontologies/2009/11/Ontology/wuxing.owl#> " +
		"PREFIX rdfs:<http://www.w3.org/2000/01/rdf-schema#> " + 
	   "PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#> ";
	private static String head = "SELECT ?res WHERE { fe:";
	private static String cause = " fe:导致";
	private static String symptom = " fe:表现为 ";
	private static String tail = " ?res.}";

	
	public QueryManager(OntModel globalModel) {
		ontoModel = globalModel;
	}
	/*
	 * 根据sparql语句查询
	 */
	public ArrayList<String> getResultsList(String queryStr) {
		com.hp.hpl.jena.query.Query query = QueryFactory.create(queryHead + queryStr);
		QueryExecution qe = QueryExecutionFactory.create(query, ontoModel);
		com.hp.hpl.jena.query.ResultSet rs = qe.execSelect();
		
		QuerySolution qs;
//		List<RDFNode> resultList = new ArrayList<RDFNode>();
		ArrayList<String> resultList = new ArrayList<String>();
		while(rs.hasNext()){
		   qs = rs.nextSolution();
		   RDFNode z = qs.get("res");
		   if(z != null) {
			//   resultList.add(z);
			   String[] result = z.toString().split("#");
			   resultList.add(result[1]);
		//	   System.out.println(result[1]);
			   }
		   }
		  qe.close();
		  return resultList;
	}
	
	
	public ArrayList<String> getMultiResultsList(String queryStr) {
		com.hp.hpl.jena.query.Query query = QueryFactory.create(queryHead + queryStr);
		QueryExecution qe = QueryExecutionFactory.create(query, ontoModel);
		com.hp.hpl.jena.query.ResultSet rs = qe.execSelect();
		
		QuerySolution qs;
//		List<RDFNode> resultList = new ArrayList<RDFNode>();
		ArrayList<String> resultList = new ArrayList<String>();
		while(rs.hasNext()){
		   qs = rs.nextSolution();
		   String organA = ((RDFNode)qs.get("organA")).toString().split("#")[1];
		   String organB = ((RDFNode)qs.get("organB")).toString().split("#")[1];
		   String elemtA = ((RDFNode)qs.get("elemtA")).toString().split("#")[1];
		   String elemtB = ((RDFNode)qs.get("elemtB")).toString().split("#")[1];
		   
		   if(organA != null && organB != null && elemtA != null && elemtB != null) {
			//   resultList.add(z);
			   resultList.add(organA);
	//		   System.out.println(organA);
			   resultList.add(elemtA);
	//		   System.out.println(elemtA);
			   resultList.add(organB);
	//		   System.out.println(organB);
			   resultList.add(elemtB);
	//		   System.out.println(elemtB);
			   }
		   }
		  qe.close();
		  return resultList;
	}
	
	public Map<String, ArrayList<String>> getTotalResults(String queryStr) {
		String[] splitArray = queryStr.split("fe:");
		String initStr = splitArray[1].trim();
		com.hp.hpl.jena.query.Query query = QueryFactory.create(queryHead + queryStr);
		QueryExecution qe = QueryExecutionFactory.create(query, ontoModel);
		com.hp.hpl.jena.query.ResultSet rs = qe.execSelect();
		
		QuerySolution qs;
	//	Map<String, ArrayList<RDFNode>> map= new HashMap<String, ArrayList<RDFNode>>();
	//	Set<RDFNode> resultSet = new HashSet<RDFNode>();
		Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
	//	ArrayList<RDFNode> resultList = new ArrayList<RDFNode>();
		ArrayList<String> resultList = new ArrayList<String>();
		ArrayList<String> nextQuery = new ArrayList<String>();
		while (rs.hasNext()) {
			qs = rs.nextSolution();
			RDFNode z = qs.get("res");
			if (z != null) {
			//	resultList.add(z);
				String[] result = z.toString().split("#");
				resultList.add(result[1]);
				nextQuery.add(result[1]);
		//		System.out.println(result[1] + "--->");
			}
		}
		qe.close();
		map.put(initStr, resultList);
		
//		System.out.println();
		generateResult(resultList, map, ontoModel);
		
		return map;
	}

	public void generateResult(ArrayList<String> loopQueryArr, Map<String, ArrayList<String>> map, OntModel model) {
		ArrayList<String> nextQueryArr = new ArrayList<String>();
	
		if (loopQueryArr != null) {
			for (Iterator itr = loopQueryArr.iterator(); itr.hasNext(); ) {
				String loopQueryStr = itr.next().toString();
		//		System.out.println(loopQueryStr + "--->");
				ArrayList<String> resultList = new ArrayList<String>();
				String currQueryStr = loopQueryStr;
				String nextQueryStr = head + loopQueryStr + cause + tail;
				com.hp.hpl.jena.query.Query loopQuery = QueryFactory.create(queryHead + nextQueryStr);
				QueryExecution loopQe = QueryExecutionFactory.create(loopQuery, model);
				com.hp.hpl.jena.query.ResultSet loopRs = loopQe.execSelect();
					
				QuerySolution loopQs;		
				while (loopRs.hasNext()) {
					loopQs = loopRs.nextSolution();
					RDFNode n = loopQs.get("res");
					if (n != null) {
					//	resultList.add(n);
						String[] result = n.toString().split("#");
						resultList.add(result[1]);
						nextQueryArr.add(result[1]);
		//				System.out.println(result[1] + "--->");
					} 				
				}
				map.put(currQueryStr, resultList);
				loopQe.close();
				
				if (resultList.size() != 0) {
					generateResult(resultList, map, model);
				}
		//		System.out.println();
			}
		}
	}
	
	

}

