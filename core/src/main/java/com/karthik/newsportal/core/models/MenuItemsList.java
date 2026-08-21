package com.karthik.newsportal.core.models;


import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = {Resource.class})
public class MenuItemsList {
	
	@ValueMapValue
	private String name;

	@ValueMapValue
	private int age;
	
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
}	
