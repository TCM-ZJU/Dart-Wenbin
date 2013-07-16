package action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import query.getAnswer;

public class getSuggestionAction implements ServletRequestAware {
	private HttpServletRequest request;
	private String suggestion;
	public String getSuggestion() {
		return suggestion;
	}
	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
	public String execute(){
		String syms = request.getParameter("syms");
		try{
			syms = new String(syms.getBytes("ISO-8859-1"), "GBK");
		}catch(UnsupportedEncodingException e){
			System.out.println("cannot decode word: " + syms);
			e.printStackTrace();
		}
		System.out.println(syms);
		String[] strs = syms.split("，");
		System.out.println("parameters number:"+strs.length);
		getAnswer ga = new getAnswer();
		setSuggestion(ga.getanswer(strs));
		return "success";
	}
	public String executeforF(){
		String syms = request.getParameter("syms");
		try{
			syms = new String(syms.getBytes("ISO-8859-1"), "UTF-8");
		}catch(UnsupportedEncodingException e){
			System.out.println("cannot decode word: " + syms);
			e.printStackTrace();
		}
		System.out.println(syms);
		String[] strs = syms.split(",");
		System.out.println("parameters number:"+strs.length);
		getAnswer ga = new getAnswer();
		setSuggestion(ga.getanswer(strs));
		return "success";
	}
}
