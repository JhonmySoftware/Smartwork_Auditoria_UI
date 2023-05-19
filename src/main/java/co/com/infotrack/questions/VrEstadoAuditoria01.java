package co.com.infotrack.questions;

import co.com.infotrack.userinterfaces.ProcesoAuditoria.ObGestionarAuditoria;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class VrEstadoAuditoria01 implements Question {


    public static VrEstadoAuditoria01 one() {
        return new VrEstadoAuditoria01();
    }

    @Override
    public Object answeredBy(Actor actor) {
        return Text.of(ObGestionarAuditoria.VrEstadoAuditoria).viewedBy(actor).asString();
    }
}
