package co.com.infotrack.interations.Seriales;

import co.com.infotrack.userinterfaces.ProcesoAuditoria.ObGestionarAuditoria;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class BtnAgregarList implements Interaction {

    public static BtnAgregarList one() {
        return Instrumented.instanceOf(BtnAgregarList.class).withProperties();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        // Lista de objetivos (targets) a los que se quiere interactuar
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

        // Itera sobre cada objetivo en la lista de objetivos
        for (Target target : listaTarget) {
            // Resuelve el objetivo para el actor y obtiene el elemento web correspondiente
            WebElementFacade elemento = target.resolveFor(actor);
            // Verifica si el elemento es visible y está habilitado para interactuar
            if (elemento.isVisible() && elemento.isEnabled()) {
                // Espera hasta que el elemento sea clickable, luego realiza un clic en él
                elemento.withTimeoutOf(Duration.ofSeconds(10)).waitUntilClickable().click();
                try {
                    // Espera de 2 segundos después del clic (opcional)
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                // Lanza una excepción si el elemento no es visible o no es interactivo
                throw new RuntimeException("El elemento no es visible o no es interactivo: " + target);
            }
        }
    }

}
