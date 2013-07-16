import java.lang.Integer;
import org.dom4j.DocumentHelper;
import org.dom4j.Document;
import org.dom4j.Element;

public class hello 
{	
	public hello()
	{
		
	}
	
	public String getReasoning(Integer number ,String [] name)
	{
		//xml xml = new xml();
		for (Integer i = 0; i < number; ++i)
			System.out.println(name[i]);
		CreateXML a = new CreateXML();
		System.out.println(a.text(number, name));
		return a.text(number, name);
	}
	
	public String text()
	{
		System.out.println("11111111111");
		Document doc = DocumentHelper.createDocument();
		System.out.println("111111111112");
		Element root =doc.addElement("graph");
		System.out.println("111111111113");
		Element level = root.addElement("Objects").addElement("level");
		System.out.println("111111111114");
		level.addElement("Object").addElement("text", "a");
		System.out.println("111111111115");
		level.addElement("Object").addElement("type", "b");
		return doc.asXML();
	}
}
