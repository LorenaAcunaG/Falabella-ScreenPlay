package com.falabella.ui;

import net.serenitybdd.screenplay.targets.Target;

public class CartUI {

    public static Target BTN_CART = Target.the("Cart button")
            .locatedBy("//button[@id='add-to-cart-button']");

    public static Target LNK_CART = Target.the("Link to cart")
            .locatedBy("//a[@id='linkButton']");

    public static Target LNK_PRODUCT_CART = Target.the("Product name in cart")
            .locatedBy("//a[@class='chakra-link css-qpfo7l']");

    public static Target TXT_QUANTITY_CART = Target.the("Quantity product in cart")
            .locatedBy("//input[@class='chakra-input css-1k2vvg6']");
}
