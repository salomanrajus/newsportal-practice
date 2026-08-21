package com.karthik.newsportal.core.servlets;

import java.io.IOException;
import java.util.Iterator;
import java.util.*;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ModifiableValueMap;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;

@SuppressWarnings("serial")
@Component(service = Servlet.class, immediate = true)
@SlingServletPaths(value = { "/bin/newsportal/recent/nodeServletCrud" })
public class NodeServletCrud extends SlingAllMethodsServlet {

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {

		ResourceResolver resolver = request.getResourceResolver(); 
		Resource userResource = resolver.getResource("/content/users"); 

		if (userResource != null) {
			Iterator<Resource> userChildList = userResource.listChildren();
			
			JsonArrayBuilder userJsonList = Json.createArrayBuilder();

			while (userChildList.hasNext()) {
				Resource childUserResource = (Resource) userChildList.next(); 

				ValueMap properties = childUserResource.getValueMap();
				String firstName = properties.get("firstName", String.class);
				String lastName = properties.get("lastName", String.class);
				String email = properties.get("email", String.class);
				String phone = properties.get("phone", String.class);

				JsonObjectBuilder userJson = Json.createObjectBuilder();

				userJson.add("firstName", firstName);
				userJson.add("lastName", lastName);
				userJson.add("email", email);
				userJson.add("phone", phone);
				userJsonList.add(userJson);
			}
			response.getWriter().write(userJsonList.build().toString());
		}
	}

	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {

		ResourceResolver resolver = request.getResourceResolver();
		Resource userResource = resolver.getResource("/content/users");

		String userID = request.getParameter("userID");

		Map<String, Object> properties = new HashMap<>();
		properties.put("firstName", request.getParameter("firstName"));
		properties.put("lastName", request.getParameter("lastName"));
		properties.put("email", request.getParameter("email"));
		properties.put("phone", request.getParameter("phone"));

		resolver.create(userResource, userID, properties);
		resolver.commit();
		response.getWriter().write("User ID successfully Created " + userID);
	}

	@Override
	protected void doPut(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {

		String userID = request.getParameter("userID");

		ResourceResolver resolver = request.getResourceResolver();
		Resource userResource = resolver.getResource("/content/users/" + userID);

		if (userResource != null) {

			ModifiableValueMap mProp = userResource.adaptTo(ModifiableValueMap.class);

			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");

			if (firstName != null) {

				mProp.put("firstName", firstName);
			}
			if (lastName != null) {

				mProp.put("lastName", lastName);
			}
			if (email != null) {

				mProp.put("email", email);
			}
			if (phone != null) {

				mProp.put("phone", phone);
			}
			resolver.commit();
			response.getWriter().write("UserID successfully Updated " + userID);
		} else {

			response.getWriter().write("UserID not found..");
		}
	}

	@Override
	protected void doDelete(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {

		String userID = request.getParameter("userID");

		ResourceResolver resolver = request.getResourceResolver();
		Resource userResource = resolver.getResource("/content/users/" + userID);
		resolver.delete(userResource);
		resolver.commit();

		response.getWriter().write("UserID successfully Deleted " + userID);
	}
}
