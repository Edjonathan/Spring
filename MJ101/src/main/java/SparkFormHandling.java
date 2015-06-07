import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import freemarker.template.Configuration;
import freemarker.template.Template;


public class SparkFormHandling {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		final Configuration configuration = new Configuration();
		configuration.setClassForTemplateLoading(SparkFormHandling.class,"/");
		
		Spark.get(new Route("/") {
			
			@Override
			public Object handle(Request request, Response response) {
				// TODO Auto-generated method stub
				try {
					Map<String,Object> fruitMaps = new HashMap<String,Object>();
					fruitMaps.put("fruits",
							Arrays.asList("apple","orange","banana","peach"));
					Template fruitPicker = 
							 configuration.getTemplate("fruitPicker.ftl");
					StringWriter writer = new StringWriter();
					fruitPicker.process(fruitMaps, writer);
					return writer;
					
				} catch (Exception e) {
					// TODO: handle exception
					halt(500);
					e.printStackTrace();
				}
				
				return null;
			}
		});
		
		Spark.post(new Route("/favorite_fruit") {
			
			@Override
			public Object handle(Request request, Response response) {
				// TODO Auto-generated method stub
				final String fruit = request.queryParams("fruit");
				if(fruit == null)
				{
					return "Why don't you pick one ?";
				}
				else
				{
					return "Your favorite fruit is: " + fruit;
				}
			}
		});
	}

}
