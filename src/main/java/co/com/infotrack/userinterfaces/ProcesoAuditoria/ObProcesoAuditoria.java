package co.com.infotrack.userinterfaces.ProcesoAuditoria;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ObProcesoAuditoria extends PageObject {

    public static final Target Inventario = Target.the("Botón de Proceso de Inventario").
            located(By.xpath("//span[contains(text(),'Inventario')]"));

    public static final Target Auditoria = Target.the("Botón de Auditoria").
            located(By.xpath("//h6[normalize-space()='Auditoría']"));

    public static final Target AddAuditoria = Target.the("Botón de + para agregar auditoria").
            located(By.xpath("//span[contains(text(),'add')]/../.."));


    // Primera ventana para Crear Auditoría
    public static final Target Bodega = Target.the("input Seleccionar la bodega").
            located(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Bodega'])[1]/following::input[2]"));
    public static final Target ListBodega = Target.the("Lista Seleccionar la bodega").
            located(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Bodega'])[1]/following::li[1]"));
    public static final Target TipoDocumento = Target.the("Input de Tipo de documento").
            located(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Tipo Documento'])[1]/following::input[1]"));

    public static final Target ListTipoDocumento = Target.the("input Lista Botón de Tipo de documento").
            located(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Tipo Documento'])[1]/following::li[1]"));

    public static final Target Division = Target.the("Input División").
            located(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='División'])[2]/following::input[1]"));
    public static final Target ListDivision = Target.the("Lista Input División").
            located(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='División'])[2]/following::li[1]"));

    public static final Target Familia = Target.the("input Familia").
            located(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Familia'])[2]/following::input[1]"));

    public static final Target ListaFamilia = Target.the("Lista Input Familia").
            located(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Familia'])[2]/following::li[1]"));

    public static final Target Item = Target.the("ítem").
            located(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Familia'])[3]/following::input[1]"));

    public static final Target ListItem = Target.the("Lista ítem").
            located(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Familia'])[3]/following::li[1]"));

    public static final Target Guardar = Target.the("Guardar Auditoria 1").
            located(By.xpath("//span[contains(text(),'Guardar')]"));

    //
}
