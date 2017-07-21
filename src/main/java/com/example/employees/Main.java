package com.example.employees;

import java.util.Optional;

import org.apache.catalina.startup.Tomcat;



public class Main {
    
    public static final Optional<String> PORT = Optional.ofNullable(System.getenv("PORT"));
    public static final Optional<String> HOSTNAME = Optional.ofNullable(System.getenv("HOSTNAME"));
    
    public static void main(String[] args) throws Exception {
    	
    	/* Cloud Version */ 
    	
    	 String contextPath = "/";
         String appBase = ".";
         Tomcat tomcat = new Tomcat();     
         tomcat.setPort(Integer.valueOf(PORT.orElse("8080") ));
         tomcat.setHostname(HOSTNAME.orElse("localhost"));
         tomcat.getHost().setAppBase(appBase);
         tomcat.addWebapp(contextPath, appBase);
         tomcat.start();
         tomcat.getServer().await();
    	 
         
         
         
         
    	/* LOCAL version
    	
    	String webappDirLocation = "src/main/webapp/";
    	
    	
        File additionWebInfClasses = new File("target/classes");
        
        Tomcat tomcat = new Tomcat();  
        tomcat.setPort(Integer.parseInt(PORT.orElse("8080")) );
        tomcat.setHostname(HOSTNAME.orElse("localhost"));
      
        StandardContext ctx = (StandardContext) tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());
        
       
        
        System.out.println("HEY HEY configuring app with basedir: " + appBase);
        
        
        WebResourceRoot resources = new StandardRoot(ctx);

        resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes",
                additionWebInfClasses.getAbsolutePath(), "/"));
        ctx.setResources(resources);
		
        
        tomcat.start();
        tomcat.getServer().await();
        */
    }
}
