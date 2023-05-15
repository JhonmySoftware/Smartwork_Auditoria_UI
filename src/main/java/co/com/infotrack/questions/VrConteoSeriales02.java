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

        int contador3 = 0;
        List<String> valoresCantidad01 = new ArrayList<>();
        while (!ListaCantidad01.isEmpty()) {
            for (Iterator<Target> iterator = ListaCantidad01.iterator(); iterator.hasNext(); ) {
                Target elemento = iterator.next();
                actor.attemptsTo(Wait.until(
                        WebElementQuestion.the(elemento),
                        WebElementStateMatchers.isEnabled()
                ).forNoLongerThan(1).seconds());
                String valor = Text.of(elemento).viewedBy(actor).asString();
                valoresCantidad01.add(valor);
                System.out.println("Total de productos evaluados : " + valoresCantidad01.size());
                contador3++;
                if (ObGestionarAuditoria.SiguientePaginaInactivo.resolveFor(actor).isPresent()) {
                    System.out.println("Se detuvo en la siguiente página");
                    return;
                }
                if (contador3 % 10 == 0 && ObGestionarAuditoria.SiguientePagina.resolveFor(actor).isEnabled()) {
                    try {
                        actor.attemptsTo(
                                Wait.until(
                                        WebElementQuestion.the(ObGestionarAuditoria.SiguientePagina),
                                        WebElementStateMatchers.isClickable()
                                ).forNoLongerThan(5).seconds(),
                                Scroll.to(ObGestionarAuditoria.SiguientePagina),
                                Click.on(ObGestionarAuditoria.SiguientePagina)
                        );
                        ListaCantidad01 = new ArrayList<>();
                        for (int i = 1; i <= 10; i++) {
                            ListaCantidad01.add(Target.the("Diferencia entre conteos - Tipo seriales " + i)
                                    .locatedBy("//*[@id='root']//tbody/tr[" + i + "]/td[9]"));
                        }
                    } catch (ElementClickInterceptedException e) {
                        System.out.println("El botón Siguiente página está bloqueado");
                        return;
                    }
                }else {
                    break;
                }
                iterator.remove();
            }
        }

        boolean todosCeros = true;
        for (String valor : valoresCantidad01) {
            if (!valor.equals("0")) {
                todosCeros = false;
                break;
            }
        }

        if (todosCeros) {
            System.out.println("Se cumple el caso de prueba");
        } else {
            System.out.println("No se cumple el caso de prueba");
        }
    }
}
