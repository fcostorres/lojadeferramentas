package lojadeferramentas;

/**
 *
 * @author TORRES
 *
 */
import java.util.List;
import model.bean.Customer;
import model.dao.CustomerDAO;
import view.customer.showCustomers;

public class LojaDeFerramentas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Iniciando o programa");
        
        new showCustomers().setVisible(true);
        
    }
}
