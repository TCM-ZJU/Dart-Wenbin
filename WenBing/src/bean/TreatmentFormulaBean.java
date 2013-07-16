package bean;

import java.util.ArrayList;
import java.util.List;
public class TreatmentFormulaBean {
	private String treatment;
	private List<String> formula;
	public String getTreatment() {
		return treatment;
	}
	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}
	public List<String> getFormula() {
		return formula;
	}
	public void setFormula(List<String> formula) {
		this.formula = formula;
	}
	public String toJson(){
		StringBuffer sb = new StringBuffer();
		sb.append("{\"treatment\":\"");
		sb.append(treatment+"\",\"formulalist\":[");
		for(int i=0; i<formula.size(); i++){
			if(i==0)
				sb.append("{\"formula\":\""+formula.get(i)+"\"}");
			else
				sb.append(",{\"formula\":\""+formula.get(i)+"\"}");
		}
		sb.append("]}");
		return sb.toString();
	}
	public String toXML(){
		StringBuffer sb = new StringBuffer();
		sb.append("<treatment>"+treatment+"</treatment><formulalist>");
		for(int i=0; i<formula.size(); i++){
			sb.append("<formula>"+formula.get(i)+"</formula>");
		}
		sb.append("</formulalist>");
		return sb.toString();
	}
}
