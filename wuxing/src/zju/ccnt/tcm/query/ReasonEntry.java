package zju.ccnt.tcm.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface ReasonEntry {
	public Map<String, ArrayList<String>> getTotalResults(int number, String[] query);		// 获取病机推理结果
	public ArrayList<String> getSubject(String currObject);				// 获取当前的主体
	public ArrayList<String> getSymptom(String currObject);			// 获取当前的症状
	public String getTreatRule(String currObject);				// 获取当前的治则
	public String getTreatMethod(String currObject);			// 获取当前的治法
	public ArrayList<String> getTheraphy(String currObject);			// 获取当前的方剂
	public String getHerbal(String therapy);					// 获取对应方剂的中药
	public ArrayList<String> getLink(ArrayList<String> objects); // 获取对应证候的内在病因
}
