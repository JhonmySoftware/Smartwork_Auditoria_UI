package co.com.infotrack.utils;

import net.serenitybdd.screenplay.Performable;
import org.openqa.selenium.WebDriver;

import java.util.Set;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class ObtenerVentanasNavegador {

    private WebDriver driver;
    public ObtenerVentanasNavegador(WebDriver driver, int i) {
        this.driver = driver;
        // Obtener la lista de ventanas disponibles
        Set<String> windowHandles = driver.getWindowHandles();
        // Obtener el identificador de la ventana especificada por el índice
        String windowHandle = (String) windowHandles.toArray()[i];
        // Cambiar el foco del controlador del navegador a la ventana especificada por el índice
        driver.switchTo().window(windowHandle);
    }
}

