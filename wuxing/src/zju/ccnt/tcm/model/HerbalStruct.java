package zju.ccnt.tcm.model;

public class HerbalStruct {
	private String disease;
	private FangjZy fangji;

	
	public HerbalStruct(String disease, FangjZy fangji) {
		setDisease(disease);
		setFangji(fangji);
	}
	
	public HerbalStruct(String disease) {
		this.disease = disease;
	}
	
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}

	public FangjZy getFangji() {
		return fangji;
	}

	public void setFangji(FangjZy fangji) {
		this.fangji = fangji;
	}



		
}
