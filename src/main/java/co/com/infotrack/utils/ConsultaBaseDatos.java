package co.com.infotrack.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConsultaBaseDatos {
    private static final String DB_URL = "jdbc:sqlserver://35.170.118.110:1433;databaseName=SmartStockQA";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "Cal1dadSw*2019";

    public List<String> consultarBaseDatos() {
        List<String> listaItems = new ArrayList<>();
        // Conectar a la base de datos
        System.out.println("Método para consultar los datos de lista item");
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
            String query = "SELECT [DescripcionItem] FROM [dbo].[Item] " +
                    "WHERE Seriado = '0' " +
                    "AND Serialconsecutivo = '0' " +
                    "AND Lotes = '0' " +
                    "AND FIFO = '0' " +
                    "ORDER BY DescripcionItem ASC";
            resultSet = statement.executeQuery(query);

            // Iterar sobre los resultados
            while (resultSet.next()) {
                String descripcionItem = resultSet.getString("DescripcionItem");
                listaItems.add(descripcionItem);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos. " +
                            "Valide la conexión de la VPN.",
                    "Error de conexión", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Cerrar la conexión, el statement y el resultSet
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return listaItems;
    }
}
