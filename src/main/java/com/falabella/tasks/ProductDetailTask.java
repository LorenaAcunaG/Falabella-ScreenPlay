package com.falabella.tasks;

import com.falabella.interactions.ClickToCart;
import com.falabella.interactions.SelectQuantity;
import com.falabella.utils.Data;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.falabella.ui.CartUI.LNK_CART;
import static com.falabella.ui.QuantityUI.TXT_QUANTITY;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ProductDetailTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SelectQuantity.selectQty(),
                Enter.theValue(Data.extractTo().get(0).get("Quantity")).into(TXT_QUANTITY),
                ClickToCart.clickToCart()
        );

        WaitUntil.the(LNK_CART, isVisible()).forNoMoreThan(30).seconds();
        LNK_CART.resolveFor(actor).click();
    }
    public static ProductDetailTask on(){
        return instrumented(ProductDetailTask.class);
    }
}
