package match;

public class location {
	public String getLocation(){
		return this.getClass().getClassLoader().getResource("").getPath();
	}
}
