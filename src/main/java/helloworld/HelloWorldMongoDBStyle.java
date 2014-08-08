package helloworld;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

public class HelloWorldMongoDBStyle {

	public static void main(String[] args) throws UnknownHostException {
		MongoClient client = new MongoClient(new ServerAddress("localhost", 27017));
		DB db = client.getDB("mydb");
		DBCollection collection = db.getCollection("testData1");
		DBObject dbObject = collection.findOne();
		System.out.println(dbObject);
		
		
	}
}
