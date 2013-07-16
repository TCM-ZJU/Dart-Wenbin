import java.util.ArrayList;

import com.hp.hpl.jena.ontology.OntModel;

import zju.ccnt.tcm.model.Emotion;
import zju.ccnt.tcm.model.Herbal;
import zju.ccnt.tcm.model.Link;
import zju.ccnt.tcm.model.OntoModel;
import zju.ccnt.tcm.model.Symptom;
import zju.ccnt.tcm.model.Xie;
import zju.ccnt.tcm.query.QueryManager;
import zju.ccnt.tcm.query.ReasonMachine;

public class Main {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static void main(String[] args)  {
		OntoModel ontoModel = new OntoModel();
		OntModel model = ontoModel.readModel();
		
	//	Link link = new Link(model);
	//	ArrayList<String> zheng = new ArrayList<String>();
	//	zheng.add("¸Î»ð³ãÊ¢");
	//	zheng.add("ÐÄ»ð¿ºÊ¢");
	//	link.getLink(zheng);
	}
}
