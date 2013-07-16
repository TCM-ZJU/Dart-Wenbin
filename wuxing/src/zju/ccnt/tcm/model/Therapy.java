package zju.ccnt.tcm.model;

import java.util.ArrayList;
import zju.ccnt.tcm.query.QueryManager;

import com.hp.hpl.jena.ontology.OntModel;

public class Therapy {
	private OntModel ontoModel;
	
	public Therapy(OntModel globalModel) {
		ontoModel = globalModel;
	}
	
	public ArrayList<String> getTherapy(String object) {
		QueryManager queryManager = new QueryManager(ontoModel);
		String queryStr = "SELECT ?res WHERE { fe:" 
			+ object + " fe:方剂为 ?res.}";	
		
		System.out.println(object + "的方剂如下：");
		ArrayList<String> resultList = queryManager.getResultsList(queryStr);
		
		return resultList;
	}

}
