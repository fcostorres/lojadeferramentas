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

    private static final String HOST_URI = "jdbc:mysql://localhost:3306/lojadeferramentas";
    private static final String USER = "lojadeferramentas";
    private static final String PASSWORD = "T6WAP62edyko74Va";

    public enum TipoQuery {
        SALVAR, ALTERAR, EXCLUIR, BUSCAR, BUSCAR_TODOS, BUSCAR_POR;

    }

    public Connection conexao = null;

    public Connection conectar() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println(" Driver mysql carregado");
            conexao = DriverManager.getConnection(HOST_URI, USER, PASSWORD);
        } catch (Exception e) {
            System.out.println("Eerro ao carregar o Driver mysql: " + e.getMessage());
        } finally {

        }
        return conexao;
    }

    public PreparedStatement prepararInstrucao(String query, Connection Conexao) throws SQLException {

        return conexao.prepareStatement(query);
    }

    public void fecharconexao() {
        try {
            conexao.close();
            System.out.println("conexao fechada com sucesso");
        } catch (SQLException erro) {
            System.err.println("A conexao nao pode ser fechada:" + erro.getMessage());
        }
    }

    public String queryGenerator(TipoQuery tipo, String tabela, String[] colunas, String[] parametros) {
        String query = null;
        String[] valores = null;

        if (colunas != null) {

            for (int x = 0; x < colunas.length; x++) {
                valores[x] = "?";
            }
        }

        switch (tipo) {
            case SALVAR:
                query = "INSERT INTO " + tabela + "(" + colunas + ") VALUES (" + valores + ")";
                break;
            case ALTERAR:
                query = "UPDATE " + tabela + " SET (" + colunas + ") = " + valores + " WHERE " + this.idTabela() + " = ?";
                break;
            case EXCLUIR:
                query = "DELETE FROM " + tabela + " WHERE " + this.idTabela() + " = ?";
                break;
            case BUSCAR:
                query = "SELECT * FROM " + tabela + " WHERE " + this.idTabela() + " = ?";
                break;
            case BUSCAR_TODOS:
                query = "SELECT * FROM " + tabela + "";
                break;
            case BUSCAR_POR:
                query = "SELECT * FROM " + tabela + " WHERE " + parametros;
                break;
            default:
                query = null;
        }

        return query;
    }
}
