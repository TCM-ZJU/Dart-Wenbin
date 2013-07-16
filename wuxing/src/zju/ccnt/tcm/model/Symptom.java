package zju.ccnt.tcm.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import zju.ccnt.tcm.query.QueryManager;

import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.ontology.OntModelSpec;

public class Symptom {
	private OntModel ontoModel;
	
	public Symptom(OntModel globalModel) {
		ontoModel = globalModel;
	}
	
	public ArrayList<String> getSymptom(String object) {
	//	QueryManager queryManager = new QueryManager(ontoModel);
	//	String queryStr = "SELECT ?res WHERE { fe:" 
	//		+ object + " fe:Ö¢×´±íÏÖÎª ?res.}";	
		
	//	System.out.println(object + "µÄÖ¢×´ÈçÏÂ£º");
	//	ArrayList<String> resultList = queryManager.getResultsList(queryStr);
		ArrayList<String> resultList = new ArrayList<String>();
		
		if (object.equals("¸ÎÓôÆ¢Ğé")) {
			resultList.add("±ãäç");
			resultList.add("ÑáÊ³");
			resultList.add("´ó±ãÊ±¸ÉÊ±äç");
			resultList.add("Ì«Ï¢");
			resultList.add("ÏÒÂö");
			resultList.add("ÇéĞ÷µÍÂä");
			resultList.add("ÅÅ±ã²»Ë¬");
			resultList.add("°×Ì¦");
			resultList.add("»ºÂö");
			resultList.add("ÕÍÍ´");
			resultList.add("ĞØĞ²ëä¸¹²¿");
			resultList.add("¸¹Ğº");
			resultList.add("¸¹Í´Óû±ã±ãºóÍ´¼õ");
			resultList.add("¸¹ÕÍ");
			resultList.add("×ß´ÜÍ´");
			
			return resultList;
			
		} else if (object.equals("ĞÄ»ğ¿ºÊ¢")) {
			resultList.add("±ãÃØ");
			resultList.add("·¢ÈÈ");
			resultList.add("¿Ú¿Ê");
			resultList.add("Ê§Ãß");
			resultList.add("ĞÄ·³");
			resultList.add("ÊıÂö");
			resultList.add("ÂúÃæÍ¨ºì");
			resultList.add("»ÆÌ¦");
			resultList.add("¿ÚÉàÉú´¯/Éà¼âºì");
			resultList.add("Ğ¡±ã×ÆÈÈ/Ğ¡±ã¶Ì»Æ/ÄòµÀÉ¬Í´");
			
			return resultList;
		} else if (object.equals("¸Î»ğ·¸·Î")) {
			resultList.add("¿ÈËÔ");
			resultList.add("¼±ÔêÒ×Å­");
			resultList.add("ÂúÃæÍ¨ºì");
			resultList.add("Ä¿³à");
			resultList.add("ºìÉà");
			resultList.add("¿Ú¸É");
			resultList.add("¿Ú¿à");
			resultList.add("Í·ÔÎ");
			resultList.add("Í·Í´");
			resultList.add("ÕÍÍ´");
			resultList.add("ÏÒÂö");
			resultList.add("ÊıÂö");
			resultList.add("×ÆÍ´");
			resultList.add("Ğ²Í´");
			resultList.add("±¡Ì¦");
			resultList.add("»ÆÌ¦");
			resultList.add("¿©Ñª");
			resultList.add("¿©Ñª/ÌµÖĞ´øÑª/Ìµ»Æ³í");
			
			return resultList;
		} else if (object.equals("ÌµÈÈÛÕ·Î")) {
			resultList.add("±ãÃØ");
			resultList.add("·¢ÈÈ");
			resultList.add("¿Ú¿Ê");
			resultList.add("¿ÈËÔ");
			resultList.add("ºíÖĞÌµÃù");
			resultList.add("´­");
			resultList.add("Ğ¡±ã¶Ì»Æ");
			resultList.add("Ï¢´Ö");
			resultList.add("ÊıÂö");
			resultList.add("»¬Âö");
			resultList.add("·³Ôê²»°²");
			resultList.add("Ìµ»Æ³í");
			resultList.add("ºìÉà");
			resultList.add("ÄåÌ¦");
			resultList.add("»ÆÌ¦");
			resultList.add("±ÇÒíÉ¿¶¯");
			
		} else if (object.equals("¸Î»ğ³ãÊ¢")) {
			resultList.add("±ãÃØ");
			resultList.add("Ğ¡±ã¶Ì»Æ");
			resultList.add("¼±ÔêÒ×Å­");
			resultList.add("ÂúÃæÍ¨ºì");
			resultList.add("Ä¿³à");
			resultList.add("ºìÉà");
			resultList.add("»ÆÌ¦");
			resultList.add("¿Ú¸É");
			resultList.add("¿Ú¿à");
			resultList.add("Í·ÔÎ");
			resultList.add("Í·ÔÎ");
			resultList.add("Í·Í´");
			resultList.add("ÕÍÍ´");
			resultList.add("ÏÒÂö");
			resultList.add("ÊıÂö");
			resultList.add("×ÆÍ´");
			resultList.add("Ğ²Í´");
			resultList.add("¶úÃùÈç³±");
			resultList.add("Í»·¢");
			resultList.add("¶úÁû");
			resultList.add("ÍÂÑª");
			resultList.add("±Çô¬");
			
			return resultList;
		} else if (object.equals("ÊîÊªÉË±í")) {
			resultList.add("·¢ÈÈ");
			resultList.add("¿ÚÖĞÕ³Äå");
			resultList.add("¿Ú¿Ê");
			resultList.add("Í·»èÖØ");
			resultList.add("Ğ¡±ã¶Ì»Æ");
			resultList.add("ÉÙº¹");
			resultList.add("ÊıÂö");
			resultList.add("º¹³öÈÈ²»ÍË");
			resultList.add("·º¶ñ");
			resultList.add("¸¡Âö");
			resultList.add("µ­ºìÉà");
			resultList.add("¿Ê²»¶àÒû");
			resultList.add("ĞØÃÆ");
			resultList.add("ëäÆ¦");
			resultList.add("±¡Ì¦");
			resultList.add("ÖØÍ´");
			resultList.add("»Æ×ÇÌé");
			resultList.add("»ÆÌ¦");
			resultList.add("±ÇÈû");
			
			return resultList;
		} else if (object.equals("·çº®±íÊµÖ¤")) {
			resultList.add("ÖÜÉíÍ´");
			resultList.add("¶ñº®ÖØ·¢ÈÈÇá");
			resultList.add("ÎŞº¹");
			resultList.add("µ­ºìÉà");
			resultList.add("ºóÍ·Á¬ÏîÍ´");
			resultList.add("Ç¿Í´");
			resultList.add("¿ÈËÔ");
			resultList.add("Ìµ°×¶øÇåÏ¡");
			resultList.add("¸¡Âö");
			resultList.add("½ôÂö");
			resultList.add("ÇåÌé");
			resultList.add("±ÇÈû");
			resultList.add("°×Ì¦");
			resultList.add("±¡Ì¦");
			
			return resultList;
		} else if (object.equals("·çº®±íĞéÖ¤")) {
			resultList.add("¶ñº®ÖØ·¢ÈÈÇá");
			resultList.add("º¹³ö¶ñ·ç");
			resultList.add("µ­ºìÉà");
			resultList.add("¿ÈËÔ");
			resultList.add("Ìµ°×¶øÇåÏ¡");
			resultList.add("Í·Í´");
			resultList.add("Ç¿Í´");
			resultList.add("¸¡Âö");
			resultList.add("ÈõÂö");
			resultList.add("ÇåÌé");
			resultList.add("±ÇÈû");
			resultList.add("°×Ì¦");
			resultList.add("±¡Ì¦");
			
			return resultList;
		} else if (object.equals("·çÈÈ±íÖ¤")) {
			resultList.add("·¢ÈÈÖØ¶ñº®Çá");
			resultList.add("¿Ú¿Ê");
			resultList.add("µ­ºìÉà");
			resultList.add("¿ÈËÔ");
			resultList.add("Ìµ»Æ³í");
			resultList.add("ÑÊºíÍ´");
			resultList.add("Ö×Í´");
			resultList.add("ÊıÂö");
			resultList.add("¸¡Âö");
			resultList.add("±¡Ì¦");
			resultList.add("»ÆÌ¦");
			resultList.add("»Æ×ÇÌé");
			resultList.add("±ÇÈû");
			
			return resultList;
		} else if (object.equals("Á¹Ôï")) {
			resultList.add("¿Ú¿Ê");
			resultList.add("ÑÊ¸É");
			resultList.add("´ó±ãÔï½á");
			resultList.add("Í·Í´");
			resultList.add("Ğ¡±ã¶Ì»Æ");
			resultList.add("¸É¿ÈÎŞÌµÉÙÌµ");
			resultList.add("Î¢Í´");
			resultList.add("¶ñº®ÖØ·¢ÈÈÇá");
			resultList.add("ÎŞº¹");
			resultList.add("¸¡Âö");
			resultList.add("ÔïÌ¦");
			resultList.add("ÌµÉÙ¶øğ¤");
			resultList.add("°×Ì¦");
			resultList.add("Æ¤·ô¸ÉÔï");
			resultList.add("½ôÂö");
			resultList.add("±¡Ì¦");
			resultList.add("±Ç¸ÉÎŞÌé");
			
			return resultList;
		} else if (object.equals("ÎÂÔï")) {
			resultList.add("·¢ÈÈÖØ¶ñº®Çá");
			resultList.add("ÑÊºíÍ´");
			resultList.add("ÑÊ¸É");
			resultList.add("´ó±ãÔï½á");
			resultList.add("Í·Í´");
			resultList.add("Ğ¡±ã¶Ì»Æ");
			resultList.add("¸É¿ÈÎŞÌµÉÙÌµ");
			resultList.add("ÊıÂö");
			resultList.add("¸¡Âö");
			resultList.add("µ­ºìÉà");
			resultList.add("ÔïÌ¦");
			resultList.add("ÌµÉÙ¶øğ¤");
			resultList.add("Æ¤·ô¸ÉÔï");
			resultList.add("±¡Ì¦");
			resultList.add("»ÆÌ¦");
			resultList.add("±Ç¸ÉÎŞÌé");
			
			return resultList;
		} 
			
		return resultList;
	}


}

