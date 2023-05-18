package co.com.infotrack.interations.CerrarVentana;

import co.com.infotrack.userinterfaces.ObGestionarAuditoria;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.Wait;

public class CerrarVentanaAuditoria implements Interaction {

    public static CerrarVentanaAuditoria one() {
        return Instrumented.instanceOf(CerrarVentanaAuditoria.class).withProperties();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Cerrar Ventana de la Auditoria
        actor.attemptsTo(Wait.until(
                        WebElementQuestion.the(ObGestionarAuditoria.CrVentanaAuditoria),
                        WebElementStateMatchers.isVisible()
                ).forNoLongerThan(20).seconds(),
                Click.on(ObGestionarAuditoria.CrVentanaAuditoria)
        );

        // Esperar para ver el estado de la auditoria
        actor.attemptsTo(Wait.until(
                WebElementQuestion.the(ObGestionarAuditoria.VrEstadoAuditoria),
                WebElementStateMatchers.isVisible()
        ).forNoLongerThan(20).seconds());
    }
}
