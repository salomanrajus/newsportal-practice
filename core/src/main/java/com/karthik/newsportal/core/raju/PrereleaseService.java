package com.karthik.newsportal.core.raju;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(immediate = true)
public class PrereleaseService {
	
	private static final Logger Log = LoggerFactory.getLogger(PrereleaseService.class);
	
	@Reference
	RajuService service;
	
	@Activate
	public void activate(){
		String ar = service.getarticle();
		Log.info("PrereleaseService -- Inside the Activate Method");
		Log.info("Response --{}",ar);
		
	}
	
	@Deactivate
	public void deactivate(){
		Log.info("PrereleaseService -- Inside the Deactivate Method");
		
	}
	
	@Modified
	public void update(){
		Log.info("PrereleaseService -- Inside the Update Method");
		
	}
}