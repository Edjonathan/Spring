package course;

import java.io.StringWriter;

import org.bson.Document;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class HelloWordMongoDBSparkFreemarkerStyle {
	public static void main(String[] args) {
		final Configuration configuration = new Configuration();
		configuration.setClassForTemplateLoading
		(HelloWordMongoDBSparkFreemarkerStyle.class,"/freemarker");
		
		MongoClient client = new MongoClient();
		MongoDatabase db = client.getDatabase("course");
		final MongoCollection<Document> collection =db.getCollection("hello");
		
		collection.drop();
		collection.insertOne(new Document("name","mongoDB"));
		
		Spark.get(new Route("/") {
			
			@Override
			public Object handle(Request request, Response response) {
				// TODO Auto-generated method stub
				StringWriter writer = new StringWriter();
				try {
					Template template = configuration.getTemplate("hello.ftl");
					template.process(collection.find().first(),writer);
				} catch (Exception e) {
					// TODO: handle exception
					halt(500);
					e.printStackTrace();
				}
				return writer;
			}
		});
	}
}
