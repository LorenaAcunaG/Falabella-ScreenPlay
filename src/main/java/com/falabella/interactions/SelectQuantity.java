package com.falabella.interactions;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import org.openqa.selenium.Keys;

import static com.falabella.ui.QuantityUI.TXT_QUANTITY;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectQuantity implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        TXT_QUANTITY.resolveFor(actor).clear();

        int length = TXT_QUANTITY.resolveFor(actor).getValue().length();
        for (int i = 0; i < length; i++) {
            TXT_QUANTITY.resolveFor(actor).sendKeys(Keys.ARROW_RIGHT);
        }

        TXT_QUANTITY.resolveFor(actor).clear();
    }

    public static Performable selectQty(){
        return instrumented(SelectQuantity.class);
    }
}
