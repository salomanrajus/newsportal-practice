package com.karthik.newsportal.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;

@SuppressWarnings("serial")
@Component(service = Servlet.class, immediate = true)
@SlingServletPaths(value = "/bin/newsportal/service/test1")
public class AnonServlet1 extends SlingAllMethodsServlet {

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().write("Response from AnonServlet1 -- GET");
	}

	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().write("Response from AnonServlet1 -- POST");
	}

	@Override
	protected void doPut(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().write("Response from AnonServlet1 -- PUT");
	}

	@Override
	protected void doDelete(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().write("Response from AnonServlet1 -- DELETE");
	}
}