package com.falabella.questions;

import com.falabella.utils.Data;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;


import static com.falabella.ui.CartUI.TXT_QUANTITY_CART;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class QuantityCartValidationQuestion implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {

        WebElementFacade quantityCart = TXT_QUANTITY_CART.resolveFor(actor);
        WaitUntil.the(TXT_QUANTITY_CART, isVisible()).forNoMoreThan(30).seconds();
        return Data.extractTo().get(0).get("Quantity").contains(quantityCart.getText().toString());
    }

    public static Question<Boolean> from(){return new QuantityCartValidationQuestion();}
}
