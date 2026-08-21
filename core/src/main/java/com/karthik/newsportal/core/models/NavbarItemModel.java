package com.karthik.newsportal.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class)
public class NavbarItemModel {

    @ValueMapValue
    private String menuText;

    @ValueMapValue
    private String menuLink;

    public String getMenuText() {
        return menuText;
    }

    public String getMenuLink() {
        return menuLink;
    }
}