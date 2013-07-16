package zju.ccnt.tcm.model;

import java.util.ArrayList;
import java.util.Map;
import zju.ccnt.tcm.query.QueryManager;

import com.hp.hpl.jena.ontology.OntModel;

public class Emotion {
	private OntModel ontoModel;
	
	public Emotion(OntModel globalModel) {
		ontoModel = globalModel;
	}
	
	public Map<String, ArrayList<String>> getEmotionCauseDisease(String emotion) {
		QueryManager queryManager = new QueryManager(ontoModel);
		String queryStr = "SELECT ?res WHERE { fe:" 
			+ emotion + " fe:¹ý¶È ?res.}";	
		
		System.out.println(emotion + "--->");
		Map resultMap = queryManager.getTotalResults(queryStr);
		
		return resultMap;
	}

	public OntModel getOntoModel() {
		return ontoModel;
	}

	public void setOntoModel(OntModel ontoModel) {
		this.ontoModel = ontoModel;
	}
}