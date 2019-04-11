package testsCases;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.HomePage;
import pages.StandingPage;

public class espnTest {

    private HomePage homePage;
    private StandingPage standingPage;


    @Before
    public void iniciar(){
        homePage = new HomePage();
        standingPage = new StandingPage();
    }


    @Test
    public void testEPSN(){
        homePage.hoverNFLMenu();
        homePage.clickStandings();
        String URL = standingPage.clickPlayOff();
        String currentURL = standingPage.getURL();
        Assert.assertEquals(URL, currentURL);
    }

    @After
    public void finish() {
        standingPage.finish();
        homePage = null;
        standingPage = null;
    }
}
