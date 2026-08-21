package com.karthik.newsportal.core.raju;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(immediate=true)
public class PhantomComponent {
	public final static Logger LOG = LoggerFactory.getLogger("PhantomComponent.class");
	
	@Activate
	public void activate() {
		LOG.info("Bundle -- PhantomComponent  --  Activate");
	}
	
	@Deactivate
	public void deactivate() {
		LOG.info("Bundle -- PhantomComponent -- Deactivate");
	}
	
	@Modified
	public void update() {
		LOG.info("Bundle -- PhantomComponent -- Update");
	}
}
