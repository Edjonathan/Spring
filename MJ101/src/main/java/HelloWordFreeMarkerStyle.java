import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;


public class HelloWordFreeMarkerStyle {
	
	public static void main(String[] args) throws IOException, Exception {
		
		Configuration configuration = new Configuration();
		configuration.setClassForTemplateLoading(HelloWordFreeMarkerStyle.class, "/");
		Template helloTemplate = configuration.getTemplate("C:/Users/Guedes/workspace/MJ101/target/MJ101-0.0.1-SNAPSHOT/WEB-INF/");
		StringWriter writter  = new StringWriter();
		Map<String,Object>helloMap = new HashMap<String, Object>();
		helloMap.put("name","Freemarker");
		helloTemplate.process(helloMap, writter);
		System.out.println(writter);
	}
}
