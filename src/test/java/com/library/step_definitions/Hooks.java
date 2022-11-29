package com.library.step_definitions;

import com.library.utility.ConfigurationReader;
import com.library.utility.DB_Util;
import com.library.utility.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setUp(){

        System.out.println("this is coming from BEFORE");
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get(ConfigurationReader.getProperty("library_url"));


    }

    @After
    public void tearDown(Scenario scenario){
        System.out.println("this is coming from AFTER");

        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }

        Driver.closeDriver();
    }
        @Before("@db")
        public void setUpDB(){
            DB_Util.createConnection();
            System.out.println(" conection to database......");
        }
        @After("@db")
        public void destroyDB(){
            DB_Util.destroy();
            System.out.println("close  conection ........");
        }
/*
when we run different feature do we need to change tagName from hooks class? from before and after
-if we have @db tag over the feature/scenario this hooks (After/Before with db) will run

Since we are dooooing database if you add
 */
}
