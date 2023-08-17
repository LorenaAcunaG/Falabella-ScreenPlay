package com.falabella.ui;

import net.serenitybdd.screenplay.targets.Target;

public class ProductDetailUI {
    public static Target LBL_PRODUCT_NAME = Target.the("Product detail")
            .locatedBy("//h1[@class='jsx-1680787435 product-name fa--product-name false']");
}
