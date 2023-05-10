package co.com.infotrack.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ObGestionarAuditoria extends PageObject {

    // Gestionar Auditoria - Localizadores - Conteo
    public static final Target Description = Target.the("Descripción del conteo")
            .located(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Descripción'])[1]/following::input[1]"));

    public static final Target Observation = Target.the("Observación del conteo")
            .located(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Observación'])[1]/following::input[1]"));

    public static final Target TipoConteo = Target.the("Tipo del conteo")
            .located(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Observación'])[2]/following::input[1]"));

    public static final Target ListTipoConteo = Target.the("List Tipo del conteo")
            .located(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Observación'])[2]/following::li[1]"));

    public static final Target ConteoPredecesor = Target.the("Conteo Predecesor -  conteo")
            .located(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Conteo predecesor'])[1]/following::input[1]"));

    public static final Target ListConteoPredecesor = Target.the("List Conteo Predecesor -  conteo")
            .located(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Conteo predecesor'])[1]/following::li[1]"));

    public static final Target Guardar2 = Target.the("Guardar -  conteo")
            .located(By.xpath("//span[contains(text(),'Guardar')]"));

    public static final Target CompararConteo = Target.the("Comparar Conteo -  conteo")
            .located(By.xpath("//tbody//td[3]//div[2]/button"));

    public static final Target ObtenerCantidadStock = Target.the("Obtener la cantidad del stock")
            .located(By.xpath("//td[4]"));

    public static final Target GestionarConteo = Target.the("Gestionar Conteo -  conteo")
            .located(By.xpath("//tbody//td[3]//div[1]/button"));

    public static final Target IngresarCatidadConteo = Target.the("Ingresar la cantidad del conteo que se obtuvo  Gestionar Conteo -  conteo")
            .located(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cantidad'])[1]/following::input[1]"));

    public static final Target SiguientePagina = Target.the("Siguiente pagina para ver los demas productos de la auditoria")
            .located(By.xpath("//span[contains(text(),'chevron_right')]"));

    public static final Target SiguientePaginaInactivo = Target.the("Siguiente pagina para ver los demas productos de la auditoria - Elemento Inactivo")
            .located(By.xpath("//span[@title='Página siguiente']//button[@disabled]"));



    // ************************************************* Lista Agregar Cantidades
    public static final Target AgregarCatidadConteo = Target.the("Agregar la cantidad del conteo que se obtuvo  Gestionar Conteo -  conteo")
            .located(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Agregar'])[2]/following::span[1]/.."));
    public static final Target AgregarCatidadConteo2 = Target.the("Agregar la cantidad del conteo que se obtuvo  Gestionar Conteo -  conteo")
            .located(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Agregar'])[3]/following::span[1]/.."));
    public static final Target AgregarCatidadConteo3 = Target.the("Agregar la cantidad del conteo que se obtuvo  Gestionar Conteo -  conteo")
            .located(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Agregar'])[4]/following::span[1]/.."));
    public static final Target AgregarCatidadConteo4 = Target.the("Agregar la cantidad del conteo que se obtuvo  Gestionar Conteo -  conteo")
            .located(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Agregar'])[5]/following::span[1]/.."));
    public static final Target AgregarCatidadConteo5 = Target.the("Agregar la cantidad del conteo que se obtuvo  Gestionar Conteo -  conteo")
            .located(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Agregar'])[6]/following::span[1]/.."));
    public static final Target AgregarCatidadConteo6 = Target.the("Agregar la cantidad del conteo que se obtuvo  Gestionar Conteo -  conteo")
            .located(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Agregar'])[7]/following::span[1]/.."));
    public static final Target AgregarCatidadConteo7 = Target.the("Agregar la cantidad del conteo que se obtuvo  Gestionar Conteo -  conteo")
            .located(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Agregar'])[8]/following::span[1]/.."));
    public static final Target AgregarCatidadConteo8 = Target.the("Agregar la cantidad del conteo que se obtuvo  Gestionar Conteo -  conteo")
            .located(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Agregar'])[9]/following::span[1]/.."));
    public static final Target AgregarCatidadConteo9 = Target.the("Agregar la cantidad del conteo que se obtuvo  Gestionar Conteo -  conteo")
            .located(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Agregar'])[10]/following::span[1]/.."));
    public static final Target AgregarCatidadConteo10 = Target.the("Agregar la cantidad del conteo que se obtuvo  Gestionar Conteo -  conteo")
            .located(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Agregar'])[11]/following::span[1]/.."));

    // **************************************************** Fin

    public static final Target ScrolTest = Target.the("Scroll para agregar cantidades tipo serial")
            .located(By.xpath("//input[@placeholder='Buscar']"));




    // Gestionar Segundo conteo

    public static final Target TextoAuditoria = Target.the("Gestionar Conteo -  conteo")
            .located(By.xpath("//table/tbody/tr[1]/td[1][@value='C Numero 2']"));
    public static final Target GestionarConteo2 = Target.the("Gestionar Conteo -  conteo")
            .located(By.xpath("//tbody/tr[2]/td[3]/div[1]/div[1]/button[1]/span[1]/*[1]"));

    // Comparar el conteo uno con el conteo dos
    public static final Target ConteoComparar = Target.the("Input Conteo a comparar")
            .located(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Conteo a comparar'])[1]/following::input[1]"));

    public static final Target ConteoCompararList = Target.the("Comparar conteos")
            .located(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Conteo a comparar'])[1]/following::li[1]"));

    public static final Target CompararConteosfin = Target.the("Agregar la cantidad del conteo que se obtuvo  Gestionar Conteo -  conteo")
            .located(By.xpath("//span[contains(text(),'Comparar conteos')]"));


    // Obtener la cantidad de diferencias en el conteo
    public static final Target DiferenciaConteos = Target.the("Obtener la cantidad de diferencia en el conteo")
            .located(By.xpath("//tbody//td[9]"));

    // Cerrar ventana de Comparar conteos
    public static final Target CerrarVentanaConteos = Target.the("Cerrar la venta de comparación de conteos")
            .located(By.xpath("(//button[@type='button'])[60]"));

    // Cambiar Etapa de la Auditoria - Finalizado
    public static final Target CambiarEtapa = Target.the("Cambiar Etapa de la Auditoria")
            .located(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cambiar Etapa'])[1]/following::input[1]/.."));

    public static final Target CambiarEtapaList = Target.the("Lista Cambiar Etapa de la Auditoria")
            .located(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cambiar Etapa'])[1]/following::li[1]/.."));

    public static final Target ContinuarCEtapa = Target.the("Continuar con el cambio de Etapa")
            .located(By.xpath("(//span[contains(text(),'Continuar')])[1]"));

    public static final Target ConteoFinalizar = Target.the("Conteo a finalizar")
            .located(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Conteo a finalizar'])[1]/following::input[1]"));

    public static final Target ConteoFinalizarList = Target.the("Lista Conteo a finalizar")
            .located(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Conteo a finalizar'])[1]/following::li[1]"));

    public static final Target FinalizarAuditoria = Target.the("Finalizar Auditoria")
            .located(By.xpath("(//span[contains(text(),'Finalizar')])[1]"));

    // Cerrar Ventana y verificar el estado de la Auditoria - Finalizado

    public static final Target CrVentanaAuditoria = Target.the("Cerrar la ventana de la auditoria")
            .located(By
                    .xpath("//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorInherit']"));

    // Estado Auditoria
    public static final Target VrEstadoAuditoria = Target.the("Verificar el estado de la Auditoria")
            .located(By.xpath("//td[@value='Finalizado']"));










}
