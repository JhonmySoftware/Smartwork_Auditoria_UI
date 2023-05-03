package co.com.infotrack.interations;

import co.com.infotrack.userinterfaces.ObProcesoAuditoria;
import co.com.infotrack.utils.CargarArchivos;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.Wait;

import java.io.IOException;

public class IsCrearAuditoria01 implements Interaction {

    public static IsCrearAuditoria01 one() {
        return Instrumented.instanceOf(IsCrearAuditoria01.class).withProperties();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            CargarArchivos.CrearAuditoria();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Crear Auditoria
        actor.attemptsTo(Wait.until(
                        WebElementQuestion.the(ObProcesoAuditoria.Bodega),
                        WebElementStateMatchers.isEnabled()
                ).forNoLongerThan(10).seconds(),
                Enter.theValue(CargarArchivos.properties.getProperty("Bodega"))
                        .into(ObProcesoAuditoria.Bodega),
                Click.on(ObProcesoAuditoria.ListBodega),
                Enter.theValue(CargarArchivos.properties.getProperty("TipoDocumento"))
                        .into(ObProcesoAuditoria.TipoDocumento),
                Click.on(ObProcesoAuditoria.ListTipoDocumento),
                Enter.theValue(CargarArchivos.properties.getProperty("Division"))
                        .into(ObProcesoAuditoria.Division),
                Click.on(ObProcesoAuditoria.ListDivision),
                Enter.theValue(CargarArchivos.properties.getProperty("Familia"))
                        .into(ObProcesoAuditoria.Familia),
                Click.on(ObProcesoAuditoria.ListaFamilia),
                Enter.theValue(CargarArchivos.properties.getProperty("Item"))
                        .into(ObProcesoAuditoria.Item),
                Click.on(ObProcesoAuditoria.ListItem),
                Click.on(ObProcesoAuditoria.Guardar)
        );
    }
}
