import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ReadPreference;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


public class App {

	public static void main(String[] args) {
//		MongoClientOptions options = MongoClientOptions.builder().build();
//		MongoClient client = new MongoClient(new ServerAddress(),options);
//		Padrao 100 conexoes
		MongoClientOptions options = MongoClientOptions.builder().connectionsPerHost(100).build();
		MongoClient client = new MongoClient(new ServerAddress(),options);
		
		MongoDatabase db = client.getDatabase("students").withReadPreference(
								  						  ReadPreference.secondary());
		MongoCollection<Document> collection= db.getCollection("grades",Document.class);
		collection.count();
		client.close();
	}
}
