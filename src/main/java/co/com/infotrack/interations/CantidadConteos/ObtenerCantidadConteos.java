package co.com.infotrack.interations.CantidadConteos;

import co.com.infotrack.userinterfaces.ProcesoAuditoria.ObGestionarAuditoria;
import co.com.infotrack.utils.UsObtenerVentanasNavegador;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.Wait;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class ObtenerCantidadConteos implements Interaction {

    public static ObtenerCantidadConteos one() {
        return Instrumented.instanceOf(ObtenerCantidadConteos.class).withProperties();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Obtener la cantidad de conteos
        actor.attemptsTo(Click.on(ObGestionarAuditoria.CompararConteo));

        // Ir a la segunda ventana
        UsObtenerVentanasNavegador Windows2 = new UsObtenerVentanasNavegador(getDriver(),1);

        List<Target> obtenerCantidadesProductos = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int rowIndex = i + 1;
            obtenerCantidadesProductos.add(Target.the("Obtener la cantidad del producto en la lista: " + rowIndex)
                    .locatedBy("tbody tr:nth-of-type(" + rowIndex + ") td:nth-of-type(4)"));
        }

// Itera sobre los Targets y obtén los valores
        for (Target target : obtenerCantidadesProductos) {
            actor.attemptsTo(
                    Wait.until(WebElementQuestion.the(target), WebElementStateMatchers.isVisible())
                            .forNoLongerThan(2).seconds()
            );
            String valor = target.resolveFor(actor).getText();
            System.out.println("Valor: " + valor);
        }


    }
}
