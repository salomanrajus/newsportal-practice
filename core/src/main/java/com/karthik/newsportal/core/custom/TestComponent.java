package com.karthik.newsportal.core.custom;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(immediate = true)
public class TestComponent {
	private static final Logger LOG = LoggerFactory.getLogger(TestComponent.class); 
	
	@Activate
	public void activate() {
		LOG.info("Bundle: TestComponent  -- Method: Activate");
	}
	
	@Deactivate
	public void deactivate() {
		LOG.info("Bundle: TestComponent  -- Method: Deactivate");
	}
	
	@Modified
	public void update() {
		LOG.info("Bundle: TestComponent  -- Method: Deactivate");
	}
}
