package com.falabella.ui;

import net.serenitybdd.screenplay.targets.Target;

public class QuantityUI {

    public static Target TXT_QUANTITY = Target.the("Quantity products to cart")
            .locatedBy("//input[@id='quantity-selector-increment-input']");
}
