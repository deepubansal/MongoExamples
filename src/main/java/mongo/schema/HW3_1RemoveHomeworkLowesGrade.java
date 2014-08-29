package mongo.schema;

import java.net.UnknownHostException;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class HW3_1RemoveHomeworkLowesGrade {

	public static void main(String[] args) throws UnknownHostException {
		MongoClient client = new MongoClient();
		DB db = client.getDB("school");
		DBCollection dbCollection = db.getCollection("students1");
		DBCursor students = dbCollection
				.find(new BasicDBObject());
		while (students.hasNext()) {
			DBObject next = students.next();
			BasicDBList scores = (BasicDBList) next.get("scores");
			if (((Double)((DBObject)scores.get(2)).get("score")) 
					< ((Double)((DBObject)scores.get(3)).get("score"))) {
				scores.remove(2);
			}
			else scores.remove(3);
			dbCollection.update(new BasicDBObject("_id",next.get("_id")), next);
		}
		
	}
}
