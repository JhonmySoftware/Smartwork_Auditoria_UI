package co.com.infotrack.definitions;

import co.com.infotrack.questions.VrEstadoAuditoria;
import co.com.infotrack.taks.AbrirPaginas.TsAbrirPagina;
import co.com.infotrack.taks.ProcesoAuditoria.TsProcesoAuditoria;
import cucumber.api.java.Before;
import cucumber.api.java.ast.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;

public class MyDefinitions {

    @Before
    public void IniciarEscenario() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("^que existe una una solicitud de auditoria$")
    public void queExisteUnaUnaSolicitudDeAuditoria() {
        OnStage.theActorCalled("Usuario").wasAbleTo(TsAbrirPagina.Smartstock());
    }


    @Cuando("^Crea la orden de de auditoria$")
    public void creaLaOrdenDeDeAuditoria() {
        OnStage.theActorCalled("Usuario").wasAbleTo(TsProcesoAuditoria.one());

    }

    @Entonces("^verifica que se cumplio la orden de auditoria correctamente$")
    public void verificaQueSeCumplioLaOrdenDeAuditoriaCorrectamente() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(VrEstadoAuditoria.one(), Matchers.equalTo("Finalizado")));

    }

}
