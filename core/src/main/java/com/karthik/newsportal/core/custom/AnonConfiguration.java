package com.karthik.newsportal.core.custom;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition
public @interface AnonConfiguration {
	
	@AttributeDefinition(name = "RestAPI URL", description = "This is a Sample URL in AnonConfiguration")
	public String restApiUrl() default "https://gorest.co.in/public/v2/posts";
}
