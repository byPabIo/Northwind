package database;

public interface SchemeDB {

    String HOST = "127.0.0.1:3306";
    String DB_NAME = "almacen";
    String TAB_NAME_PRODUCTOS = "productos";
    String COL_ID_PRODUCTOS = "id";
    String COL_NAME_PRODUCTOS = "nombre";
    String COL_DESCRIPCION_PRODUCTOS = "descripcion";
    String COL_CANTIDAD_PRODUCTOS = "cantidad";
    String COL_PRECIO_PRODUCTOS = "precio";

    String TAB_NAME_EMPLEADO = "empleados";
    String COL_ID_EMPLEADO = "id";
    String COL_NAME_EMPLEADO = "nombre";
    String COL_APELLIDOS_EMPLEADO = "apellidos";
    String COL_CORREO_EMPLEADO = "correo";

    String TAB_NAME_PEDIDOS = "pedidos";
    String COL_ID_PEDIDOS = "id";
    String COL_DESCRIPCION_PEDIDOS = "descripcion";
    String COL_PRECIO_PEDIDOS = "precio_total";
}