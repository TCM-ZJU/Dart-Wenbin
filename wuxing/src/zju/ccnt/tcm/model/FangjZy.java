package zju.ccnt.tcm.model;

public class FangjZy {
	private String Medicine;
	private String zyArr;
	private String sourceBook;
	
	public FangjZy(String med, String zyArr, String book) {
		setMedicine(med);
		setZyArr(zyArr);
		setSourceBook(book);
	}

	public FangjZy(String med, String book) {
		this.Medicine = med;
		this.sourceBook = book;
		this.zyArr = "";
	}
	
	public String getMedicine() {
		return Medicine;
	}

	public void setMedicine(String medicine) {
		Medicine = medicine;
	}

	public String getSourceBook() {
		return sourceBook;
	}

	public void setSourceBook(String sourceBook) {
		this.sourceBook = sourceBook;
	}

	public String getZyArr() {
		return zyArr;
	}

	public void setZyArr(String zyArr) {
		this.zyArr = zyArr;
	}
}
