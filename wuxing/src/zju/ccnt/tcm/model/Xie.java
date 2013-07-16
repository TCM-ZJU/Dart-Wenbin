package zju.ccnt.tcm.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import zju.ccnt.tcm.query.QueryManager;

import com.hp.hpl.jena.ontology.OntModel;

public class Xie {
	private static String[] XieSet = {"��а", "��а", "��а", "ʪа", "��а", "��а"};
	private OntModel ontoModel;
	
	public Xie(OntModel globalModel) {
		ontoModel = globalModel;
	}
	
	public Map<String, ArrayList<String>> getXieCauseGraph(String xie) {
		QueryManager queryManager = new QueryManager(ontoModel);
		String queryStr = "SELECT ?res WHERE { fe:" 
			+ xie + " fe:���� ?res.}";	
		
		System.out.println(xie + "--->");
		Map<String, ArrayList<String>> resultMap = queryManager.getTotalResults(queryStr);
		
		return resultMap;
	}
	
	public String getQueryStr(ArrayList<String> xieList) {
		StringBuffer queryStr = new StringBuffer();
		queryStr.append("SELECT ?res WHERE { ");
		int len = xieList.size();
		
		for (int i = 0; i < len; i++) {
			queryStr.append(" ?e fe:���� fe:");
			queryStr.append(xieList.get(i));
			queryStr.append(".");
		}
		queryStr.append("?e fe:Ӱ�� ?h. ?h fe:�в�֤ ?res.}");
		
		return queryStr.toString();
	}
	
	
	public Map<String, ArrayList<String>> getXieCauseDisease(ArrayList<String> xieList) {
		QueryManager queryManager = new QueryManager(ontoModel);
		String query = getQueryStr(xieList);
		StringBuffer xieStr = new StringBuffer();
		
		for (int i = 0; i < xieList.size(); i++) {
		//	System.out.print(xieList.get(i));
			xieStr.append(xieList.get(i) + "+"); 
		}
		int index = xieStr.toString().lastIndexOf("+");
		String xie = xieStr.substring(0, index);
		System.out.print(xie);
		System.out.println("��֤�����£�");
		ArrayList<String> resultList = new ArrayList<String>();
		ArrayList<String> fakeList = new ArrayList<String>();
		resultList = queryManager.getResultsList(query);
		Map<String, ArrayList<String>> resultMap = new HashMap<String, ArrayList<String>>();

		resultMap.put(xie, resultList);
		if (!resultList.isEmpty()) {
			for (Iterator itr = resultList.iterator(); itr.hasNext(); )  {
				String result = (String) itr.next();
				resultMap.put(result, fakeList);
			}
		}
		return resultMap;
	}
}
