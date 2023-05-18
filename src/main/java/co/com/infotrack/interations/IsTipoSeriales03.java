package co.com.infotrack.interations;

import co.com.infotrack.interations.Seriales.inputsListaCantidad;
import co.com.infotrack.utils.UsCargarArchivos;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import java.io.IOException;

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

        String[] listadoItems1 = {"SERIAL", "Serial"};
        String item = UsCargarArchivos.properties.getProperty("Item");

        boolean encontrado = false;
        for (String listItem : listadoItems1) {
            if (listItem.equalsIgnoreCase(item)) {
                encontrado = true;
                break;
            }
        }
        if (encontrado) {
            actor.attemptsTo(inputsListaCantidad.one());
            //UsObtenerVentanasNavegador Ventana1 = new UsObtenerVentanasNavegador(getDriver(), 0);
        }


    }
}
