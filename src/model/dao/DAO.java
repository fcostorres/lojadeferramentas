package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



/**
 *
 * @author TORRES
 */
public abstract class DAO<T> implements iDAO<T> {
    public static final String HOST_URI = "jdbc:mysql://localhost:3306/lojadeferramentas";
    public static final String USER = "lojadeferramentas";
    public static final String PASSWORD = "T6WAP62edyko74Va";
    public Connection conexao = null;
    
    public Connection conectar(){
    
         try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.printf(" Driver mysql carregado");
            conexao = DriverManager.getConnection(HOST_URI,USER,PASSWORD);
        } catch (Exception e) {
            System.out.printf(" erro ao carregar o Driver mysql: " + e.getMessage());
        } finally {

        }
        return conexao;
    }
    
    public PreparedStatement prepararInstrucao(String query,Connection Conexao)throws SQLException{
        
        return conexao.prepareStatement(query);
    }
    public void fecharconexao(){
        try{
            conexao.close();
            System.out.println("conexao fechada com sucesso");
        }catch(SQLException erro){
            System.err.println("A conexao nao pode ser fechada:" + erro.getMessage());
        }
    }
}
