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
	private static final String APP_COMPONENTS = "src/com/output/service/";
	private static final String TARGET_SRC_PACKAGE = "com.output.service";
	
	// TODO - check if any of the files already exist
	// TODO - abstract creation into separate methods
	// create service
	// create provider
	// create controller
	// create model
    public static void main(String[] args) throws IOException {
    		// get input
    		String componentName = "Phil";
    		
    		// create template(s)
    		TemplateModel service = new TemplateModel();
    		service.setTemplateName("service-template");
    		service.setComponentName(componentName);
    		service.setTemplatePackage(TARGET_SRC_PACKAGE);
    		service.setFileSuffix("Service");
    		service.setFileExt(".java");
    		service.setFilePath(APP_COMPONENTS);
    		createService(service);
    }
    public static void createService(TemplateModel model) throws IOException {
    		// get handle bar template
	    	Template template = getTemplate(model.getTemplateName());
	    	
	    	// get template content
	    	String content = getContent(model, template);
	    	
	    	
	    	createFiles(model.getFilePath(), model.getFileName());
	    	writeFiles(content, model.getFilePath(), model.getFileName());
    }
    public static Template getTemplate(String templateName) throws IOException {
	    	TemplateLoader loader = new ClassPathTemplateLoader();
	    	loader.setPrefix("");
	    	loader.setSuffix(".html");
	    	Handlebars handlebars = new Handlebars(loader);
	
	    	return handlebars.compile(templateName);
    }
    public static String getContent(TemplateModel model, Template template) throws IOException {
	    	String content = template.apply(model);
	    	System.out.println("Template: ");
	    	System.out.println(content);
	    	return content;
    }
    public static void createFiles(String filePath, String fileName) throws IOException {
    		System.out.println("creating files");
    		System.out.println("file path: " + filePath);
    		System.out.println("file name: " +fileName);
    		
    		// TODO -- what to do if file or dir exists
    		new File(filePath).mkdirs();
    		new File(filePath + fileName).createNewFile();
    }
    public static void writeFiles(String content, String filePath, String fileName) {
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			fw = new FileWriter(filePath + fileName);
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
