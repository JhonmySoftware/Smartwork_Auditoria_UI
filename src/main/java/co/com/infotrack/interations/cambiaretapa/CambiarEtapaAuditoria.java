package co.com.infotrack.interations.cambiaretapa;

import co.com.infotrack.userinterfaces.ProcesoAuditoria.ObGestionarAuditoria;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.Wait;

public class CambiarEtapaAuditoria implements Interaction {

    public static CambiarEtapaAuditoria one() {
        return Instrumented.instanceOf(CambiarEtapaAuditoria.class).withProperties();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        // Cambiar la etapa del producto - Alistamiento
        actor.attemptsTo(Wait.until(
                        WebElementQuestion.the(ObGestionarAuditoria.CambiarEtapa),
                        WebElementStateMatchers.isEnabled()
                ).forNoLongerThan(10).seconds(),
                Click.on(ObGestionarAuditoria.CambiarEtapa),
                Click.on(ObGestionarAuditoria.CambiarEtapaList),
                Click.on(ObGestionarAuditoria.ContinuarCEtapa)
        );

        // Cambiar la etapa del producto - Finalizado
        actor.attemptsTo(Wait.until(
                        WebElementQuestion.the(ObGestionarAuditoria.CambiarEtapa),
                        WebElementStateMatchers.isEnabled()
                ).forNoLongerThan(10).seconds(),
                Click.on(ObGestionarAuditoria.CambiarEtapa),
                Click.on(ObGestionarAuditoria.CambiarEtapaList),
                Wait.until(
                        WebElementQuestion.the(ObGestionarAuditoria.ConteoFinalizar),
                        WebElementStateMatchers.isEnabled()
                ).forNoLongerThan(10).seconds(),
                Click.on(ObGestionarAuditoria.ConteoFinalizar),
                Wait.until(
                        WebElementQuestion.the(ObGestionarAuditoria.ConteoFinalizarList),
                        WebElementStateMatchers.isEnabled()
                ).forNoLongerThan(10).seconds(),
                Click.on(ObGestionarAuditoria.ConteoFinalizarList));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        actor.attemptsTo(Click.on(ObGestionarAuditoria.FinalizarAuditoria),
                Click.on(ObGestionarAuditoria.ContinuarCEtapa));

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
