package bean;

import java.util.ArrayList;
import java.util.List;

public class suggestionBean {
	private String syndrom;
	private List<TreatmentFormulaBean> treatformula;
	public String getSyndrom() {
		return syndrom;
	}
	public void setSyndrom(String syndrom) {
		this.syndrom = syndrom;
	}
	public List<TreatmentFormulaBean> getTreatformula() {
		return treatformula;
	}
	public void setTreatformula(List<TreatmentFormulaBean> treatformula) {
		this.treatformula = treatformula;
	}
	public String toJson(){
		StringBuffer sb = new StringBuffer();
		sb.append("[{\"syndrom\":\""+syndrom+"\",\"treatformula\":[");
		for(int i=0; i<treatformula.size(); i++){
			if(i==0)
				sb.append(treatformula.get(i).toJson());
			else
				sb.append(","+treatformula.get(i).toJson());
		}
		sb.append("]}]");
		return sb.toString();
	}
	public String toXML(){
		StringBuffer sb = new StringBuffer();
		sb.append("<list><syndrom>"+syndrom+"</syndrom><treatformulalist>");
		for(int i=0; i<treatformula.size(); i++){
			sb.append("<treatformula>"+treatformula.get(i).toXML()+"</treatformula>");
		}
		sb.append("</treatformulalist></list>");
		return sb.toString();
	}
}
