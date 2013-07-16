package bean;

public class symptomInsBean {
	private int id;
	private String text;
	private boolean leaf;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public boolean isLeaf() {
		return leaf;
	}
	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}
	public symptomInsBean(int id,String text,boolean leaf){
		this.id = id;
		this.text = text;
		this.leaf = leaf;
	}
}
