import database.GestionDB;
import database.SchemeDB;
import org.json.JSONArray;
import org.json.JSONObject;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Entrada {
    public static void main(String[] args) {

        try {
            URL url = new URL("https://dummyjson.com/products");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            System.out.println(reader.readLine());
            StringBuffer stringBuffer = new StringBuffer();
            String linea = null;

            while ((linea = reader.readLine())!=null){
                stringBuffer.append(linea);
            }
            //STRING -> JSON
            JSONObject response = new JSONObject(stringBuffer.toString());
            JSONArray products = response.getJSONArray("products");
            for (int i = 0; i < products.length(); i++) {
                JSONObject producto = products.getJSONObject(i);
                String nombre = producto.getString("title");
                System.out.println(nombre);
            }

        } catch (IOException e) {
            System.out.println("Error en la conexión IO");
        }

        //conexion
        Connection connection = GestionDB.getConnection();
        try {
            Statement statement = connection.createStatement();
            int id_empleado = 2;
            String nombre_empleado = "Pablo";
            String apellidos_empleado = "Silva";
            String correo_empleado = "jpsilva@gmail.com";

            statement.execute(String.format("INSERT INTO %s (%s,%s,%s,%s) VALUE(%s,'%s','%s','%s')", SchemeDB.TAB_NAME_EMPLEADO,
                    SchemeDB.COL_ID_EMPLEADO,SchemeDB.COL_NAME_EMPLEADO,SchemeDB.COL_APELLIDOS_EMPLEADO,SchemeDB.COL_CORREO_EMPLEADO,
                    id_empleado,nombre_empleado,apellidos_empleado,correo_empleado));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            Statement statement = connection.createStatement();
            int id_pedido = 7;
            int id_producto = 65;
            String descripcion_pedido = "telefono";
            double precio_total = 59.99;

            statement.execute(String.format("INSERT INTO %s (%s,%s,%s,%s) VALUE(%s,'%s','%s','%s')", SchemeDB.TAB_NAME_PEDIDOS,
                    SchemeDB.COL_ID_PEDIDOS,SchemeDB.COL_ID_PRODUCTOS,SchemeDB.COL_DESCRIPCION_PEDIDOS,SchemeDB.COL_PRECIO_PEDIDOS,
                    id_pedido,id_producto,descripcion_pedido,precio_total));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
