package match;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class reference {

	private static ArrayList<HashSet<String>> Ref = null; // = new ArrayList<HashSet<String>>();
	private static void read(){
		String location = new location().getLocation();
		location = location.replaceAll("%20", " ");
		FileReader fr = null;
		try{
			fr = new FileReader(location.substring(1)+"etc/SymptomSet.TXT");
			System.out.println(fr.getEncoding());
		}catch(FileNotFoundException e){
			e.printStackTrace();
			System.out.println("SymtomSet File not found!");
			return ;
		}
		BufferedReader bufreader = null;
		if(fr.getEncoding() == "GBK"){
			try{
				fr.close();
				System.out.println("to handle as utf-8");
				bufreader = new BufferedReader(new InputStreamReader(new FileInputStream(location.substring(1)+"etc/SymptomSet.TXT"),"UTF-8"));
			}catch(IOException e){
				e.printStackTrace();
				return ;
			}			
		}
		else
			bufreader = new BufferedReader(fr);
		Ref = new ArrayList<HashSet<String>>();
		try{
			String str = bufreader.readLine();
			while(str != null){
				String[] strarray = str.split(",");
				HashSet<String> hash = new HashSet<String>();
				for(int i=0; i<strarray.length; i++){
					hash.add(strarray[i]);
					System.out.print(strarray[i]+" ");
				}
				Ref.add(hash);
				System.out.println();
				str = bufreader.readLine();
			}
		}catch(IOException e){
			e.printStackTrace();
			System.out.println("read SymtomSet File error!");
			return ;
		}
	}
	public static synchronized ArrayList<HashSet<String>> getInstance(){
		if(Ref == null){
			read();
		}
		return Ref;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		reference.getInstance();
		
		for (int i = 0; i < Ref.size(); i++) {
			System.out.println(Ref.get(i));
		}

	}

}
