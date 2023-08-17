package com.falabella.interactions;

import com.falabella.utils.WriteInExcel;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;

import java.util.List;
import java.util.Random;

import static com.falabella.ui.ProductCatalogUI.LNK_PRODUCT_NAME;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ClickRandom implements Interaction{

    private WebElementFacade element;
    @Override
    public <T extends Actor> void performAs(T actor) {
        List<WebElementFacade> ProductList = LNK_PRODUCT_NAME.resolveAllFor(actor);
        Random random = new Random();
        int indexRandom = random.nextInt(ProductList.size());
        element = ProductList.get(indexRandom);

        WriteInExcel.writeInExcel(
                "src/test/resources/Data/Data.xlsx",
                ProductList.get(indexRandom).getText(), 1, 1);

        ProductList.get(indexRandom).click();
    }

    public static Performable click(){
        return instrumented(ClickRandom.class);
    }
}
