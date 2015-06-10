import java.io.StringWriter;
import java.util.Arrays;

import org.bson.Document;
import org.bson.codecs.DocumentCodec;
import org.bson.codecs.EncoderContext;
import org.bson.json.JsonMode;
import org.bson.json.JsonWriter;
import org.bson.json.JsonWriterSettings;
import org.bson.types.ObjectId;


public class DocumentTest {
	
	public static void main(String[] args) {
		Document document = new Document();
		document.append("str", "MongoDB");
		document.append("id",10);
		document.append("objectId", new ObjectId());
		document.append("embeded doc", new Document("x",0));
		document.append("list",Arrays.asList(1,2,3));
		printJson(document);
	}

	public static void printJson(Document document)
	{
		JsonWriter jsonwriter = new JsonWriter(new StringWriter(),
											   new JsonWriterSettings(JsonMode.SHELL,true));
		new DocumentCodec().encode(jsonwriter, document,EncoderContext.builder()
																	  .isEncodingCollectibleDocument(true)
																	  .build());
		System.out.println(jsonwriter.getWriter());
		System.out.flush();
	}
}
