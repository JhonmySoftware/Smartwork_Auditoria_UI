package co.com.infotrack.questions;

import co.com.infotrack.interations.Seriales.CompararConteos;
import co.com.infotrack.userinterfaces.ObGestionarAuditoria;
import co.com.infotrack.utils.UsObtenerVentanasNavegador;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.Wait;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class VrConteoSeriales02 implements Interaction {

    public static VrConteoSeriales02 one() {
        return Instrumented.instanceOf(VrConteoSeriales02.class).withProperties();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(CompararConteos.one());
        UsObtenerVentanasNavegador Windowss2 = new UsObtenerVentanasNavegador(getDriver(), 1);

        List<Target> ListaCantidad01 = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            ListaCantidad01.add(Target.the("Diferencia entre conteos - Tipo seriales " + i)
                    .locatedBy("//*[@id='root']//tbody/tr[" + i + "]/td[9]"));
        }

        List<String> textosObtenidos = new ArrayList<>();
        for (Target target : ListaCantidad01) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            String texto = Text.of(target).viewedBy(actor).asString();
            textosObtenidos.add(texto);
        }

        // Luego puedes realizar las validaciones necesarias con los textos obtenidos
        // por ejemplo, imprimirlos en la consola
        for (String texto : textosObtenidos) {
            System.out.println(texto);
            if (texto.equals("0")) {
                System.out.println("Caso de prueba Exitoso");
            } else {
                System.out.println("Caso de prueba No Exitoso");
            }
        }

        // Cerrar Ventana actual
        getDriver().close();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
