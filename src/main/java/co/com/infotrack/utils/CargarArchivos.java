package co.com.infotrack.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class CargarArchivos {

    public static Properties properties;

    public static void datoslogin() throws IOException {
        properties = new Properties();
        properties.load(new FileReader("Login.properties"));
    }

    public static void CrearAuditoria() throws IOException {
        properties = new Properties();
        properties.load(new FileReader("CrearAuditoria.properties"));
    }


}
