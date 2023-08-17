package com.falabella.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;

import static com.falabella.ui.CartUI.BTN_CART;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ClickToCart implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        BTN_CART.resolveFor(actor).click();
    }

    public static Performable clickToCart(){
        return instrumented(ClickToCart.class);
    }
}
