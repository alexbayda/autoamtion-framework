package com.herokuapp.katalon.driver;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:${env}.properties"})
public interface GeneralConfig extends Config {

    @Config.Key("website.url")
    String url();

}
