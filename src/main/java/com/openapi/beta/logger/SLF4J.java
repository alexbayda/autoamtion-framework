package com.openapi.beta.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SLF4J {

    protected static Logger LOGGER = LoggerFactory.getLogger(SLF4J.class);


    public void process(String input) {
        LOGGER.info(input);
    }
}