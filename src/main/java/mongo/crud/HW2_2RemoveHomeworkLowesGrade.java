package mongo.crud;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class HW2_2RemoveHomeworkLowesGrade {

	public static void main(String[] args) throws UnknownHostException {
		MongoClient client = new MongoClient();
		DB db = client.getDB("students1");
		DBCollection dbCollection = db.getCollection("grades");
		DBCursor sort = dbCollection
				.find(new BasicDBObject("type", "homework")).sort(
						new BasicDBObject("student_id", true).append("score",
								true));
		DBObject prev = null;
		while (sort.hasNext()) {
			DBObject next = sort.next();
			if (prev == null
					|| !prev.get("student_id").equals(next.get("student_id"))) {
				System.out.println(next);
				dbCollection.remove(next);
			}
			prev = next;
		}
	}
}
