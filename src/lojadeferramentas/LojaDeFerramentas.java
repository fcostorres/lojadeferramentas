package lojadeferramentas;

/**
 *
 * @author TORRES
 *
 */
import model.dao.DAO;
import java.lang.*;
import java.util.*;

public class LojaDeFerramentas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("vamos testar o mysql");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.printf(" pronto o mysql carregou");
        } catch (Exception e) {
            System.out.printf(" não carregou: " + e.getMessage());
        } finally {

        }
    }
}
