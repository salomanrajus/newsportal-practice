package com.karthik.newsportal.core.models;

import javax.annotation.PostConstruct; 

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

@Model (adaptables = {Resource.class, SlingHttpServletRequest.class},
				resourceType ="newsportal/components/test1",
				defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
		)
@Exporter (extensions = "json", name = "jackson")
public class TestSlingModel {
	
	private static final Logger LOG = LoggerFactory.getLogger(TestSlingModel.class);
	
	@ValueMapValue
	private long id;
	
	private boolean isValid;
	
	@ChildResource
	private List<MenuItemsList> itemsList;
	
	public long getId() {
		return id;
	}
	
	public boolean getValidity() {
		return isValid;
	}
	
	public List<MenuItemsList> getItemsList() {
		return itemsList;
	}
	
	@PostConstruct
	public void init() {
		isValid = id > 1_00_000 && id < 10_00_000;

	    LOG.info("ID = {}", id);
	    LOG.info("ITEMS = {}", itemsList);
	}
}









