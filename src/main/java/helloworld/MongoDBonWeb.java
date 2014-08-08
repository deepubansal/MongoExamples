package helloworld;

import java.io.StringWriter;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class MongoDBonWeb {
public static void main(String[] args) throws UnknownHostException {
	

	final Configuration config = new Configuration();
	config.setClassForTemplateLoading(
			HelloWorldFreeMarkerStyle.class, "/");
	MongoClient client = new MongoClient(new ServerAddress("localhost", 27017));
	DB db = client.getDB("mydb");
	final DBCollection collection = db.getCollection("testData1");

	Spark.get(new Route("/") {

		@Override
		public Object handle(Request arg0, Response arg1) {
			try {

				Template template = config.getTemplate("values.ftl");
				Map<String, String> map = new HashMap<String, String>();
				map.put("name", "Deepak");
				
				DBCursor dbCursor = collection.find();
				StringBuffer items = new StringBuffer();
				while (dbCursor.hasNext()) {
					DBObject dbObject = dbCursor.next();
					items.append("<li>"+ dbObject.get("x")+"</li>");
				}
				StringWriter writer = new StringWriter();
				map.put("listItems", items.toString());
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
