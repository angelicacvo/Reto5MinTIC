
package Controlador;

import Modelo.Conexion;
import Modelo.Sucursal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class CbSucursal {
    Conexion conexion = new Conexion();
    Connection connection;
    Statement st;
    ResultSet rs;

    public CbSucursal() {
    }
    
    public ArrayList getListaSucursales(){
        System.out.println("Funcion getListaSucursales ");
        ArrayList mListaSucursales= new ArrayList();
        Sucursal sucurlas= null;
        try {
            connection = conexion.getConnection();
            st = connection.createStatement();
            rs = st.executeQuery("SELECT idSucursal, nombreSucursal FROM `sucursal`;");
            while (rs.next()) {
                sucurlas = new Sucursal();
                sucurlas.setIdSucursal(rs.getInt("idSucursal"));
                sucurlas.setNombreSucursal(rs.getString("nombreSucursal"));
                mListaSucursales.add(sucurlas);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return mListaSucursales;
    }
}
