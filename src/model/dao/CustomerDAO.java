package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.Customer;

/**
 *
 * @author TORRES
 */
public class CustomerDAO extends DAO<Customer> {

    @Override
    public String idTabela() {
        return Customer.nomeIdTabela;
    }

    @Override
    public Customer salvar(Customer cliente) {
        return cliente;
    }

    @Override
    public Customer alterar(Customer cliente) {
        return cliente;
    }

    @Override
    public void excluir(String id) {

    }

    @Override
    public List<Customer> buscar() {
        List<Customer> listaDeClientes = new ArrayList<>();

        this.conectar();

        String q = this.queryGenerator(DAO.TipoQuery.BUSCAR_TODOS, Customer.tabela, null, null);
        PreparedStatement transacao;
        try {
            transacao = this.prepararInstrucao(q, this.conexao);
            ResultSet resultado = transacao.executeQuery();
            
            while(resultado.next()){
                Customer c = new Customer( resultado.getString("customerId") );
                c.setCustomerName( resultado.getString("customerName") );
                c.setPhoneNumber( resultado.getString("phoneNumber") );
                c.setAddress( resultado.getString("address") );
                
                listaDeClientes.add(c);
            }
            
            transacao.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.fecharconexao();
        
        return listaDeClientes;
    }

    public List<Customer> buscar(String id) {
        List<Customer> x = new ArrayList<>();
        return x;
    }

    public List<Customer> buscar(String[] params) {
        List<Customer> x = new ArrayList<>();
        return x;
    }
}
