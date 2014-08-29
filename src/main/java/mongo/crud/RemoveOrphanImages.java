package mongo.crud;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class RemoveOrphanImages {

	public static void main(String[] args) throws UnknownHostException {
		MongoClient client = new MongoClient();
		DB db = client.getDB("final7");
		DBCollection albumsCollection = db.getCollection("albums");
		DBCollection imagesCollection = db.getCollection("images");
		DBCollection liveImagesCollection = db.getCollection("liveimages");

		DBCursor images = imagesCollection.find();
		while (images.hasNext()) {
			DBObject dbObject = images.next();
			int imageId = (Integer) dbObject.get("_id");
			DBCursor found = albumsCollection.find(new BasicDBObject("images",
					imageId));
			if (found.size() >= 1) {
				liveImagesCollection.insert(dbObject);
			}
		}
	}
}
