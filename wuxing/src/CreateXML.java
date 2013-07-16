import java.io.FileWriter;   
import java.io.IOException;   
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.dom4j.*;       

import com.hp.hpl.jena.ontology.OntModel;

import zju.ccnt.tcm.model.OntoModel;
import zju.ccnt.tcm.query.*;
  
  
public class CreateXML {   
	String basestr=null;
	public String text(Integer number ,String [] name)
	{
		OntoModel ontoModel = new OntoModel();
		OntModel model = ontoModel.readModel();
		ReasonMachine rm = new ReasonMachine(model);
		Map <String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		
		
		ArrayList <data> da = new ArrayList <data>();
		ArrayList <String> sa = new ArrayList<String>();
		
		map = rm.getTotalResults(number, name);
		String [] key = new String[map.keySet().size()];
		if (key.length == 0)
			return null;
		for (int i = 0; i < map.keySet().size(); ++i)
			key[i] = map.keySet().toArray()[i].toString();
		for (int i = 0; i < map.keySet().size(); ++i)
		{
			sa = map.get(key[i]);
		//	System.out.println("******"+key[i]);
		//	System.out.println(sa.size());
		//	for (int j = 0; j < sa.size(); ++j)
		//		System.out.println("        "+sa.get(j));
		}
		
		
		
		for (int i = 0; i < map.keySet().size(); ++i)
		{
			String nam = "";
			for (int j = 0; j < number; ++j)
			{
				if (j == number - 1)
					nam += name[j];
				else
				{
					nam += name[j];
					nam += "+";
				}
			}
			sa = map.get(key[i]);
			if (sa.size() == 0)
			{
				data d = new data();
				d.begin = key[i].trim();
				d.level = -1; 
				d.end = null;
				da.add(d);
			}
			if (key[i].trim().equals(nam))
			{
				for (int j = 0; j < sa.size(); ++j)
				{
					data d = new data();
					d.begin = key[i].trim();
					d.level = 0; 
					d.end = sa.get(j);
					da.add(d);
				}
			}
			else
			{
				for (int j = 0; j < sa.size(); ++j)
				{
					data d = new data();
					d.begin = key[i].trim();
					d.level = -1; 
					d.end = sa.get(j);
					da.add(d);
				}
			}
			
		}
		
	//	for(int i = 0; i < da.size(); ++i)
	//	{
	//		System.out.println(da.get(i).begin+"  "+da.get(i).level+"     "+da.get(i).end);
	//	}
		
		while (!isOK(da))
		{
			for (int i = 0; i < da.size(); ++i)
			{
				if (da.get(i).level == -1)
					da.get(i).level = getlevel(da.get(i).begin, da);
			}
		}
		
		
		
		
		
		int levels = 0;
		for (int i = 0; i < da.size(); ++i)
		{
			if (da.get(i).level > levels)
			{
				levels = da.get(i).level;
			}
		}
		
	//	for (int i = 0; i < da.size(); ++i)
	//	{
	//		System.out.println(da.get(i).begin + "      " + da.get(i).level + "        "+ da.get(i).end);
	//	}
		
		Document doc = DocumentHelper.createDocument();
		Element root =doc.addElement("graph");
		Element Objects = root.addElement("Objects");
		for (int i = 0; i < levels + 1; ++i)
		{
			Element level = Objects.addElement("level");
			if (i == 0)
			{
				Element Object = level.addElement("Object");
				Object.addElement("text").addText(find(0, da));
				System.out.println(find(0, da));
				Object.addElement("type").addText("·ÇÖ¤ºò");
			}
			else
			{
				int k=0;
				for (int j = 0; j < da.size(); ++j)
				{
					
					if (da.get(j).level == i && !isexist(j, da, da.get(j).begin))
					{
						Element Object = level.addElement("Object");
						Object.addElement("text").addText(da.get(j).begin);
						Object.addElement("type").addText((rm.isZhengHou(da.get(j).begin))?"Ö¤ºò":"·ÇÖ¤ºò");
					}
				}
			}
		}
		Element arrows = root.addElement("arrows");
		for (int i = 0; i < da.size(); ++i)
		{
			if (da.get(i).end != null)
			{
				Element arrow = arrows.addElement("arrow");
				arrow.addElement("begin").addText(da.get(i).begin);
				arrow.addElement("end").addText(da.get(i).end);
			}
		}
		/*
		Element level = root.addElement("Objects").addElement("level");
		Element Object = level.addElement("Object");
		Object.addElement("text").addText(name);
		Object.addElement("type").addText("a");
		Element level1 = root.addElement("Objects").addElement("level");
		Element Object1 = level1.addElement("Object");
		Object1.addElement("text").addText("b");
		Object1.addElement("type").addText("Ö¢ºò");
		Element Object2 = level1.addElement("Object");
		Object2.addElement("text").addText("c");
		Object2.addElement("type").addText("Ö¢ºò");
		Element Object3 = level1.addElement("Object");
		Object3.addElement("text").addText("d");
		Object3.addElement("type").addText("d");
		Element level2 = root.addElement("Objects").addElement("level");
		Element Object4 = level2.addElement("Object");
		Object4.addElement("text").addText("e");
		Object4.addElement("type").addText("Ö¢ºò");
		Element Object5 = level2.addElement("Object");
		Object5.addElement("text").addText("f");
		Object5.addElement("type").addText("Ö¢ºò");
		Element Object6 = level2.addElement("Object");
		Object6.addElement("text").addText("g");
		Object6.addElement("type").addText("a");
		Element level3 = root.addElement("Objects").addElement("level");
		Element Object7 = level3.addElement("Object");
		Object7.addElement("text").addText("h");
		Object7.addElement("type").addText("Ö¢ºò");
		
		Element arrows = root.addElement("arrows");
		Element arrow = arrows.addElement("arrow");
		arrow.addElement("begin").addText(name);
		arrow.addElement("end").addText("b");
		Element arrow1 = arrows.addElement("arrow");
		arrow1.addElement("begin").addText(name);
		arrow1.addElement("end").addText("c");
		Element arrow2 = arrows.addElement("arrow");
		arrow2.addElement("begin").addText(name);
		arrow2.addElement("end").addText("d");
		Element arrow3 = arrows.addElement("arrow");
		arrow3.addElement("begin").addText("b");
		arrow3.addElement("end").addText("e");
		Element arrow4 = arrows.addElement("arrow");
		arrow4.addElement("begin").addText("c");
		arrow4.addElement("end").addText("e");
		Element arrow5 = arrows.addElement("arrow");
		arrow5.addElement("begin").addText("d");
		arrow5.addElement("end").addText("f");
		Element arrow6 = arrows.addElement("arrow");
		arrow6.addElement("begin").addText("d");
		arrow6.addElement("end").addText("g");
		Element arrow7 = arrows.addElement("arrow");
		arrow7.addElement("begin").addText("e");
		arrow7.addElement("end").addText("h");
		Element arrow8 = arrows.addElement("arrow");
		arrow8.addElement("begin").addText("f");
		arrow8.addElement("end").addText("h");
		Element arrow9 = arrows.addElement("arrow");
		arrow9.addElement("begin").addText("g");
		arrow9.addElement("end").addText("h");
		*/
		return doc.asXML();
	}
	
