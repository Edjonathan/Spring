import java.util.Arrays;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class InsertTest {
	public static void main(String[] args) {
		MongoClient client = new MongoClient();
		MongoDatabase db = client.getDatabase("course");
		MongoCollection<Document> coll = db.getCollection("insertTest");
		
		coll.drop();
		Document smith = new Document("name","Smith")
		                        .append("age", 30)
		                        .append("profession","programmer");
		
		Document jones = new Document("name", "Jones")
		                      .append("age", 35)
				              .append("profession", "Hacker");

		DocumentTest.printJson(jones);
		
		coll.insertMany(Arrays.asList(smith,jones));
		
		DocumentTest.printJson(jones);
		client.close();
	}
}
