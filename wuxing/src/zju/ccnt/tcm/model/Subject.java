package zju.ccnt.tcm.model;

import java.util.ArrayList;
import java.util.List;
import zju.ccnt.tcm.query.QueryManager;
import com.hp.hpl.jena.ontology.OntModel;

public class Subject {
private OntModel ontoModel;
	
	public Subject(OntModel globalModel) {
		ontoModel = globalModel;
	}
	
	public ArrayList<String> getSubject(String object) {
		QueryManager queryManager = new QueryManager(ontoModel);
		String queryStr = "SELECT ?res WHERE { fe:" 
			+ object + " fe:����Ϊ ?res.}";	
		
		System.out.println(object + "������Ϊ��");
		ArrayList<String> resultList = queryManager.getResultsList(queryStr);
				
		return resultList;
	}
	
}