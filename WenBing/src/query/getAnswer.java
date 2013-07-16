package query;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.RDFNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;

import module.Constant;
import module.Module;
import match.matchSymptoms;
import bean.suggestionBean;
import bean.TreatmentFormulaBean;

public class getAnswer {

	private String getQuerystr(HashSet<String> symptom){
		StringBuffer str = new StringBuffer();
		str.append("PREFIX wenbing:<"+Constant.prex+"> ");
		str.append("PREFIX rdfs:<http://www.w3.org/2000/01/rdf-schema#> ");
		str.append("PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#> ");
		str.append("SELECT  ?fj	");
		str.append("WHERE { ");
		Iterator<String> iter = symptom.iterator();
		while(iter.hasNext()){
			str.append("?hz wenbing:有症状 wenbing:"+iter.next()+". ");
		}
		str.append("	?hz wenbing:有证候 ?zh.");   // 证候
		str.append(" ?zf wenbing:依据 ?zh. ");   // 治法
		str.append(" ?zf wenbing:选用 ?fj. }");  // 方剂
		System.out.println("query str is: "+str.toString());
		return str.toString();
	}
	private static Map getResultsList(OntModel model,String querystr){
		Query query = QueryFactory.create(querystr);
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		ResultSet rs = qe.execSelect();
		System.out.println("rs.getResultVar--"+rs.getResultVars());
		QuerySolution qs;
		Set<RDFNode> resultset = new HashSet<RDFNode>();
		System.out.println("result length: "+ rs.hasNext());
		while(rs.hasNext()){
			qs = rs.nextSolution();
//			RDFNode hz = qs.get("hz");
//			if(hz != null)
//				resultset.add(hz);
//			System.out.println("result 患者 is :"+hz.toString());
//			RDFNode zh = qs.get("zh");
//			if(zh != null)
//				resultset.add(zh);	
//			System.out.println("result 证候 is :"+zh.toString());
//			RDFNode zf = qs.get("zf");
//			if(zf != null)
//				resultset.add(zf);	
//			System.out.println("result 治法 is :"+zf.toString());
			RDFNode fj = qs.get("fj");
			if(fj != null)
				resultset.add(fj);	
			System.out.println("result 方剂 is :"+fj.toString());
		}
		qe.close();
		return null;
	}
	
	String syndrome = null;
	ArrayList<String> treatment = new ArrayList<String>();
	ArrayList<String> formula = new ArrayList<String>();
	ArrayList<TreatmentFormulaBean> treatForlist;
	suggestionBean suggestion;
	
	public String getanswer(String[] strs){
		OntModel model = new Module().getInfmodel();
		HashSet<String> hash = new matchSymptoms().match(strs);
		treatForlist = new ArrayList<TreatmentFormulaBean>();
		
		suggestion = new suggestionBean();
		QuerySyndrome querySyn = new QuerySyndrome();
		syndrome = QuerySyndrome.getResultsList(model,querySyn.getQuerystr(hash));
		suggestion.setSyndrom(syndrome);
		
		QueryTreatment queryTre = new QueryTreatment();
		treatment = QueryTreatment.getResultsList(model,queryTre.getQuerystr(syndrome));
		
		for(int i=0; i<treatment.size(); i++){
			QueryFormula queryFor = new QueryFormula();
			formula = QueryFormula.getResultsList(model,queryFor.getQuerystr(treatment.get(i)));
			TreatmentFormulaBean treatFor = new TreatmentFormulaBean();
			treatFor.setTreatment(treatment.get(i));
			treatFor.setFormula(formula);
			treatForlist.add(treatFor);
		}
		suggestion.setTreatformula(treatForlist);
		
	//	String querystr = getQuerystr(hash);
	//	getResultsList(model, querystr);
		return suggestion.toXML();
	}	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OntModel model = new Module().getInfmodel();
		getAnswer query = new getAnswer();
		HashSet<String> list = new HashSet<String>();
		list.add("壮热");
		list.add("汗多");
		list.add("口渴");
		list.add("心烦");
		list.add("头痛");
		list.add("头晕");
		
//		list.add("面红");
//		list.add("目赤");
	
		list.add("微恶寒");
		
		list.add("气粗");
		list.add("苔黄");
		list.add("苔燥");
		list.add("脉洪");
		list.add("脉数");
		String querystr = query.getQuerystr(list);
		query.getResultsList(model, querystr);
	}

}
