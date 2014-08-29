package mongo.helloworld;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class HelloWorldFreeMarkerStyle {
public static void main(String[] args) {
	Configuration config = new Configuration();
	config.setClassForTemplateLoading(HelloWorldFreeMarkerStyle.class, "/");
	
	try {
		Template template = config.getTemplate("hello.ftl");
		StringWriter writer = new StringWriter();
		Map<String,String> map = new HashMap<String,String>();
		map.put("name", "Deepak");
		template.process(map, writer);
		System.out.println(writer);
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
