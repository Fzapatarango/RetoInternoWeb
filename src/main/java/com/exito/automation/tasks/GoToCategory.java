package com.exito.automation.tasks;

import com.exito.automation.models.Model;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.exito.automation.userinterfaces.InicioDeSesionUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

@AllArgsConstructor
public class GoToCategory implements Task {

    private Model model;
    private int Quantity;

    public static GoToCategory inExito(Model model, int Quantity) {
        return Tasks.instrumented(GoToCategory.class, model, Quantity);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        for (int i = 1; i <= Quantity; i++) {
            actor.attemptsTo(Click.on(BTN_SIDE_MENU),
                    Click.on(BTN_CATEGORY.of(model.getCategory())),
                    WaitUntil.the(BTN_SUBCATEGORY.of(model.getSubcategory()), isVisible()).forNoMoreThan(2).seconds(),
                    Click.on(BTN_SUBCATEGORY.of(model.getSubcategory())),
                    Click.on(LST_PRODUCTS.of(Integer.toString(i))));
            actor.attemptsTo(
                    BuyProducts.onExito());
        }
        actor.attemptsTo(Click.on(BTN_CART));
        actor.remember("PRODUCTS_ADDED", Quantity);
    }
}
