package match;

import java.util.HashSet;
import java.util.ArrayList;
public class matchSymptoms {
	private ArrayList<HashSet<String>> Ref = reference.getInstance();

	public HashSet<String> match(String[] Obj){
		HashSet<String> hash = null;
		int index = 0;
		int count = 0;
		int temp = 0;
		System.out.println(Ref.size());
		for(int i=0; i<Ref.size();i++){
			hash = Ref.get(i);
			temp = 0;
			for(int j=0; j<Obj.length; j++){
				if( hash.contains(Obj[j]) ){
					temp++;
				}
			}
			if(temp > count){
				count = temp;
				index = i;
			}
			System.out.println("hash["+i+"]:temp="+temp+",count="+count+",index ="+index);
		}
		System.out.println(index+Ref.get(index).toString());
		return Ref.get(index);
	}
	public HashSet<String> match(ArrayList<String> Obj){
		HashSet<String> hash = null;
		int index = 0;
		int count = 0;
		int temp = 0;
		System.out.println(Ref.size());
		for(int i=0; i<Ref.size();i++){
			hash = Ref.get(i);
			temp = 0;
			for(int j=0; j<Obj.size(); j++){
				if( hash.contains(Obj.get(j)) ){
					temp++;
				}
			}
			if(temp > count){
				count = temp;
				index = i;
			}
		}
		System.out.println(Ref.get(index).toString());
		return Ref.get(index);
	}
	public static void main(String arg[]){
		String[] list = {"壮热","汗多","口渴","心烦","头痛","头晕","气粗","面红"};
		ArrayList<String> test = new ArrayList<String>();
		
		test.add("壮热");
		test.add("汗多");
		
		matchSymptoms ms = new matchSymptoms();
		for (int i = 0; i < ms.Ref.size(); i++) {
			System.out.println(ms.Ref.get(i));
		}
		
		ms.match(list);
		
		ms.match(test);
	}	
}
