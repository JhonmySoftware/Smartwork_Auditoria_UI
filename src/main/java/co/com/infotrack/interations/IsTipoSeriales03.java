package co.com.infotrack.interations;

import co.com.infotrack.interations.Seriales.inputsListaCantidad;
import co.com.infotrack.userinterfaces.ObGestionarAuditoria;
import co.com.infotrack.utils.UsCargarArchivos;
import co.com.infotrack.utils.UsObtenerVentanasNavegador;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

import java.io.IOException;
import java.util.Arrays;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class IsTipoSeriales03 implements Interaction {

    public static IsTipoSeriales03 one() {
        return Instrumented.instanceOf(IsTipoSeriales03.class).withProperties();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Instancia para utilizar el metodo de cargue de archivos

        try {
            UsCargarArchivos.CrearAuditoria();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String[] listadoItems1 = {"SERIAL","Serial"};
        if (Arrays.asList(listadoItems1).contains(UsCargarArchivos.properties.getProperty("Item"))) {

            actor.attemptsTo(inputsListaCantidad.one());
            //UsObtenerVentanasNavegador Ventana1 = new UsObtenerVentanasNavegador(getDriver(), 0);
        }


    }
}
