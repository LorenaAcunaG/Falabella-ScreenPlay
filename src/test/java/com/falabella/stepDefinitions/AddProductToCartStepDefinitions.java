package com.falabella.stepDefinitions;

import com.falabella.questions.ProductCartValidationQuestion;
import com.falabella.questions.ProductNameValidationQuestion;
import com.falabella.questions.QuantityCartValidationQuestion;
import com.falabella.tasks.HomeTask;
import com.falabella.tasks.ProductCatalogTask;
import com.falabella.tasks.ProductDetailTask;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.OpenUrl;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;
import org.junit.matchers.JUnitMatchers;

import java.util.regex.Matcher;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class AddProductToCartStepDefinitions {

    @Before
    public void setStage(){
        setTheStage(new OnlineCast());
    }

    @Given("that the user opens Falabella page and searches any product")
    public void thatTheUserOpensFalabellaPageAndSearchesAnyProduct() {
        theActorCalled("User").wasAbleTo(
                Open.url("https://www.falabella.com.co/"),
                HomeTask.on()
        );
    }
    @When("the user selects one product from the list and clicks on it")
    public void theUserSelectsOneProductFromTheListAndClicksOnIt() {
        theActorInTheSpotlight().attemptsTo(
                ProductCatalogTask.on()
        );
        theActorInTheSpotlight().should(
                seeThat(
                        ProductNameValidationQuestion.from(), Matchers.equalTo(true)
                )
        );
    }
    @When("the user selects three units of the product and click on the button cart")
    public void theUserSelectsThreeUnitsOfTheProductAndClickOnTheButtonCart() {
        theActorInTheSpotlight().attemptsTo(
                ProductDetailTask.on()
        );
    }
    @Then("The user will see the product name and the correct units added to the cart successfully")
    public void theUserWillSeeTheProductNameAndTheCorrectUnitsAddedToTheCartSuccessfully() {
        theActorInTheSpotlight().should(
                seeThat(
                        ProductCartValidationQuestion.from(), Matchers.equalTo(true)
                )
        );
        theActorInTheSpotlight().should(
                seeThat(
                        QuantityCartValidationQuestion.from(), Matchers.equalTo(true)
                )
        );
    }


}
