package co.com.infotrack.questions;

import co.com.infotrack.userinterfaces.ObGestionarAuditoria;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class VrDiferenciaConteos implements Question {


    public static VrDiferenciaConteos one() {
        return new VrDiferenciaConteos();
    }

    @Override
    public Object answeredBy(Actor actor) {
        return Text.of(ObGestionarAuditoria.DiferenciaConteos).viewedBy(actor).asString();
    }
}
