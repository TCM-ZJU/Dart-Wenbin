package zju.ccnt.tcm.query;

import java.util.List;

import com.hp.hpl.jena.ontology.OntModel;

public class NextStage {
	private static OntModel ontoModel;
	
	public NextStage(OntModel globalModel){
		setOntoModel(globalModel);
	}
	
	public static List getNextStage(String current) {
			QueryManager queryManager = new QueryManager(ontoModel);
			String queryStr = "SELECT ?res WHERE { fe:" 
				+ current + " fe:µ¼ÖÂ ?res.}";	
			
			System.out.println(current + "--->");
			List resultList = queryManager.getResultsList(queryStr);
			
			return resultList;
		}

	public static OntModel getOntoModel() {
		return ontoModel;
	}

	public static void setOntoModel(OntModel ontoModel) {
		NextStage.ontoModel = ontoModel;
	}
}

