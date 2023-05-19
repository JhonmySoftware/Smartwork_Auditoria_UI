package co.com.infotrack.taks.AbrirPaginas;

import co.com.infotrack.userinterfaces.AbrirPaginas.ObAbrirPagina;
import co.com.infotrack.userinterfaces.Login.ObLogin;
import co.com.infotrack.utils.UsCargarArchivos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;

import java.io.IOException;

public class TsAbrirPagina implements Task {
    private ObAbrirPagina obAbrirPagina;

    public static TsAbrirPagina Smartstock() {
        return Tasks.instrumented(TsAbrirPagina.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            UsCargarArchivos.datoslogin();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Abrir el sitio
        actor.attemptsTo(Open.browserOn(obAbrirPagina));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // Login
        actor.attemptsTo(
                Enter.theValue(UsCargarArchivos.properties.getProperty("Username")).into(ObLogin.Usuario),
                Enter.theValue(UsCargarArchivos.properties.getProperty("Password")).into(ObLogin.contrasenia),
                Click.on(ObLogin.InisiarSession)
        );
    }
}
