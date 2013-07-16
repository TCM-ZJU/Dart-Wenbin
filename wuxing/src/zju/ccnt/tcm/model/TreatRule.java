package zju.ccnt.tcm.model;

import java.util.List;

import zju.ccnt.tcm.query.QueryManager;

import com.hp.hpl.jena.ontology.OntModel;

public class TreatRule {
private OntModel ontoModel;
	
	public TreatRule(OntModel globalModel) {
		ontoModel = globalModel;
	}
	
	public String getTreatRule(String object) {
		QueryManager queryManager = new QueryManager(ontoModel);
		String queryStr = "SELECT ?res WHERE { fe:" 
			+ object + " fe:治则为 ?res.}";	
		
		System.out.println(object + "的治则为：");
		List treatRList = queryManager.getResultsList(queryStr);
		String treatRule = "";
		
		if (!treatRList.isEmpty()) {
			treatRule = treatRList.get(0).toString();
		}
		
		return treatRule;
	}

}
