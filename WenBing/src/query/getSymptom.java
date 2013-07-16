package query;

import java.util.ArrayList;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.rdf.model.ResIterator;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;
import com.hp.hpl.jena.vocabulary.RDF;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.Iterator;

import module.Constant;
import module.Module;
import bean.*;

public class getSymptom {
	private String prex = Constant.prex;
	public ArrayList<String> getSymptomByCate(String category){
		
		return null;
	}
	public ArrayList<symptomInsBean> getSympInstanceByCate(String symcate,OntModel model){
		ArrayList<symptomInsBean> sympList = new ArrayList<symptomInsBean>();
		ResIterator iter = model.listSubjectsWithProperty(RDF.type,
				model.getResource(prex+symcate));
		int i=1;
		while(iter.hasNext()){
			Resource sym = (Resource) iter.next();
			sympList.add(new symptomInsBean(i++,sym.getLocalName(),true)); 
			System.out.println(sym.getLocalName());
		}
		return sympList;
	}
	public ArrayList<symptomBean> getSymptomCate(OntModel model){
		ArrayList<symptomBean> symCateList = new ArrayList<symptomBean>();
		OntClass ontclass = model.getOntClass(prex+"症状和体征");
		int i=1;
		 for (Iterator it = ontclass.listSubClasses(true); it.hasNext();){
		     System.out.print("  Class ");
		     OntClass sb = (OntClass) it.next();
		     System.out.println("症状和体征"
		       + "'s subClass is "
		       + sb.getLocalName());
		     symCateList.add(new symptomBean(i++,sb.getLocalName(),true)); 		     
		//     getSympInstanceByCate(sb.getLocalName(),model);
		    }
		return symCateList;
	}
	
	
	/**
	 * get symptomTree
	 */
	public String getSymptomTree(OntModel model){
		OntClass res = model.getOntClass(prex+"症状和体征");
		Document doc = DocumentHelper.createDocument();
		Element e = doc.addElement("tree");
		getSubClassTree(e, res);
		return e.asXML();
	}
	/**
	 * get sub symptom tree
	 */
	private void getSubClassTree(Element e, OntClass r){
		e.addAttribute("label",r.getLocalName());
		ExtendedIterator children = r.listSubClasses(true);
		while (children.hasNext()) {
			OntClass child = (OntClass) children.next();
			Element childEle = e.addElement("tree");
			getSubClassTree(childEle, child);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OntModel model = new Module().getInfmodel();
		getSymptom getSym = new getSymptom();
	//	getSym.getSymptomCate(model);
		System.out.println(getSym.getSymptomTree(model));
	}

}
