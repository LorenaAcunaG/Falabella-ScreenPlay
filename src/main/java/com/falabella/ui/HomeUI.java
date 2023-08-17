package com.falabella.ui;

import net.serenitybdd.screenplay.targets.Target;

public class HomeUI {
    public static Target TXT_SEARCH = Target.the("search bar")
            .locatedBy("//input[@id='testId-SearchBar-Input']");
}
