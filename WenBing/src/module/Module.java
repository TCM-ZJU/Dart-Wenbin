package module;

import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.vocabulary.RDF;
import com.hp.hpl.jena.ontology.OntModel;
import java.io.FileInputStream;
import com.hp.hpl.jena.reasoner.rulesys.Rule;
import com.hp.hpl.jena.reasoner.Reasoner;
import com.hp.hpl.jena.reasoner.rulesys.GenericRuleReasoner;
import java.util.List;
import com.hp.hpl.jena.ontology.OntModelSpec;

public class Module {
	private OntModel model;
	public OntModel getInfmodel(){
		// model = ModelFactory.createOntologyModel();
		Model data = ModelFactory.createDefaultModel();
		String location = this.getClass().getClassLoader().getResource("").getPath();
		System.out.println("file location:"+location);
		location = location.replaceAll("%20"," ");
		String owllocation = location.substring(1)+"etc/wenbing12_21.owl";
		// "D:\\workspace\\WenBing\\WebContent\\WEB-INF\\classes\\etc\\wen.owl";
		try{
			data.read(new FileInputStream(owllocation), "");
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
		List rules = Rule.rulesFromURL(location.substring(1)+"etc/wenbing12_21.rules");
		Reasoner reasoner = new GenericRuleReasoner(rules);
		reasoner.setDerivationLogging(true);
		InfModel inf = ModelFactory.createInfModel(reasoner, data);
		model = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM, inf);
		return model;
	}
	public static void main(String arg[]){
		Module module = new Module();
		OntModel model = module.getInfmodel();
		ResIterator iter = model.listSubjectsWithProperty(RDF.type,
				model.getResource(Constant.prex+"温邪"));
		int i=0;
		while(iter.hasNext()){
			Resource bingyin = (Resource) iter.next();
			System.out.println(bingyin.getLocalName());
			i++;
		}
	}
}
