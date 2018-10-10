package hellocucumber;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import static org.junit.Assert.*;

class IsItFriday {
    static String isItFriday(String today) {
        if(today.equals("Friday")){
            return "TGIF";
        }
        return "Shit";
    }
}

public class Stepdefs {

    private String today;
    private String actualAnswer;

    @Given("^today is Sunday$")
    public void today_is_sunday(){
        this.today = "Sunday";
    }

    @When("^I ask whether it's Friday yet$")
    public void i_ask_whether_today_is_is_Friday(){
        this.actualAnswer = IsItFriday.isItFriday(today);
    }

    @Then("^I should be told \"([^\"]*)\"$")
    public void no_It_is_not(String expectedAnswer){
        assertEquals(expectedAnswer, actualAnswer);
    }

    @Given("^today is Friday$")
    public void today_is_Friday(){
        this.today = "Friday";
    }
}