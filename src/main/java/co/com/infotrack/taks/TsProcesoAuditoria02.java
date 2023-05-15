package co.com.infotrack.taks;

import co.com.infotrack.interations.Seriales.IsCrearAuditoria01;
import co.com.infotrack.interations.IsGestionarAuditoria02;
import co.com.infotrack.userinterfaces.ObProcesoAuditoria;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.Wait;

public class TsProcesoAuditoria02 implements Task {

    public static TsProcesoAuditoria02 one() {
        return Tasks.instrumented(TsProcesoAuditoria02.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Proceso de auditoria
        actor.attemptsTo(Wait.until(
                        WebElementQuestion.the(ObProcesoAuditoria.Inventario),
                        WebElementStateMatchers.isVisible()
                ).forNoLongerThan(30).seconds(),
                Click.on(ObProcesoAuditoria.Inventario),
                Click.on(ObProcesoAuditoria.Auditoria)
        );
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        actor.attemptsTo(Wait.until(
                        WebElementQuestion.the(ObProcesoAuditoria.AddAuditoria),
                        WebElementStateMatchers.isVisible()
                ).forNoLongerThan(10).seconds(),
                Click.on(ObProcesoAuditoria.AddAuditoria));

        // Crear Auditoria
        actor.attemptsTo(IsCrearAuditoria01.one());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Gestionar la Auditorio - Conteo
        actor.attemptsTo(IsGestionarAuditoria02.one());



    }
}
