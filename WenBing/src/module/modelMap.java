package module;

import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.vocabulary.RDF;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.reasoner.rulesys.Rule;
import com.hp.hpl.jena.reasoner.Reasoner;
import com.hp.hpl.jena.reasoner.rulesys.GenericRuleReasoner;
import com.hp.hpl.jena.ontology.OntModelSpec;
import java.util.HashMap;
import java.util.HashSet;
public class modelMap {
	HashMap<String,String> nodes = null;
	HashSet<ObjectProperty> edges = null;
	HashSet<ObjectProperty> dels = null;
	public String getmodelMap(OntModel model){
		Document doc = DocumentHelper.createDocument();
		Element e = doc.addElement("model");
		Element classes = e.addElement("Nodes");
		OntClass ontclass = model.getOntClass("http://www.w3.org/2002/07/owl#Thing");
		int i = 1;
		nodes = new HashMap<String,String>();
		for (Iterator it = ontclass.listSubClasses(true); it.hasNext();){
			OntClass ont = (OntClass)it.next();
			String local = ont.getLocalName();
			if(local != null && ont.getURI()!="http://www.w3.org/2002/07/owl#Nothing"){
			//	System.out.println(ont.getLocalName());	
				Element classE = classes.addElement("Node");
				classE.addAttribute("id", ""+i);
				Element label = classE.addElement("Label");
				label.setText(local);
				Element Uri = classE.addElement("Uri");
				Uri.setText(ont.getURI());
				Element Type = classE.addElement("Type");
				Type.setText(local);
				nodes.put(local, ""+(i++));
			}	
		}
		Element properties = e.addElement("Edges");
		edges = new HashSet<ObjectProperty>();
		for(Iterator it = model.listObjectProperties(); it.hasNext();){
			ObjectProperty obj = (ObjectProperty)it.next();
//			System.out.println(obj.getLocalName());
			boolean bool = obj.getLocalName().matches("[a-zA-Z]+");
			if(!bool && !obj.getLocalName().equals("三焦辩证") && !obj.getLocalName().equals("卫气营血辩证")){
				System.out.println(obj.getLocalName());
				edges.add(obj);
			}
		}
		int j = 1;
		for(Iterator edge = edges.iterator();edge.hasNext();){
			ObjectProperty obj = (ObjectProperty)edge.next();
			System.out.println(obj.getURI());
			String domain = "";
			for(Iterator domainlist = obj.listDomain();domainlist.hasNext();){
				OntClass dom = (OntClass)domainlist.next();
				System.out.println(dom.getURI());
				try{
				if(dom!=null && !dom.getLocalName().matches("[a-zA-Z]+")){
					domain = dom.getLocalName();
				}
				}catch(NullPointerException ex){
					ex.printStackTrace();
				}
			}
			String range = "";
			for(Iterator rangelist = obj.listRange();rangelist.hasNext();){
				OntClass rang = (OntClass)rangelist.next();
				System.out.println(rang.getLocalName());
				if(!rang.getLocalName().matches("[a-zA-Z]+")){
					range = rang.getLocalName();
				}
			}
			
			if(domain != "" ){
				System.out.println(obj.getLocalName()+":  "+domain +" -- " + range);
				Element ObjE = properties.addElement("Edge");
				ObjE.addAttribute("id",""+(j++));
				Element label = ObjE.addElement("Label");
				label.setText(obj.getLocalName());
				Element Uri = ObjE.addElement("Uri");
				Uri.setText(obj.getURI());
				Element from = ObjE.addElement("FromId");
				from.setText(nodes.get(domain));
				Element to = ObjE.addElement("ToId");
				to.setText(nodes.get(range));	
			}					
		}
		return e.asXML();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OntModel model = new Module().getInfmodel();
		modelMap map = new modelMap();
		System.out.println(map.getmodelMap(model));
	}
}
