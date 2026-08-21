package com.karthik.newsportal.core.custom;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = AnonServiceComponent.class, immediate = true)
@Designate(ocd = AnonConfiguration.class)
public class AnonServiceComponent {
	private static final Logger LOG = LoggerFactory.getLogger(AnonServiceComponent.class);
	
	String restAPIURL;
	
	@Activate
	public void activate(AnonConfiguration config) {
		LOG.info("Bundle: AnonServiceComponent -- Method: Activate");
		this.restAPIURL = config.restApiUrl();
	}
	
	@Modified
	public void update(AnonConfiguration config) {
		LOG.info("Bundle: AnonServiceComponent -- Method: Update");
		this.restAPIURL = config.restApiUrl();
	}
	
	public String getResult() {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet request = new HttpGet(restAPIURL);
		String result = null;
		
		try {
			CloseableHttpResponse response = httpClient.execute(request);
			HttpEntity entity = response.getEntity();
			
			if(entity != null) {
				result = EntityUtils.toString(entity);
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}
