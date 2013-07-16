package zju.ccnt.tcm.model;

import java.util.List;

import zju.ccnt.tcm.query.QueryManager;

import com.hp.hpl.jena.ontology.OntModel;

public class TreatMethod {
private OntModel ontoModel;
	
	public TreatMethod(OntModel globalModel) {
		ontoModel = globalModel;
	}
	
	public String getTreatMethod(String object) {
		QueryManager queryManager = new QueryManager(ontoModel);
		String queryStr = "SELECT ?res WHERE { fe:" 
			+ object + " fe:治法为 ?res.}";	
		
		System.out.println(object + "的治法为：");
		List treatMthList = queryManager.getResultsList(queryStr);
		String treatM = "";
		
		if (!treatMthList.isEmpty()) {
			treatM = treatMthList.get(0).toString();
		}
		
		return treatM;
	}
	
}
