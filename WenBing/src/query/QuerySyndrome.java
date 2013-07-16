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
import match.matchSymptoms;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Iterator;

import module.Constant;
import module.Module;
public class QuerySyndrome {
	public static String getQuerystr(ArrayList<String> symptom){
		StringBuffer str = new StringBuffer();
		str.append("PREFIX wenbing:<"+Constant.prex+"> ");
		str.append("PREFIX rdfs:<http://www.w3.org/2000/01/rdf-schema#> ");
		str.append("PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#> ");
		str.append("SELECT ?hz ?zh ");
		str.append("WHERE { ");
		Iterator<String> iter = symptom.iterator();
		while(iter.hasNext()){
			str.append("?hz wenbing:有症状 wenbing:"+iter.next()+". ");
		}
		str.append("	?hz wenbing:有证候 ?zh. }");
		System.out.println("query str is: "+str.toString());
		return str.toString();
	}
	public static String getQuerystr(HashSet<String> symptom){
		StringBuffer str = new StringBuffer();
		str.append("PREFIX wenbing:<http://www.semanticweb.org/ontologies/2009/9/Ontology1255418418125.owl#>");
		str.append("PREFIX rdfs:<http://www.w3.org/2000/01/rdf-schema#> ");
		str.append("PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#> ");
		str.append("SELECT ?hz ?zh ");
		str.append("WHERE { ");
		Iterator<String> iter = symptom.iterator();
		while(iter.hasNext()){
			str.append("?hz wenbing:有症状 wenbing:"+iter.next()+". ");
		}
		str.append("	?hz wenbing:有证候 ?zh. }");
		System.out.println("query str is: "+str.toString());
		return str.toString();
	}
	public static String getResultsList(OntModel model,String querystr){
		String syndrome = null;
		Query query = QueryFactory.create(querystr);
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		ResultSet rs = qe.execSelect();
		System.out.println("rs.getResultVar--"+rs.getResultVars());
		QuerySolution qs;
		Set<RDFNode> resultset = new HashSet<RDFNode>();
		System.out.println("result length: "+ rs.hasNext());
		while(rs.hasNext()){
			qs = rs.nextSolution();
			RDFNode hz = qs.get("hz");
			if(hz != null)
				resultset.add(hz);
			System.out.println("result 患者 is :"+hz.toString());
			RDFNode zh = qs.get("zh");
			if(zh != null)
				resultset.add(zh);	
			syndrome = zh.toString();
			System.out.println("result 证候 is :"+syndrome);
			syndrome = syndrome.substring(syndrome.indexOf("#")+1);
			System.out.println(syndrome);
		}
		qe.close();
		return syndrome;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OntModel model = new Module().getInfmodel();
		QuerySyndrome query = new QuerySyndrome();
//		HashSet<String> list = new HashSet<String>();
		ArrayList<String> list = new ArrayList<String>();

		list.add("气粗");
		list.add("头晕");
		list.add("心烦");
		list.add("口渴");
		list.add("脉数");
		list.add("壮热");
//		list.add("面红");
//		list.add("目赤");
	
		list.add("微恶寒");
		


	//	list.add("脉洪");
	//	list.add("苔燥");
		list.add("头痛");
		list.add("汗多");
		list.add("苔黄");

		
	//	String querystr = query.getQuerystr(list);		
		String querystr = query.getQuerystr(new matchSymptoms().match(list));
		query.getResultsList(model, querystr);
	//	String s = new String("PREFIX wenbing:<http://www.semanticweb.org/ontologies/2009/9/Ontology1255418418125.owl#>PREFIX rdfs:<http://www.w3.org/2000/01/rdf-schema#> PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#> SELECT ?hz ?zh WHERE { ?hz wenbing:有症状 wenbing:气粗. ?hz wenbing:有症状 wenbing:头晕. ?hz wenbing:有症状 wenbing:心烦. ?hz wenbing:有症状 wenbing:口渴. ?hz wenbing:有症状 wenbing:脉数. ?hz wenbing:有症状 wenbing:﻿壮热. ?hz wenbing:有症状 wenbing:微恶寒. ?hz wenbing:有症状 wenbing:脉洪. ?hz wenbing:有症状 wenbing:苔燥. ?hz wenbing:有症状 wenbing:头痛. ?hz wenbing:有症状 wenbing:汗多. ?hz wenbing:有症状 wenbing:苔黄. 	?hz wenbing:有证候 ?zh. }");
	//	String d = new String("PREFIX wenbing:<http://www.semanticweb.org/ontologies/2009/9/Ontology1255418418125.owl#>PREFIX rdfs:<http://www.w3.org/2000/01/rdf-schema#> PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#> SELECT ?hz ?zh WHERE { ?hz wenbing:有症状 wenbing:气粗. ?hz wenbing:有症状 wenbing:头晕. ?hz wenbing:有症状 wenbing:心烦. ?hz wenbing:有症状 wenbing:口渴. ?hz wenbing:有症状 wenbing:脉数. ?hz wenbing:有症状 wenbing:壮热. ?hz wenbing:有症状 wenbing:微恶寒. ?hz wenbing:有症状 wenbing:脉洪. ?hz wenbing:有症状 wenbing:苔燥. ?hz wenbing:有症状 wenbing:头痛. ?hz wenbing:有症状 wenbing:汗多. ?hz wenbing:有症状 wenbing:苔黄. 	?hz wenbing:有证候 ?zh. }");
	//	query.getResultsList(model, s);

	}
}
