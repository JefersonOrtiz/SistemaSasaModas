/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jeferson
 */
public class ConexaoMySql {
    
    private boolean status = false;
    private String mensagem = "";   // Variável que vai informar o status da conexão
    private Connection con = null;  // Variável para conexão
    private Statement stm;
    private ResultSet rs;
    
    private String servidor = "localhost";
    private String nomeBanco = "dbsistemasasa";
    private String usuario = "root";
    private String senha = "";
    
    public ConexaoMySql(){}
    
    public ConexaoMySql(String pServidor, String pNomeBanco, String pUsuario, String pSenha){
        
        this.servidor = pServidor;
        this.nomeBanco = pNomeBanco;
        this.usuario = pUsuario;
        this.senha = pSenha;
    }
    
    // Abre uma conexão com o banco
    // @return Connection
    
    public Connection conectar(){
        
        
        try {
            // Driver do MySQL
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            
            // local do banco, nome do banco, usuário e senha
            String url = "jdbc:mysql://" + servidor + "/" + nomeBanco;
            this.setCon((Connection) DriverManager.getConnection(url, usuario, senha));
            
            // Se correr tudo bem, a linha abaixo é executada
            this.status = true;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return this.getCon();
    }
    
    /**
     * Realiza consultas no SQL
     * @param pSQL
     * @return int
     */
    public boolean executarSQL(String pSQL){
        
        try {
            // CreateStatement de con para criar o Statement
            this.setStatement(getCon().createStatement());
            
            // Defininndo o Statement, executamos a query no banco de dados
            this.setResultSet(getStatement().executeQuery(pSQL));
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean executarUpdateDeleteSQL(String pSQL){
        
        try {
            // createStatement de con para criar o Statement
            this.setStatement(getCon().createStatement());
            
            // Definimos o Statement, executamos a Query no banco de dados
            getStatement().executeUpdate(pSQL);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    private void setCon(Connection connection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Connection getCon() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void setStatement(Statement createStatement) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Object getStatement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
