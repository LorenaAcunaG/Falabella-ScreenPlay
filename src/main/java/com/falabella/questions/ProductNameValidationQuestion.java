package com.falabella.questions;

import com.falabella.utils.Data;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.falabella.ui.ProductDetailUI.LBL_PRODUCT_NAME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ProductNameValidationQuestion implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        WebElementFacade productName = LBL_PRODUCT_NAME.resolveFor(actor);
        WaitUntil.the(LBL_PRODUCT_NAME, isVisible()).forNoMoreThan(30).seconds();
        return Data.extractTo().get(0).get("Validation").contains(productName.getText().toString());
    }

    public static Question<Boolean> from(){
        return new ProductNameValidationQuestion();
    }
}
