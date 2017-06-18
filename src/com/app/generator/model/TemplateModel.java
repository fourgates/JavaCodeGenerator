package com.app.generator.model;

public class TemplateModel {
	private String templatePackage;
	private String componentName;
	private String templateName;
	private String fileSuffix;
	private String filePath;
	private String fileExt;
	
	public String getFileExt() {
		return fileExt;
	}
	public void setFileExt(String fileExt) {
		this.fileExt = fileExt;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileName() {
		return this.componentName + this.fileSuffix + this.fileExt;
	}
	public String getFileSuffix() {
		return fileSuffix;
	}
	public void setFileSuffix(String fileSuffix) {
		this.fileSuffix = fileSuffix;
	}
	public String getTemplateName() {
		return templateName;
	}
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	public String getTemplatePackage() {
		return templatePackage;
	}
	public void setTemplatePackage(String templatePackage) {
		this.templatePackage = templatePackage;
	}
	public String getComponentName() {
		return componentName;
	}
	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}
	
	
}
