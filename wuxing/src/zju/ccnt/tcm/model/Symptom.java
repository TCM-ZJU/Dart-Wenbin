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
	//		+ object + " fe:֢״����Ϊ ?res.}";	
		
	//	System.out.println(object + "��֢״���£�");
	//	ArrayList<String> resultList = queryManager.getResultsList(queryStr);
		ArrayList<String> resultList = new ArrayList<String>();
		
		if (object.equals("����Ƣ��")) {
			resultList.add("����");
			resultList.add("��ʳ");
			resultList.add("���ʱ��ʱ��");
			resultList.add("̫Ϣ");
			resultList.add("����");
			resultList.add("��������");
			resultList.add("�ű㲻ˬ");
			resultList.add("��̦");
			resultList.add("����");
			resultList.add("��ʹ");
			resultList.add("��в�丹��");
			resultList.add("��к");
			resultList.add("��ʹ������ʹ��");
			resultList.add("����");
			resultList.add("�ߴ�ʹ");
			
			return resultList;
			
		} else if (object.equals("�Ļ�ʢ")) {
			resultList.add("����");
			resultList.add("����");
			resultList.add("�ڿ�");
			resultList.add("ʧ��");
			resultList.add("�ķ�");
			resultList.add("����");
			resultList.add("����ͨ��");
			resultList.add("��̦");
			resultList.add("��������/����");
			resultList.add("С������/С��̻�/���ɬʹ");
			
			return resultList;
		} else if (object.equals("�λ𷸷�")) {
			resultList.add("����");
			resultList.add("������ŭ");
			resultList.add("����ͨ��");
			resultList.add("Ŀ��");
			resultList.add("����");
			resultList.add("�ڸ�");
			resultList.add("�ڿ�");
			resultList.add("ͷ��");
			resultList.add("ͷʹ");
			resultList.add("��ʹ");
			resultList.add("����");
			resultList.add("����");
			resultList.add("��ʹ");
			resultList.add("вʹ");
			resultList.add("��̦");
			resultList.add("��̦");
			resultList.add("��Ѫ");
			resultList.add("��Ѫ/̵�д�Ѫ/̵�Ƴ�");
			
			return resultList;
		} else if (object.equals("̵���շ�")) {
			resultList.add("����");
			resultList.add("����");
			resultList.add("�ڿ�");
			resultList.add("����");
			resultList.add("����̵��");
			resultList.add("��");
			resultList.add("С��̻�");
			resultList.add("Ϣ��");
			resultList.add("����");
			resultList.add("����");
			resultList.add("���겻��");
			resultList.add("̵�Ƴ�");
			resultList.add("����");
			resultList.add("��̦");
			resultList.add("��̦");
			resultList.add("����ɿ��");
			
		} else if (object.equals("�λ��ʢ")) {
			resultList.add("����");
			resultList.add("С��̻�");
			resultList.add("������ŭ");
			resultList.add("����ͨ��");
			resultList.add("Ŀ��");
			resultList.add("����");
			resultList.add("��̦");
			resultList.add("�ڸ�");
			resultList.add("�ڿ�");
			resultList.add("ͷ��");
			resultList.add("ͷ��");
			resultList.add("ͷʹ");
			resultList.add("��ʹ");
			resultList.add("����");
			resultList.add("����");
			resultList.add("��ʹ");
			resultList.add("вʹ");
			resultList.add("�����糱");
			resultList.add("ͻ��");
			resultList.add("����");
			resultList.add("��Ѫ");
			resultList.add("����");
			
			return resultList;
		} else if (object.equals("��ʪ�˱�")) {
			resultList.add("����");
			resultList.add("����ճ��");
			resultList.add("�ڿ�");
			resultList.add("ͷ����");
			resultList.add("С��̻�");
			resultList.add("�ٺ�");
			resultList.add("����");
			resultList.add("�����Ȳ���");
			resultList.add("����");
			resultList.add("����");
			resultList.add("������");
			resultList.add("�ʲ�����");
			resultList.add("����");
			resultList.add("��Ʀ");
			resultList.add("��̦");
			resultList.add("��ʹ");
			resultList.add("������");
			resultList.add("��̦");
			resultList.add("����");
			
			return resultList;
		} else if (object.equals("�纮��ʵ֤")) {
			resultList.add("����ʹ");
			resultList.add("���ط�����");
			resultList.add("�޺�");
			resultList.add("������");
			resultList.add("��ͷ����ʹ");
			resultList.add("ǿʹ");
			resultList.add("����");
			resultList.add("̵�׶���ϡ");
			resultList.add("����");
			resultList.add("����");
			resultList.add("����");
			resultList.add("����");
			resultList.add("��̦");
			resultList.add("��̦");
			
			return resultList;
		} else if (object.equals("�纮����֤")) {
			resultList.add("���ط�����");
			resultList.add("�������");
			resultList.add("������");
			resultList.add("����");
			resultList.add("̵�׶���ϡ");
			resultList.add("ͷʹ");
			resultList.add("ǿʹ");
			resultList.add("����");
			resultList.add("����");
			resultList.add("����");
			resultList.add("����");
			resultList.add("��̦");
			resultList.add("��̦");
			
			return resultList;
		} else if (object.equals("���ȱ�֤")) {
			resultList.add("�����ض���");
			resultList.add("�ڿ�");
			resultList.add("������");
			resultList.add("����");
			resultList.add("̵�Ƴ�");
			resultList.add("�ʺ�ʹ");
			resultList.add("��ʹ");
			resultList.add("����");
			resultList.add("����");
			resultList.add("��̦");
			resultList.add("��̦");
			resultList.add("������");
			resultList.add("����");
			
			return resultList;
		} else if (object.equals("����")) {
			resultList.add("�ڿ�");
			resultList.add("�ʸ�");
			resultList.add("������");
			resultList.add("ͷʹ");
			resultList.add("С��̻�");
			resultList.add("�ɿ���̵��̵");
			resultList.add("΢ʹ");
			resultList.add("���ط�����");
			resultList.add("�޺�");
			resultList.add("����");
			resultList.add("��̦");
			resultList.add("̵�ٶ��");
			resultList.add("��̦");
			resultList.add("Ƥ������");
			resultList.add("����");
			resultList.add("��̦");
			resultList.add("�Ǹ�����");
			
			return resultList;
		} else if (object.equals("����")) {
			resultList.add("�����ض���");
			resultList.add("�ʺ�ʹ");
			resultList.add("�ʸ�");
			resultList.add("������");
			resultList.add("ͷʹ");
			resultList.add("С��̻�");
			resultList.add("�ɿ���̵��̵");
			resultList.add("����");
			resultList.add("����");
			resultList.add("������");
			resultList.add("��̦");
			resultList.add("̵�ٶ��");
			resultList.add("Ƥ������");
			resultList.add("��̦");
			resultList.add("��̦");
			resultList.add("�Ǹ�����");
			
			return resultList;
		} 
			
		return resultList;
	}


}

