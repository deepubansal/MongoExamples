package mongo.helloworld;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class CopyOfHelloWorldFreeMarkerStyle {
public static void main(String[] args) {
	Configuration config = new Configuration();
	config.setClassForTemplateLoading(CopyOfHelloWorldFreeMarkerStyle.class, "/");
	
	try {
		Template template = config.getTemplate("hello1.html");
		StringWriter writer = new StringWriter();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("recordTypes", Arrays.asList("P","O"));
//		map.put("P_sourceSystems", Arrays.asList("SAP","CRM","ERP"));
//		map.put("O_sourceSystems", Arrays.asList("SBL","ERP"));
		
		HashMap<String, List<String>> hashMap = new HashMap<String,List<String>>();
		hashMap.put("P", Arrays.asList("SAP","CRM","ERP"));
		hashMap.put("O",  Arrays.asList("SBL","ERP"));
		map.put("sourceSystems", hashMap);
		template.process(map, writer);
		System.out.println(writer);
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
