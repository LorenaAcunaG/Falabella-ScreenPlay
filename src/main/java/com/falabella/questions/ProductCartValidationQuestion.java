package com.falabella.questions;

import com.falabella.utils.Data;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.falabella.ui.CartUI.LNK_PRODUCT_CART;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ProductCartValidationQuestion implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {

        WebElementFacade productCart = LNK_PRODUCT_CART.resolveFor(actor);
        WaitUntil.the(LNK_PRODUCT_CART, isVisible()).forNoMoreThan(30).seconds();
        return Data.extractTo().get(0).get("Validation").contains(productCart.getText().toString());
    }

    public static Question<Boolean> from(){return new ProductCartValidationQuestion();}
}
