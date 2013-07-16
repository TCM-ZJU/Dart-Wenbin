package action;

import java.util.ArrayList;
import query.getSymptom;

import com.hp.hpl.jena.ontology.OntModel;

import net.sf.json.JSONArray;
import bean.symptomBean;
import module.Module;
public class symptomAction {
	private String symlist;
	private ArrayList<symptomBean> list;
	public String execute(){
		OntModel model = new Module().getInfmodel();
		getSymptom getSym = new getSymptom();
		list= getSym.getSymptomCate(model);
		JSONArray symjson = JSONArray.fromObject(list);
		try {
			symlist = symjson.toString();
			System.out.println(symlist);
        } catch (Exception e) {
        	symlist = "ss";
        }
		return "success";
	}
	public ArrayList<symptomBean> getList() {
		return list;
	}
	public void setList(ArrayList<symptomBean> list) {
		this.list = list;
	}
	public String getSymlist() {
		return symlist;
	}
	public void setSymlist(String symlist) {
		this.symlist = symlist;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OntModel model = new Module().getInfmodel();
		symptomAction query = new symptomAction();
		query.execute();
	}
}
