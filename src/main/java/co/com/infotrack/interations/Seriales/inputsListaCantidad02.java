package co.com.infotrack.interations.Seriales;

import co.com.infotrack.questions.VrConteoSeriales02;
import co.com.infotrack.userinterfaces.ObGestionarAuditoria;
import co.com.infotrack.utils.UsCargarArchivos;
import co.com.infotrack.utils.UsObtenerVentanasNavegador;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.Wait;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;

import java.util.*;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class inputsListaCantidad02 implements Interaction {

    public static inputsListaCantidad02 one() {
        return Instrumented.instanceOf(inputsListaCantidad02.class).withProperties();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        // Hacer clic en el botón Gestionar Conteo
        actor.attemptsTo(Click.on(ObGestionarAuditoria.GestionarConteo));
        UsObtenerVentanasNavegador Ventana2 = new UsObtenerVentanasNavegador(getDriver(), 1);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        List<Target> ListaCantidad1 = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            ListaCantidad1.add(Target.the("Campos de cantidad a gestionar en la auditoria" + i)
                    .locatedBy("(.//*[normalize-space(text()) and normalize-space(.)='Cantidad'])[1]/following::input[" + i + "]"));
        }

        int contador = 0;
        while (true) {
            try {

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
                    }
                }
                if (contador % 10 == 0) {
                    actor.attemptsTo(
                            Scroll.to(ObGestionarAuditoria.AgregarCatidadConteo),
                            MoveMouse.to(ObGestionarAuditoria.ScrolTest),
                            BtnAgregarList.one()
                    );
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    if (ObGestionarAuditoria.SiguientePaginaInactivo.resolveFor(actor).isPresent()) {
                        System.out.println("Duerme");
                        break;
                    } else {
                        try {
                            actor.attemptsTo(
                                    Wait.until(
                                            WebElementQuestion.the(ObGestionarAuditoria.SiguientePagina),
                                            WebElementStateMatchers.isClickable()
                                    ).forNoLongerThan(5).seconds(),
                                    Scroll.to(ObGestionarAuditoria.SiguientePagina),
                                    Click.on(ObGestionarAuditoria.SiguientePagina)
                            );
                        } catch (ElementClickInterceptedException e) {
                            break; // Detener el ciclo si el botón está bloqueado
                        }
                    }


                }
            } catch (NoSuchElementException e) {
                break; // Detener el ciclo si no se encuentra el elemento
            } catch (Exception e) {
                // Manejar otros tipos de excepciones si es necesario
            }
        }
        getDriver().close();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        // Una vez se finalice el conteo de la auditoria se debe ir a la primera ventana y realizar el segundo conteo
        UsObtenerVentanasNavegador ventana1 = new UsObtenerVentanasNavegador(getDriver(),0);

        // Conteo Numero 2 - Auditoria
        actor.attemptsTo(Wait.until(
                        WebElementQuestion.the(ObGestionarAuditoria.Description),
                        WebElementStateMatchers.isVisible()
                ).forNoLongerThan(10).seconds(),
                Enter.theValue(("C")+(" Numero 2"))
                        .into(ObGestionarAuditoria.Description),
                Enter.theValue(UsCargarArchivos.properties.getProperty("Observation")+("2"))
                        .into(ObGestionarAuditoria.Observation),
                Enter.theValue(UsCargarArchivos.properties.getProperty("TipoConteo"))
                        .into(ObGestionarAuditoria.TipoConteo),
                Click.on(ObGestionarAuditoria.ListTipoConteo),
                Click.on(ObGestionarAuditoria.Guardar2)
        );

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Obligo a seleccionar el segundo conteo.
        try {
            if (ObGestionarAuditoria.TextoAuditoria.resolveFor(actor).isVisible()) {
                actor.attemptsTo(Click.on(ObGestionarAuditoria.GestionarConteo));
            } else {
                actor.attemptsTo(Click.on(ObGestionarAuditoria.GestionarConteo2));
            }
        } catch (ElementNotVisibleException | ElementClickInterceptedException e) {
        }



        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        UsObtenerVentanasNavegador Windows2 = new UsObtenerVentanasNavegador(getDriver(),1);

        int contador2 = 0;
        while (true) {
            try {

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
                        contador2++;
                    }
                }
                if (contador2 % 10 == 0) {
                    actor.attemptsTo(
                            Scroll.to(ObGestionarAuditoria.AgregarCatidadConteo),
                            MoveMouse.to(ObGestionarAuditoria.ScrolTest),
                            BtnAgregarList.one()
                    );
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    if (ObGestionarAuditoria.SiguientePaginaInactivo.resolveFor(actor).isDisabled()) {
                        System.out.println("Duerme");
                        break;
                    } else {
                        try {
                            actor.attemptsTo(
                                    Wait.until(
                                            WebElementQuestion.the(ObGestionarAuditoria.SiguientePagina),
                                            WebElementStateMatchers.isVisible()
                                    ).forNoLongerThan(5).seconds(),
                                    Scroll.to(ObGestionarAuditoria.SiguientePagina),
                                    Click.on(ObGestionarAuditoria.SiguientePagina)
                            );
                        } catch (ElementClickInterceptedException e) {
                            break; // Detener el ciclo si el botón está bloqueado
                        }
                    }


                }
            } catch (NoSuchElementException e) {
                break; // Detener el ciclo si no se encuentra el elemento
            } catch (Exception e) {
                // Manejar otros tipos de excepciones si es necesario
            }
        }

        // Cerrar la ventana actual
        getDriver().close();

        // Tiempo de espera
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Obtener la ventana 1
        UsObtenerVentanasNavegador ventana01 = new UsObtenerVentanasNavegador(getDriver(), 0);

        // Comparar el conteo __ Tipos de productos seriales 01 02
        actor.attemptsTo(VrConteoSeriales02.one());

        // Tiempo de espera
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Cerrar la ventana del navegador
        getDriver().close();


    }
}
