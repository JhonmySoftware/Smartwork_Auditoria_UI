package co.com.infotrack.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ObLogin {

    public static final Target Usuario = Target.the("Input para ingresar el usuario")
            .located(By.xpath("(//input[@name='Login'])[1]"));

    public static final Target contrasenia = Target.the("Input para ingresar la contraseña")
            .located(By.xpath("(//input[@name='Contrasenia'])[1]"));

    public static final Target InisiarSession = Target.the("button para dar ingreso al sitio")
            .located(By.xpath("(//span[contains(text(),'Iniciar Sesión')])[1]"));
}
