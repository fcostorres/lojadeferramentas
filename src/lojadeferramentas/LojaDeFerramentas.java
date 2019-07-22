package lojadeferramentas;

/**
 *
 * @author TORRES
 *
 */
import java.util.List;
import model.bean.Customer;
import model.dao.CustomerDAO;

public class LojaDeFerramentas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("vamos testar o mysql");

        try {

            CustomerDAO clienteDAO = new CustomerDAO();
            List<Customer> listaDeClientes = clienteDAO.buscar();
            
            for(Customer cliente : listaDeClientes){
                System.out.println("_________");
                System.out.println(cliente.getCustomerId());
                System.out.println(cliente.getCustomerName());
                System.out.println(cliente.getPhoneNumber());
                System.out.println(cliente.getAddress());
            }
            
        } catch (Exception e) {
            System.out.printf(" não carregou: " + e.getMessage());
        } finally {

        }
    }
}
