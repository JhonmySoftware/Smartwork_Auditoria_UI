package co.com.infotrack.interations.GestionarAuditoria;

import co.com.infotrack.interations.CerrarVentana.CerrarVentanaAuditoria;
import co.com.infotrack.interations.CompararConteos.CompararConteos;
import co.com.infotrack.interations.Seriales.IsTipoSeriales03;
import co.com.infotrack.interations.cambiaretapa.CambiarEtapaAuditoria;
import co.com.infotrack.userinterfaces.ProcesoAuditoria.ObGestionarAuditoria;
import co.com.infotrack.utils.ConsultaBaseDatos;
import co.com.infotrack.utils.UsCargarArchivos;
import co.com.infotrack.utils.UsObtenerVentanasNavegador;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.Wait;
import org.openqa.selenium.WebDriver;

import javax.swing.*;
import java.io.IOException;
import java.util.*;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class IsGestionarAuditoria02 implements Interaction {
    public static IsGestionarAuditoria02 one() {
        return Instrumented.instanceOf(IsGestionarAuditoria02.class).withProperties();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            UsCargarArchivos.CrearAuditoria();
            Thread.sleep(1000);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Gestionar Auditoria
        actor.attemptsTo(Wait.until(
                        WebElementQuestion.the(ObGestionarAuditoria.Description),
                        WebElementStateMatchers.isEnabled()
                ).forNoLongerThan(10).seconds(),
                Scroll.to(ObGestionarAuditoria.Description),
                Enter.theValue(UsCargarArchivos.properties.getProperty("Description"))
                        .into(ObGestionarAuditoria.Description),
                Enter.theValue(UsCargarArchivos.properties.getProperty("Observation"))
                        .into(ObGestionarAuditoria.Observation),
                Enter.theValue(UsCargarArchivos.properties.getProperty("TipoConteo"))
                        .into(ObGestionarAuditoria.TipoConteo),
                Click.on(ObGestionarAuditoria.ListTipoConteo),
                Click.on(ObGestionarAuditoria.Guardar2)
        );

        ConsultaBaseDatos consultaBaseDatos = new ConsultaBaseDatos();
        List<String> listaItems = consultaBaseDatos.consultarBaseDatos();

        String[] listadoItems1 = listaItems.toArray(new String[0]);
        // Imprimir el listado actualizado
        for (String item : listadoItems1) {
            System.out.println(item);
        }

        String item = UsCargarArchivos.properties.getProperty("Item");

        boolean encontrado = false;
        for (String listItem : listadoItems1) {
            if (listItem.equalsIgnoreCase(item)) {
                encontrado = true;
                break;
            }
        }
        if (encontrado) {
            // código a ejecutar si el valor de "Item" está en la lista de "listadoItems1"
            // Comparar el conteo
            try {
                actor.attemptsTo(Click.on(ObGestionarAuditoria.CompararConteo));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Los parámetros configurados en la auditoria " +
                        "no permitieron encontrar movimientos que permitan calcular el stock disponible o no se " +
                        "encuentra diferencias en el inventario.: Validar Familia Inventario ");
            }

            // Obtener el manejador de ventanas
            WebDriver driver = getDriver();
            // Obtener el identificador de la ventana actual
            String currentWindowHandle = driver.getWindowHandle();
            // Obtener los identificadores de todas las ventanas abiertas
            Set<String> allWindowHandles = driver.getWindowHandles();

            // Iterar sobre cada identificador de ventana
            String secondWindowHandle = null;
            for (String windowHandle : allWindowHandles) {
                // Si el identificador de ventana no es igual al identificador de la ventana actual
                if (!windowHandle.equals(currentWindowHandle)) {
                    // Cambiar el enfoque del controlador a la ventana deseada
                    driver.switchTo().window(windowHandle);
                    // Guardar el identificador de la segunda ventana en una variable
                    secondWindowHandle = windowHandle;
                }
            }

            // Obtener la cantidad del stock para realizar el conteo
            List<String> Orden = Collections.singletonList(ObGestionarAuditoria.ObtenerCantidadStock
                    .resolveFor(actor).getText());
            String CantidadStock = Orden.get(0);
            System.out.println("Cantidad del Stock Obtenida es: " + Orden.size());
            System.out.println("Nombre de Orden Obtenida : " + Orden.get(0));

            // Volver a la ventana anterior
            driver.switchTo().window(currentWindowHandle);

            // Hacer clic en el botón Gestionar Conteo
            actor.attemptsTo(Click.on(ObGestionarAuditoria.GestionarConteo));

            //
            driver.switchTo().window(secondWindowHandle);

            // Obtener los identificadores de ventana
            List<String> windowHandlesList = new ArrayList<>(driver.getWindowHandles());

            // Cambiar el control de la ventana a la tercera
            driver.switchTo().window(windowHandlesList.get(2));


            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // Ingreso la cantidad obtenida en la comparación del conteo
            actor.attemptsTo(
                    Switch.toActiveElement(),
                    Wait.until(
                            WebElementQuestion.the(ObGestionarAuditoria.IngresarCatidadConteo),
                            WebElementStateMatchers.isVisible()
                    ).forNoLongerThan(5).seconds(),
                    Enter.theValue(CantidadStock).into(ObGestionarAuditoria.IngresarCatidadConteo),
                    Scroll.to(ObGestionarAuditoria.AgregarCatidadConteo),
                    Click.on(ObGestionarAuditoria.AgregarCatidadConteo)
            );

            // Cerrar ventana Actual y regresar a la principal
            driver.close();
            driver.switchTo().window(secondWindowHandle);
            driver.close();
            driver.switchTo().window(currentWindowHandle);

            // Conteo Numero 2 - Auditoria
            actor.attemptsTo(Wait.until(
                            WebElementQuestion.the(ObGestionarAuditoria.Description),
                            WebElementStateMatchers.isVisible()
                    ).forNoLongerThan(10).seconds(),
                    Enter.theValue(UsCargarArchivos.properties.getProperty("Description")+("2"))
                            .into(ObGestionarAuditoria.Description),
                    Enter.theValue(UsCargarArchivos.properties.getProperty("Observation")+("2"))
                            .into(ObGestionarAuditoria.Observation),
                    Enter.theValue(UsCargarArchivos.properties.getProperty("TipoConteo"))
                            .into(ObGestionarAuditoria.TipoConteo),
                    Click.on(ObGestionarAuditoria.ListTipoConteo),
                    Click.on(ObGestionarAuditoria.Guardar2)
            );

            // Gestionar el segundo conteo con la misma cantidad que se obtuvo en la primera comparación
            actor.attemptsTo(
                    Click.on(ObGestionarAuditoria.GestionarConteo2)
            );

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // Obtener la lista de ventanas disponibles
            Set<String> windowHandles = driver.getWindowHandles();

            // Obtener el identificador de la segunda ventana
            String secondWindowHandle1 = (String) windowHandles.toArray()[1];

            // Cambiar el foco del controlador del navegador a la segunda ventana
            driver.switchTo().window(secondWindowHandle1);
            actor.attemptsTo(Switch.toActiveElement(),
                    Wait.until(
                            WebElementQuestion.the(ObGestionarAuditoria.IngresarCatidadConteo),
                            WebElementStateMatchers.isVisible()
                    ).forNoLongerThan(10).seconds(),
                    Enter.theValue(CantidadStock).into(ObGestionarAuditoria.IngresarCatidadConteo),
                    Scroll.to(ObGestionarAuditoria.AgregarCatidadConteo),
                    Click.on(ObGestionarAuditoria.AgregarCatidadConteo)
            );
            driver.close();

            // Obtener la lista de ventanas disponibles
            Set<String> windowHandles2 = driver.getWindowHandles();
            // Obtener el identificador de la segunda ventana
            String secondWindowHandle2 = (String) windowHandles2.toArray()[0];
            // Cambiar el foco del controlador del navegador a la primera ventana
            driver.switchTo().window(secondWindowHandle2);

            // Comparar el conteo uno con el conteo dos
            actor.attemptsTo(CompararConteos.one());

            // Cambiar de ventana y validar la cantidad de productos - Gestión de Conteos
            UsObtenerVentanasNavegador obtenerVentanas = new UsObtenerVentanasNavegador(driver, 1);

            // Scroll para ver la diferencia en los conteos
            actor.attemptsTo(Wait.until(
                            WebElementQuestion.the(ObGestionarAuditoria.DiferenciaConteos),
                            WebElementStateMatchers.isVisible()
                    ).forNoLongerThan(10).seconds(),
                    Scroll.to(ObGestionarAuditoria.DiferenciaConteos));

            // Obtener la cantidad de la diferencia en conteos
            List<String> Auditoria = Collections.singletonList(ObGestionarAuditoria.DiferenciaConteos
                    .resolveFor(actor).getText());
            String CantConteo = Auditoria.get(0);
            System.out.println("Cantidad del Stock Obtenida es: " + Auditoria.size());
            System.out.println("Nombre de Orden Obtenida : " + Auditoria.get(0));

            if (Objects.equals(CantConteo, String.valueOf(0))) {
                System.out.println("Auditoria Exitosa");
            } else {
                System.out.println("Hay diferencia en el conteo la Auditoria se debe revisar");
            }

        } else {
            // El actor va a interactuar con el tipo de campo serial realizando de una vez la gestión
            System.out.println("Entro correctamente a la validación de campos seriales");
            actor.attemptsTo(IsTipoSeriales03.one());
        }

        // Cambiar de ventana y cerrar la ventana de comparación de conteos
        UsObtenerVentanasNavegador obtenerVentanas2 = new UsObtenerVentanasNavegador(getDriver(), 0);
        actor.attemptsTo(Wait.until(
                        WebElementQuestion.the(ObGestionarAuditoria.CerrarVentanaConteos),
                        WebElementStateMatchers.isEnabled()
                ).forNoLongerThan(10).seconds(),
                Click.on(ObGestionarAuditoria.CerrarVentanaConteos));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Cambiar Etapa de la Auditoria - Finalizado
        actor.attemptsTo(CambiarEtapaAuditoria.one());

        // Cerrar Ventana de la Auditoria
        actor.attemptsTo(CerrarVentanaAuditoria.one());

    }
}
