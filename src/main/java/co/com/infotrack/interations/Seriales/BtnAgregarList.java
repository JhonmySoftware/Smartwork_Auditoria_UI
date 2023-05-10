package co.com.infotrack.interations.Seriales;

import co.com.infotrack.userinterfaces.ObGestionarAuditoria;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class BtnAgregarList implements Interaction {

    public static BtnAgregarList one() {
        return Instrumented.instanceOf(BtnAgregarList.class).withProperties();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        List<Target> listaTarget = Arrays.asList(
                ObGestionarAuditoria.AgregarCatidadConteo,
                ObGestionarAuditoria.AgregarCatidadConteo2,
                ObGestionarAuditoria.AgregarCatidadConteo3,
                ObGestionarAuditoria.AgregarCatidadConteo4,
                ObGestionarAuditoria.AgregarCatidadConteo5,
                ObGestionarAuditoria.AgregarCatidadConteo6,
                ObGestionarAuditoria.AgregarCatidadConteo7,
                ObGestionarAuditoria.AgregarCatidadConteo8,
                ObGestionarAuditoria.AgregarCatidadConteo9,
                ObGestionarAuditoria.AgregarCatidadConteo10
        );

        for (Target target : listaTarget) {
            WebElementFacade elemento = target.resolveFor(actor);
            if (elemento.isVisible() && elemento.isEnabled()) {
                elemento.withTimeoutOf(Duration.ofSeconds(10)).waitUntilClickable().click();
                try {
                    Thread.sleep(2000); // Espera de 2 segundos después del clic (opcional)
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                throw new RuntimeException("El elemento no es visible o no es interactivo: " + target);
            }

        }



    }
}
