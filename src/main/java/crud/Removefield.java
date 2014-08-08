package crud;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

public class Removefield {

	public static void main(String[] args) throws UnknownHostException {
		MongoClient client = new MongoClient(new ServerAddress("localhost", 27017));
		DB db = client.getDB("mydb");
		DBCollection collection = db.getCollection("removeField");
		DBObject dbObject = new BasicDBObject("name","Deepak");
		collection.drop();
		System.out.println(dbObject);
		collection.insert(dbObject);
		System.out.println(dbObject);
		dbObject.removeField("_id");
		System.out.println(dbObject);
		collection.insert(dbObject);
		System.out.println(dbObject);
	}
}