	private String find(int level, ArrayList <data> da)
	{
		for(int i = 0; i < da.size(); ++i)
		{
			if (da.get(i).level == level)
				return da.get(i).begin;
		}
		return null;
	}
	
	private Boolean isOK(ArrayList <data> da)
	{
		for (int i = 0; i < da.size(); ++i)
			if (da.get(i).level == -1)
				return false;
		return true;
	}
	
	private Boolean isexist (int temp, ArrayList <data> da, String str)
	{
		for (int i = 0; i < temp; ++i)
		{
			if (da.get(i).begin == str)
				return true;
		}
		return false;
	}
	
	private int objnum(int level, ArrayList <data> da)
	{
		int num = 0;
		for (int i = 0; i < da.size(); ++i)
		{
			if (da.get(i).level == level)
				++num;
		}
		return num + 1;
	}
	
	private int getlevel(String temp, ArrayList <data> da)
	{
		for (int i = 0; i < da.size(); ++i)
		{
			if (da.get(i).end == temp && da.get(i).level != -1)
				return da.get(i).level + 1;
		}
		return -1;
	}
	
	public String text1(String name)
	{
		OntoModel ontoModel = new OntoModel();
		OntModel model = ontoModel.readModel();
		ReasonMachine rm = new ReasonMachine(model);
		
		Document doc = DocumentHelper.createDocument();
		Element root = doc.addElement("root");
		Element node = root.addElement("node").addAttribute("label", "ÖÎÔò:"+rm.getTreatRule(name));
		Element zhifa = node.addElement("node").addAttribute("label", "ÖÎ·¨:"+rm.getTreatMethod(name));
		ArrayList<String> sa = new ArrayList<String>();
		sa = rm.getTheraphy(name);
		for (int i = 0; i < sa.size(); ++i)
		{
			Element fang = zhifa.addElement("node").addAttribute("label", "·½¼Á:" + sa.get(i));
			Element yao = fang.addElement("node").addAttribute("label", "Ò©:" + rm.getHerbal(sa.get(i)));
		}
		
		return doc.asXML();
	}
	public static void main(String[] args) {
		CreateXML a = new CreateXML();
		String [] b = new String[2];
		b[0] = "·çÐ°";
		b[1] = "º®Ð°";
		String [] c = new String[1];
		c[0] = "Å­";
	//	System.out.print(a.text(2,b));
		//System.out.print(a.text(1,c));
	}
}


