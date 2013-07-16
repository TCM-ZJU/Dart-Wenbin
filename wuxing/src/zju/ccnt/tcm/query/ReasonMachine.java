package zju.ccnt.tcm.query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.rdf.model.RDFNode;

import zju.ccnt.tcm.model.Emotion;
import zju.ccnt.tcm.model.Herbal;
import zju.ccnt.tcm.model.Link;
import zju.ccnt.tcm.model.Subject;
import zju.ccnt.tcm.model.Symptom;
import zju.ccnt.tcm.model.Therapy;
import zju.ccnt.tcm.model.TreatMethod;
import zju.ccnt.tcm.model.TreatRule;
import zju.ccnt.tcm.model.Xie;

public class ReasonMachine implements ReasonEntry {
	private static OntModel ontoModel;
	private static String[] emotionArr = {"怒","喜","忧","思","恐","悲","惊"};
	private static String[] xieArr = {"风邪","寒邪","湿邪","火邪","热邪","燥邪"};
	
	public ReasonMachine(OntModel globalModel) {
		setOntoModel(globalModel);
	}
	
	// return: ArrayList<String>
	// 方剂的中药集合
	public String getHerbal(String therapy) {
		Herbal herb = new Herbal();
		String herbList = herb.getHerbal(therapy);		
		return herbList;
	}

	// return: ArrayList<String>
	// 症状集合
	public ArrayList<String> getSymptom(String currObject) {
		Symptom symptomEntry = new Symptom(ontoModel);
		ArrayList<String> symptomList = symptomEntry.getSymptom(currObject);
		
		return symptomList;
	}

	// return: ArrayList<String>
	// 主体集合
	public ArrayList<String> getSubject(String currObject) {
		Subject sub = new Subject(ontoModel);
		ArrayList<String> subResult = sub.getSubject(currObject);
		
		return subResult;
	}

	// return: ArrayList<String>
	// 证候对应的方剂集合
	public ArrayList<String> getTheraphy(String currObject) {
		Therapy therapy = new Therapy(ontoModel);
		ArrayList<String> therapyList = therapy.getTherapy(currObject);
		
		return therapyList;
	}

	// 返回病机推理结果
	public Map<String, ArrayList<String>> getTotalResults(int num, String[] query) {
		Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		ArrayList<String> queryStr = new ArrayList<String>();
		for (int i = 0; i < num; i++) {
			queryStr.add(query[i]);
		}

		if (queryStr.size() == 1) {
			if (isEmotion(queryStr)) {
				Emotion emotion = new Emotion(ontoModel);
				map = emotion.getEmotionCauseDisease(queryStr.get(0));
			} else {
				Xie xie = new Xie(ontoModel);
				map = xie.getXieCauseGraph(queryStr.get(0));
			}
		}else {
			Xie xie = new Xie(ontoModel);
			map = xie.getXieCauseDisease(queryStr);
		}
		
		return map;
	}

	// return: String
	// 证候对应的治则，唯一
	public String getTreatMethod(String currObject) {
		TreatMethod treatMethod = new TreatMethod(ontoModel);
		String treatM = treatMethod.getTreatMethod(currObject);
		
		return treatM;
	}

	// return: String
	// 证候对应的治法，唯一
	public String getTreatRule(String currObject) {
		TreatRule treatRule = new TreatRule(ontoModel);
		String treatR = treatRule.getTreatRule(currObject);
		
		return treatR;
	}


	public ArrayList<String> getLink(ArrayList<String> objects) {
		Link link = new Link(ontoModel);
		ArrayList<String> linkResult = new ArrayList<String>();
		linkResult = link.getLink(objects);
		
		return linkResult;
	}
	
	
	public boolean isEmotion(ArrayList<String> str) {
		boolean flag = false;
		
		for (int i = 0; i < emotionArr.length; i++) {
			if (str.get(0).equals(emotionArr[i])) {
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	
	public boolean isZhengHou(String subject) {
		boolean flag = false;
		String queryStr = "SELECT ?res WHERE { fe:" + subject + " rdf:type ?res.}"; 
		String queryHead = "PREFIX fe:<http://www.semanticweb.org/ontologies/2009/11/Ontology/wuxing.owl#> " +
		"PREFIX rdfs:<http://www.w3.org/2000/01/rdf-schema#> " + 
	   "PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#> ";
		com.hp.hpl.jena.query.Query query = QueryFactory.create(queryHead + queryStr);
		QueryExecution qe = QueryExecutionFactory.create(query, ontoModel);
		com.hp.hpl.jena.query.ResultSet rs = qe.execSelect();
		
		QuerySolution qs;
		while (rs.hasNext()) {
			qs = rs.nextSolution();
			RDFNode z = qs.get("res");
			if (z != null) {
			//	resultList.add(z);
				String[] result = z.toString().split("#");
				if (result[1].equals("证候")) {
					flag = true;
				}
			}
		}
		qe.close();
		
		return flag;
	}
	
	
	public void printMap(Map<String, ArrayList<String>> map) {
		if (!map.isEmpty()) {
			Set<String> stringSet = map.keySet();
			
			for (int i = 0; i < stringSet.size(); i++) {
				String key = (String) stringSet.toArray()[i];
				System.out.println(key);
				
				ArrayList<String> valList = map.get(key);
				if (valList != null) {
					for (int j = 0; j < valList.size(); j++ ) {
						String val = valList.get(j).toString();
						System.out.println("\t" + val);
					}
				}
			}
		}
	}
	
	
	public static OntModel getOntoModel() {
		return ontoModel;
	}

	public static void setOntoModel(OntModel ontoModel) {
		ReasonMachine.ontoModel = ontoModel;
	}
}
