/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.stalupita.herramientas;

import java.sql.Connection;
import java.sql.DriverManager;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author adrianake
 */
public class ConexionBDSingleton {

    private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(ConexionBDSingleton.class.getName());
    private static ConexionBDSingleton instance = null;
    private Connection conexionBD = null;

    protected ConexionBDSingleton() {
        PropertyConfigurator.configure(this.getClass().getClassLoader().getResource("log4j.properties"));
    }

    public static ConexionBDSingleton getInstance() {
        if (instance == null) {
            instance = new ConexionBDSingleton();
            instance.establecerConexion();
        }
        return instance;
    }

    private void establecerConexion() {
        try {
            String sURL = "jdbc:mysql://localhost:3306/boletos";
            conexionBD = DriverManager.getConnection(sURL, "root", "4dm1n.p05");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error al tartar de establecer conexion con MYSQL", e);
        }
    }

    public void cerrarConexion() {
        try {
            if (conexionBD != null) {
                conexionBD.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error al tartar de cerrar conexion con MYSQL", e);
        }
    }

    public Connection getConexionBD() {
        try {
            if (conexionBD == null || conexionBD.isClosed()) {
                this.establecerConexion();
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error al tartar de validar exstencia de conexion con MYSQL", e);
        }
        return conexionBD;
    }

    public void setConexionBD(Connection conexionBD) {
        this.conexionBD = conexionBD;
    }

}
