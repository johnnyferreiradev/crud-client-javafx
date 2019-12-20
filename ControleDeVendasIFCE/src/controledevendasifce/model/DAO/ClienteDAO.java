
package controledevendasifce.model.DAO;

import controledevendasifce.model.domain.Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Johnny
 */
public class ClienteDAO {
    private List<Cliente> listClientes = new ArrayList<>();
    
    private static ClienteDAO clienteDAO = null;
    
    private ClienteDAO() {
    
    }
    
    public static ClienteDAO singleton(){
        if(clienteDAO == null) {
            clienteDAO = new ClienteDAO();
        }
        return clienteDAO;
    }
    
    public List<Cliente> loadClientes() {
        return this.listClientes;
    }
    
    public void insertClientes(Cliente c) {
        this.listClientes.add(c);
    }

}
