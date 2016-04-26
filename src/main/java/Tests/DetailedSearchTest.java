package Tests;


import PageObjects.OurTeamPage;
import PageObjects.PersonalCoachPage;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class DetailedSearchTest extends BaseTest {


    OurTeamPage ourTeamPage;
    PersonalCoachPage personalPage;

    @Test
    public void LookingForArtem() {
        ourTeamPage = new OurTeamPage(driver);
        String coach = "Артем Карпов";

        ourTeamPage.openOurTeamPage();
        assertFalse("Why is " + coach + " here?!", ourTeamPage.coachIsPresent(coach));

    }

    @Test
    public void LookingForMisha() {
        ourTeamPage = new OurTeamPage(driver);
        personalPage = new PersonalCoachPage(driver);
        String coach = "Михаил Чокан";

        ourTeamPage.openOurTeamPage();
        ourTeamPage.openCoachPersonalPage(coach);
        assertTrue(coach + " not found ", personalPage.showsName(coach));
        assertTrue(coach + " specialisation not found ", personalPage.showsSpecialisation(specialisationOf(coach)));


    }

    @Test
    public void lookingForAlexander() {
        ourTeamPage = new OurTeamPage(driver);
        personalPage = new PersonalCoachPage(driver);
        String coach = "Александр Галковский";

        ourTeamPage.openOurTeamPage();
        ourTeamPage.openCoachPersonalPage(coach);
        assertTrue(coach + " not found ", personalPage.showsName(coach));
        assertTrue(coach + " specialisation not found ", personalPage.showsSpecialisation(specialisationOf(coach)));

    }


// enum coming soon

    public String specialisationOf(String coachName) {
        Map<String, String> Map = new HashMap<String, String>();
        Map.put("Артем Карпов", "QA Automation");
        Map.put("Михаил Чокан", "Координатор");
        Map.put("Александр Галковский", "Diving into Java");

        for (String key : Map.keySet()) {
            return Map.get(coachName);
        }
        return Map.get(coachName);
    }
}
