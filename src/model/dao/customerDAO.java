package model.dao;

import java.util.List;
import model.bean.Customer;

/**
 *
 * @author TORRES
 */
public class customerDAO extends DAO<Customer> {

    @Override
    public Customer salvar(Customer cliente) {
        return cliente;
    }

    @Override
    public Customer alterar(Customer cliente) {
        return cliente;
    }
    
    @Override
    public void excluir(String id){
        
    }
    
    @Override
    public List<Customer> buscar(){
        return;
    }

    public List<Customer> buscar(String id){
        
    }

    public List<Customer> buscar(String[] params){
        
    }
}
