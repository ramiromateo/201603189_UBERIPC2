package paquete;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Test {
    
    Connection conex;
    Statement stat;

    public Test() {
        conex=new Conexion().getDBConnection();
        if(conex==null){System.out.println("Estan nulo");}
        try {
            this.stat = conex.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void consulta(){
        try {
            ResultSet mire=stat.executeQuery("SELECT * FROM cliente");
            while(mire.next()){
                System.out.println(mire.getString("nombre"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void agragaruser(){
        try {        
            stat.executeUpdate("INSERT INTO cliente (id_Cliente, nombre, direccion_inicial, direccion_destino,tipo_cliente) VALUES (15, 'assdf', 'asdfdf', 'asasdfd','normal')");
        } catch (SQLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void buscarUsuario(){
        try {        
            stat.executeUpdate("SELECT * FROM cliente WHERE tipo_cliente='vip'");
        } catch (SQLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String [] args ){
        new Test().consulta();
        new Test().agragaruser();
        
    }
}
