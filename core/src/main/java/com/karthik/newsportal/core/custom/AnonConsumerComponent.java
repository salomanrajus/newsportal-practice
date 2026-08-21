package com.karthik.newsportal.core.custom;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(immediate = true)
public class AnonConsumerComponent {
	private static final Logger LOG = LoggerFactory.getLogger(AnonConsumerComponent.class);
	
	@Reference
	private AnonServiceComponent service;
	
	@Activate
	public void activate() {
		String result = service.getResult();
		LOG.info("Bundle: AnonConsumerComponent -- Method: Activate");
		LOG.info("Bundle: AnonConsumerComponent -- Response : {}", result);
	}
	
	@Deactivate
	public void deactivate() {
		LOG.info("Bundle: AnonConsumerComponent -- Method: Deactivate");
	}
	
	@Modified
	public void update() {
		LOG.info("Bundle: AnonConsumerComponent -- Method: Update");
	}
}
