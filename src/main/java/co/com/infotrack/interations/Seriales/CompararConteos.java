package co.com.infotrack.interations.Seriales;

import co.com.infotrack.userinterfaces.ObGestionarAuditoria;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.Wait;

public class CompararConteos implements Interaction {

    public static CompararConteos one() {
        return Instrumented.instanceOf(CompararConteos.class).withProperties();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Comparar el conteo uno con el conteo dos
        actor.attemptsTo(Click.on(ObGestionarAuditoria.CompararConteo),
                Click.on(ObGestionarAuditoria.ConteoComparar),
                Wait.until(
                        WebElementQuestion.the(ObGestionarAuditoria.ConteoCompararList),
                        WebElementStateMatchers.isEnabled()
                ).forNoLongerThan(10).seconds(),
                Click.on(ObGestionarAuditoria.ConteoCompararList),
                Click.on(ObGestionarAuditoria.CompararConteosfin));

    }
}
