package com.app.generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.app.generator.model.TemplateModel;
import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.io.ClassPathTemplateLoader;
import com.github.jknack.handlebars.io.TemplateLoader;

public class Generator {
	private static final String APP_COMPONENTS = "src/com/output/";
	private static final String TARGET_SRC_PACKAGE = "com.output";
    public static void main(String[] args) throws IOException {
	    	Template template = getTemplate();
	    	
	    	TemplateModel address = new TemplateModel();
	    	address.setComponentName("PhilService");
	    	address.setTemplatePackage(TARGET_SRC_PACKAGE);
	    	String content = getContent(address, template);
	    	
	    	String filePath = APP_COMPONENTS + address.getComponentName();
	    	createFiles(filePath, "Service");
	    	writeFiles(content, filePath);
    }
    
    public static Template getTemplate() throws IOException {
	    	TemplateLoader loader = new ClassPathTemplateLoader();
	    	loader.setPrefix("");
	    	loader.setSuffix(".html");
	    	Handlebars handlebars = new Handlebars(loader);
	
	    	return handlebars.compile("template");
    }
    public static String getContent(TemplateModel model, Template template) throws IOException {
	    	String content = template.apply(model);
	    	System.out.println(content);
	    	return content;
    }
    public static void createFiles(String filePath, String Suffix) throws IOException {
    		new File(filePath + ".java").createNewFile();
    }
    public static void writeFiles(String content, String filePath) {
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			fw = new FileWriter(filePath + ".java");
			bw = new BufferedWriter(fw);
			bw.write(content);

			System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
    }
}
