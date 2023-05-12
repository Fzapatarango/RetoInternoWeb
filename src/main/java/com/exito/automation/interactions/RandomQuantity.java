package com.exito.automation.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.Random;

import static com.exito.automation.userinterfaces.InicioDeSesionUI.BTN_ADD_QUANTITY;
import static com.exito.automation.userinterfaces.InicioDeSesionUI.LBL_QUANTITY;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;


public class RandomQuantity implements Interaction {


    public static RandomQuantity ofProduct() {
        return Tasks.instrumented(RandomQuantity.class);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        Random random = new Random();
        int quantity;
        quantity = random.nextInt(9);

        for (int i = 0; i < quantity; i++) {
            actor.attemptsTo(
                    WaitUntil.the(BTN_ADD_QUANTITY, isEnabled()).forNoMoreThan(2).seconds(),
                    Click.on(BTN_ADD_QUANTITY));
        }
        actor.remember("QUANTITIES", Integer.parseInt(LBL_QUANTITY.resolveFor(actor).getText().replace(".00", "").
                replace(" un", "")));
    }
}
