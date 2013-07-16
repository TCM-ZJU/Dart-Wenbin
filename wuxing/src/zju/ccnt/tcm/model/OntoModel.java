package zju.ccnt.tcm.model;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.InfModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.reasoner.Reasoner;
import com.hp.hpl.jena.reasoner.rulesys.GenericRuleReasoner;
import com.hp.hpl.jena.reasoner.rulesys.Rule;

public class OntoModel {
	
	public String getFilePath() {
		return System.getProperty("user.dir");
	}
	
	public OntModel readModel() {
		Model model = ModelFactory.createDefaultModel();
		String location = getFilePath();
		System.out.println("user dir location: " + location);
		System.out.println(OntoModel.class.getResource("/"));
		System.out.println(this.getClass().getClassLoader().getResource("/").getPath());
		System.out.println(OntoModel.class.getClassLoader().getResource(""));
		String owllocation = location + "\\etc\\wuxing.owl";
//		System.out.println(owllocation);
		
		try{
			model.read(new FileInputStream(owllocation), "");
			} catch(Exception e){
				e.printStackTrace();
			}
		
		List rules = Rule.rulesFromURL(location + "\\etc\\wuxing.rules"); 
		Reasoner reasoner = new GenericRuleReasoner(rules); 
		reasoner.setDerivationLogging(true);
		InfModel inf = ModelFactory.createInfModel(reasoner, model);
		OntModel finalModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM, inf); 
		
		return finalModel;			
	}
	
	
	public void listModel(OntModel model) {
	//	OntModel infModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_RULE_INF, model);
	//	int j = 0;
		for (Iterator i = model.listClasses(); i.hasNext();) {
		//	j++;
			OntClass c = (OntClass)i.next();		
			
			
			if (!c.isAnon()) {
				if (c.getLocalName().equals("∏Œ”Ù∆¢–È")) {
					List<OntClass> oc = c.listEquivalentClasses().toList();
					for (Iterator itr = oc.iterator(); itr.hasNext(); ) {
						OntClass lc = (OntClass)itr.next();
						System.out.println(lc.getURI());
					}
				}
			}

	    }
	}
	
}

