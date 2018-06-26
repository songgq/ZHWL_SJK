package com.ustcsoft.jt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations = { "file:src/test/resources/applicationContext-test.xml" })
public abstract class Base extends AbstractJUnit4SpringContextTests {

	//protected Logger logger = LoggerFactory.getLogger(getClass());

}
