package com.frc.investment.client;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BaseClient {
	protected ApplicationContext ac = null;
	protected Logger log = Logger.getLogger(BaseClient.class);
	
	protected void init() {
		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
}
