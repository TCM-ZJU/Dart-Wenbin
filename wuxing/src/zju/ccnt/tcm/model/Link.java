package zju.ccnt.tcm.model;

import java.util.ArrayList;

import zju.ccnt.tcm.query.QueryManager;

import com.hp.hpl.jena.ontology.OntModel;

public class Link {
	private OntModel ontoModel;
	
	public Link(OntModel globalModel) {
		ontoModel = globalModel;
	}
	
	public ArrayList<String> getLink(ArrayList<String> objects) {		
		ArrayList<String> link = new ArrayList<String>();
		
		if (objects.size() == 2) {
			String queryStr = "SELECT ?organA ?elemtA ?organB ?elemtA ?elemtB WHERE {"
						+ "fe:" + objects.get(0)+ " fe:����Ϊ ?organA." + "fe:" + objects.get(1) + " fe:����Ϊ ?organB." 
						+ "?organA fe:�� ?elemtA. ?organB fe:�� ?elemtB." + "fe:" + objects.get(0) 
						+ " fe:ĸ������ " + "fe:" + objects.get(1) + ".}";
			QueryManager queryManager = new QueryManager(ontoModel);
			
			link = queryManager.getMultiResultsList(queryStr);
			
		}
		return link;
	}
}
