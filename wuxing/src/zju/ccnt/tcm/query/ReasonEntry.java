package zju.ccnt.tcm.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface ReasonEntry {
	public Map<String, ArrayList<String>> getTotalResults(int number, String[] query);		// ��ȡ����������
	public ArrayList<String> getSubject(String currObject);				// ��ȡ��ǰ������
	public ArrayList<String> getSymptom(String currObject);			// ��ȡ��ǰ��֢״
	public String getTreatRule(String currObject);				// ��ȡ��ǰ������
	public String getTreatMethod(String currObject);			// ��ȡ��ǰ���η�
	public ArrayList<String> getTheraphy(String currObject);			// ��ȡ��ǰ�ķ���
	public String getHerbal(String therapy);					// ��ȡ��Ӧ��������ҩ
	public ArrayList<String> getLink(ArrayList<String> objects); // ��ȡ��Ӧ֤������ڲ���
}
