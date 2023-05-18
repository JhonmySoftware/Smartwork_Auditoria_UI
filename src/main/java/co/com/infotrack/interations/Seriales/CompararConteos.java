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

    // Método estático para obtener una instancia de CompararConteos
    public static CompararConteos one() {
        return Instrumented.instanceOf(CompararConteos.class).withProperties();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Método que define cómo se realiza la interacción

        // El actor intenta hacer clic en algunos elementos y esperar hasta que
        // otro elemento esté habilitado durante un máximo de 10 segundos

        actor.attemptsTo(
                Click.on(ObGestionarAuditoria.CompararConteo), // Hace clic en un elemento llamado CompararConteo
                Click.on(ObGestionarAuditoria.ConteoComparar), // Hace clic en un elemento llamado ConteoComparar
                Wait.until(
                        WebElementQuestion.the(ObGestionarAuditoria.ConteoCompararList),
                        WebElementStateMatchers.isEnabled()
                ).forNoLongerThan(10).seconds(), // Espera hasta que el elemento ConteoCompararList esté habilitado durante 10 segundos como máximo
                Click.on(ObGestionarAuditoria.ConteoCompararList), // Hace clic en un elemento llamado ConteoCompararList
                Click.on(ObGestionarAuditoria.CompararConteosfin) // Hace clic en un elemento llamado CompararConteosfin
        );

    }
}

