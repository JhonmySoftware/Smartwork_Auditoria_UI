package co.com.infotrack.questions;

import co.com.infotrack.userinterfaces.ObGestionarAuditoria;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class VrEstadoAuditoria implements Question {


    public static VrEstadoAuditoria one() {
        return new VrEstadoAuditoria();
    }

    @Override
    public Object answeredBy(Actor actor) {
        return Text.of(ObGestionarAuditoria.VrEstadoAuditoria).viewedBy(actor).asString();
    }
}
