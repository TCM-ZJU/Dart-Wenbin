import java.util.*;

import com.hp.hpl.jena.ontology.OntModel;

import zju.ccnt.tcm.model.OntoModel;
import zju.ccnt.tcm.query.*;

public class hi {
	
	public hi()
	{
		
	}
	
	public String [] getReasoning(String name)
	{
		OntoModel ontoModel = new OntoModel();
		OntModel model = ontoModel.readModel();
		ReasonMachine rm = new ReasonMachine(model);
		
		ArrayList<String> s = new ArrayList<String>();
		s = rm.getSubject(name);
		
		String [] sa = new String[3];
		CreateXML a = new CreateXML();
		System.out.print(a.text1(name));
		sa[0]="";
		System.out.println("@@@@@@@@@@");
		System.out.println(s.size());
		for (int i = 0; i < s.size(); ++i)
			sa[0] += "<font size = '20' color = '#0000ff' ><b><u>"+s.get(i)+"</u></b></font>   ";
		s.clear();
		s = rm.getSymptom(name);
		System.out.println("@@@@@@@@@@");
		System.out.println(rm.getSymptom(name).size());
		sa[1]="";
		
		for (int i = 0; i < s.size(); ++i)
		{
			sa[1] += "<font size = '"+(10 +(int) (Math.random() * 20)) +"' color = '#0000ff' ><b><u>"+s.get(i)+"</u></b></font>   ";
		}
		System.out.println(sa[1]);
		sa[2]=a.text1(name);
		System.out.println(a.text1(name));
		return sa;
	}

}
