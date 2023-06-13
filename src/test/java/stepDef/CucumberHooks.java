package stepDef;

import cucumber.api.java.Before;

import java.io.IOException;

public class CucumberHooks extends TestBase{
    @Before
    public void initialization() throws IOException {
        setUp();
    }

//    @After
//    public void tearDown() {
//        closeBrowser();
//    }
}
