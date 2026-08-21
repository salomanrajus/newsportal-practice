package com.karthik.newsportal.core.models;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;


@Model(adaptables = {Resource.class, SlingHttpServletRequest.class}, 
resourceType = "newsportal/components/raju", 
defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(extensions = "json", name = "jackson")
public class MenuItemsModel {

    @ValueMapValue
    private String text;

    @ValueMapValue
    private String desc;

	@ValueMapValue
    private Date expireDate;
	

	public String getText() {
		return text;
	}

	public String getDesc() {
		return desc;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public boolean articleExpired = false;

    public boolean isArticleExpired() {
		return articleExpired;
	}
    
    public List<RelatedMenuItemsModel> getMenu() {
		return menu;
	}
	
	@ChildResource
    private List<RelatedMenuItemsModel> menu;

	@PostConstruct
    public void init() {
    	Date today = new Date();
    	if(expireDate != null && expireDate.compareTo(today)<0) {
    		articleExpired = true;
    	}
    }
    
}
