package action;
import java.util.ArrayList;
import query.getSymptom;

import com.hp.hpl.jena.ontology.OntModel;

import net.sf.json.JSONArray;
import bean.symptomInsBean;
import module.Module;
import javax.servlet.http.*;
import org.apache.struts2.interceptor.ServletRequestAware;
import java.io.UnsupportedEncodingException;

public class symptomInsAction implements ServletRequestAware{
	private HttpServletRequest request;
	private String symInslist;
	private ArrayList<symptomInsBean> list;
	public String execute(){
		String symCa = request.getParameter("symca");
		try{
			symCa = new String(symCa.getBytes("ISO-8859-1"), "UTF-8");
		}catch(UnsupportedEncodingException e){
			System.out.println("cannot decode word: " + symCa);
			e.printStackTrace();
		}
		System.out.println("查找的实例："+symCa);
		OntModel model = new Module().getInfmodel();
		getSymptom getSym = new getSymptom();
		list= getSym.getSympInstanceByCate(symCa,model);
		JSONArray symjson = JSONArray.fromObject(list);
		try {
			symInslist = symjson.toString();
			System.out.println(symInslist);
        } catch (Exception e) {
        	symInslist = "ss";
        }
		return "success";
	}
	public ArrayList<symptomInsBean> getList() {
		return list;
	}
	public void setList(ArrayList<symptomInsBean> list) {
		this.list = list;
	}
	public String getSymInslist() {
		return symInslist;
	}
	public void setSymInlist(String symInslist) {
		this.symInslist = symInslist;
	}
	public void setServletRequest(HttpServletRequest request){
		this.request = request;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public void setSymInslist(String symInslist) {
		this.symInslist = symInslist;
	}
}
