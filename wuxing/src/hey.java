import java.util.*;

import com.hp.hpl.jena.ontology.OntModel;

import zju.ccnt.tcm.model.OntoModel;
import zju.ccnt.tcm.query.*;


public class hey {
	
	public hey()
	{
		
	}
	
	public String [] getReasoning(String [] name)
	{
		OntoModel ontoModel = new OntoModel();
		OntModel model = ontoModel.readModel();
		ReasonMachine rm = new ReasonMachine(model);
		ArrayList<String> s = new ArrayList<String>();
		ArrayList<String> temp = new ArrayList<String>();
		temp.add(name[0]);
		temp.add(name[1]);
		s = rm.getLink(temp);
		String [] sa = new String[6];
		sa[0] = name[0];
		sa[1] = name[1];
		System.out.println("##############3");
		System.out.println(temp.get(0));
		System.out.println(temp.get(1));
		for (int i = 0; i < s.size(); ++i)
		{
			sa[i + 2] = s.get(i).toString();
			System.out.println("ASDF"+s.get(i)+"ASDF");
		}
		for(int i = 0; i < 6; ++i)
		{
			System.out.println("ASDF"+sa[i]+"ASDF");
		}
		
		return sa;
	}
}
