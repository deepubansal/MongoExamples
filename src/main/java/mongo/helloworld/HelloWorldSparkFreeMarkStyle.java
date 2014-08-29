package mongo.helloworld;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class HelloWorldSparkFreeMarkStyle {
	public static void main(String[] args) {
		Spark.get(new Route("/") {

			@Override
			public Object handle(Request arg0, Response arg1) {
				try {
					Configuration config = new Configuration();
					config.setClassForTemplateLoading(
							HelloWorldFreeMarkerStyle.class, "/");

					Template template = config.getTemplate("hello.ftl");
					Map<String, String> map = new HashMap<String, String>();
					map.put("name", "Deepak");
					StringWriter writer = new StringWriter();

					template.process(map, writer);
					return writer;
				} catch (Exception e) {
					halt(500);
					e.printStackTrace();
				}
				return "Some Error Occurred";
			}
		});
	}
}
