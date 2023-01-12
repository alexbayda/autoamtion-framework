package com.figma.beta.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Logs {

    private static final Logger log = LoggerFactory.getLogger(Logs.class);

    public void process(String input) {
        log.info(input);
    }
}