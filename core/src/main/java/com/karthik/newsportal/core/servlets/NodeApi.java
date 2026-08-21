package com.karthik.newsportal.core.servlets;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObjectBuilder;;

@SuppressWarnings("serial")
@Component(service = Servlet.class, immediate = true)
@SlingServletPaths(value = {"/bin/article/api"})
public class NodeApi extends SlingAllMethodsServlet {
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
		ResourceResolver resolver = request.getResourceResolver();
		Resource userResource = resolver.getResource("/content/users");
		
		if(userResource != null) {
			Iterator<Resource> children = userResource.listChildren();
			JsonArrayBuilder userJsonList = Json.createArrayBuilder();
			
			while(children.hasNext()) {
				Resource childResource = (Resource) children.next();
				
				ValueMap properties = childResource.getValueMap();
				
				String userName = properties.get("userName", String.class);
				String email = properties.get("email", String.class);
				String phoneNo = properties.get("phoneNo", String.class);
				
				JsonObjectBuilder userJsonObj = Json.createObjectBuilder();
				
				userJsonObj.add("userName", userName);
				userJsonObj.add("email", email);
				userJsonObj.add("phoneNo", phoneNo);
				
				userJsonList.add(userJsonObj);
			}
		}
	}
}





















