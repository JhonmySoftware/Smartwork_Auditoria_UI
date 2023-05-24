package co.com.infotrack.userinterfaces.test;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ObObtenercantidadproductos extends PageObject {

    public static final Target ObtenerCantidad1 = Target.the("Obtener cantidad de productos 1")
            .located(By.cssSelector("tbody tr:nth-of-type(1) td:nth-of-type(4)"));

    public static final Target ObtenerCantidad2 = Target.the("Obtener cantidad de productos 2")
            .located(By.cssSelector("tbody tr:nth-of-type(2) td:nth-of-type(4)"));

    public static final Target ObtenerCantidad3 = Target.the("Obtener cantidad de productos 3")
            .located(By.cssSelector("tbody tr:nth-of-type(3) td:nth-of-type(4)"));

    public static final Target ObtenerCantidad4 = Target.the("Obtener cantidad de productos 4")
            .located(By.cssSelector("tbody tr:nth-of-type(4) td:nth-of-type(4)"));

    public static final Target ObtenerCantidad5 = Target.the("Obtener cantidad de productos 5")
            .located(By.cssSelector("tbody tr:nth-of-type(5) td:nth-of-type(4)"));

    public static final Target ObtenerCantidad6 = Target.the("Obtener cantidad de productos 6")
            .located(By.cssSelector("tbody tr:nth-of-type(6) td:nth-of-type(4)"));

    public static final Target ObtenerCantidad7 = Target.the("Obtener cantidad de productos 7")
            .located(By.cssSelector("tbody tr:nth-of-type(7) td:nth-of-type(4)"));

    public static final Target ObtenerCantidad8 = Target.the("Obtener cantidad de productos 8")
            .located(By.cssSelector("tbody tr:nth-of-type(8) td:nth-of-type(4)"));

    public static final Target ObtenerCantidad9 = Target.the("Obtener cantidad de productos 9")
            .located(By.cssSelector("tbody tr:nth-of-type(9) td:nth-of-type(4)"));

    public static final Target ObtenerCantidad10 = Target.the("Obtener cantidad de productos 10")
            .located(By.cssSelector("tbody tr:nth-of-type(10) td:nth-of-type(4)"));


}
