package com.falabella.tasks;

import com.falabella.utils.Data;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static com.falabella.ui.HomeUI.TXT_SEARCH;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class HomeTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(Data.extractTo().get(0).get("Search")).into(TXT_SEARCH).thenHit(Keys.ENTER)
        );
    }

    public static HomeTask on(){
        return instrumented(HomeTask.class);
    }
}
