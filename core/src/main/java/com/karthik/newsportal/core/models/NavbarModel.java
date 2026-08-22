package com.karthik.newsportal.core.models;

import java.util.List;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

@Model(adaptables = Resource.class)
public class NavbarModel {

    @ChildResource
    private List<NavbarItemModel> menuItems;

    public List<NavbarItemModel> getMenuItems() {
        return menuItems;
    }
}