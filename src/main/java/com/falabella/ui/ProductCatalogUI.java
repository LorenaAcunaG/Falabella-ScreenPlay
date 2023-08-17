package com.falabella.ui;

import net.serenitybdd.screenplay.targets.Target;

public class ProductCatalogUI {
    public static Target LNK_PRODUCT_NAME = Target.the("Product list")
            .locatedBy("//a[@class='jsx-1576191951 section-body pod-link']");
}
