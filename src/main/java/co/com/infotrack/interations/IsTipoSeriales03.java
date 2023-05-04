package co.com.infotrack.interations;

import co.com.infotrack.userinterfaces.ObGestionarAuditoria;
import co.com.infotrack.utils.UsCargarArchivos;
import co.com.infotrack.utils.UsObtenerVentanasNavegador;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.Wait;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        String[] listadoItems1 = {"SERIAL"};
        if (Arrays.asList(listadoItems1).contains(UsCargarArchivos.properties.getProperty("Item"))) {
            // Hacer clic en el botón Gestionar Conteo
            actor.attemptsTo(Click.on(ObGestionarAuditoria.GestionarConteo));
            UsObtenerVentanasNavegador Ventana2 = new UsObtenerVentanasNavegador(getDriver(),1);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            List<Target> ListaCantidad1 = new ArrayList<>();
            for (int i = 1; i <= 10; i++) {
                ListaCantidad1.add(Target.the("Campos de cantidad a gestionar en la auditoria" + i)
                        .locatedBy("(.//*[normalize-space(text()) and normalize-space(.)='Cantidad'])[1]/following::input[" + i + "]"));
            }

            List<Target> ListaCantidad2 = new ArrayList<>();
            for (int i = 1; i <= 10; i++) {
                ListaCantidad2.add(Target.the("Campos de cantidad a gestionar en la auditoria" + i)
                        .locatedBy("(.//*[normalize-space(text()) and normalize-space(.)='Cantidad'])[1]/following::input[" + i + "]"));
            }

            List<Target> ListaCantidad3 = new ArrayList<>();
            for (int i = 1; i <= 10; i++) {
                ListaCantidad3.add(Target.the("Campos de cantidad a gestionar en la auditoria" + i)
                        .locatedBy("(.//*[normalize-space(text()) and normalize-space(.)='Cantidad'])[1]/following::input[" + i + "]"));
            }

            List<Target> ListaCantidad4 = new ArrayList<>();
            for (int i = 1; i <= 10; i++) {
                ListaCantidad4.add(Target.the("Campos de cantidad a gestionar en la auditoria" + i)
                        .locatedBy("(.//*[normalize-space(text()) and normalize-space(.)='Cantidad'])[1]/following::input[" + i + "]"));
            }

            List<Target> ListaCantidad5 = new ArrayList<>();
            for (int i = 1; i <= 10; i++) {
                ListaCantidad5.add(Target.the("Campos de cantidad a gestionar en la auditoria" + i)
                        .locatedBy("(.//*[normalize-space(text()) and normalize-space(.)='Cantidad'])[1]/following::input[" + i + "]"));
            }

            List<Target> ListaCantidad6 = new ArrayList<>();
            for (int i = 1; i <= 10; i++) {
                ListaCantidad6.add(Target.the("Campos de cantidad a gestionar en la auditoria" + i)
                        .locatedBy("(.//*[normalize-space(text()) and normalize-space(.)='Cantidad'])[1]/following::input[" + i + "]"));
            }

            int contador = 0;
            for (Target LC : ListaCantidad1) {
                if (LC.resolveFor(actor).isVisible()) {
                    actor.attemptsTo(
                            Wait.until(
                                    WebElementQuestion.the(LC),
                                    WebElementStateMatchers.isVisible()
                            ).forNoLongerThan(2).seconds(),
                            Enter.theValue("1").into(LC),
                            Scroll.to(LC)
                    );
                    contador++;

                    if (contador % 10 == 0) {
                        // Hacer clic en el botón de cambiar de ventana
                        // Código para hacer clic en el botón de cambiar de ventana
                        actor.attemptsTo(Click.on(ObGestionarAuditoria.SiguientePagina));
                        if (ObGestionarAuditoria.SiguientePagina.resolveFor(actor).isDisabled()){
                            break;
                        }
                    }
                }
            }

            int contador2 = 0;
            for (Target LC : ListaCantidad2) {
                if (LC.resolveFor(actor).isVisible()) {
                    actor.attemptsTo(
                            Wait.until(
                                    WebElementQuestion.the(LC),
                                    WebElementStateMatchers.isVisible()
                            ).forNoLongerThan(2).seconds(),
                            Enter.theValue("1").into(LC),
                            Scroll.to(LC)
                    );
                    contador2++;

                    if (contador2 % 10 == 0) {
                        // Hacer clic en el botón de cambiar de ventana
                        // Código para hacer clic en el botón de cambiar de ventana
                        actor.attemptsTo(Click.on(ObGestionarAuditoria.SiguientePagina));
                        if (ObGestionarAuditoria.SiguientePagina.resolveFor(actor).isDisabled()){
                            break;
                        }
                    }
                }
            }

            int contador3 = 0;
            for (Target LC : ListaCantidad3) {
                if (LC.resolveFor(actor).isVisible()) {
                    actor.attemptsTo(
                            Wait.until(
                                    WebElementQuestion.the(LC),
                                    WebElementStateMatchers.isVisible()
                            ).forNoLongerThan(2).seconds(),
                            Enter.theValue("1").into(LC),
                            Scroll.to(LC)
                    );
                    contador3++;

                    if (contador3 % 10 == 0) {
                        // Hacer clic en el botón de cambiar de ventana
                        // Código para hacer clic en el botón de cambiar de ventana
                        actor.attemptsTo(Click.on(ObGestionarAuditoria.SiguientePagina));
                        if (ObGestionarAuditoria.SiguientePagina.resolveFor(actor).isDisabled()){
                            break;
                        }
                    }
                }
            }

            int contador4 = 0;
            for (Target LC : ListaCantidad4) {
                if (LC.resolveFor(actor).isVisible()) {
                    actor.attemptsTo(
                            Wait.until(
                                    WebElementQuestion.the(LC),
                                    WebElementStateMatchers.isVisible()
                            ).forNoLongerThan(2).seconds(),
                            Enter.theValue("1").into(LC),
                            Scroll.to(LC)
                    );
                    contador4++;

                    if (contador4 % 10 == 0) {
                        // Hacer clic en el botón de cambiar de ventana
                        // Código para hacer clic en el botón de cambiar de ventana
                        actor.attemptsTo(Click.on(ObGestionarAuditoria.SiguientePagina));
                        if (ObGestionarAuditoria.SiguientePagina.resolveFor(actor).isDisabled()){
                            break;
                        }
                    }
                }
            }






        }


    }
}
