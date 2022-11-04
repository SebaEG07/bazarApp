package com.bazarapi.bazarapplication.service;

import com.bazarapi.bazarapplication.model.Cliente;
import java.util.List;


public interface IClienteService {

    //Crear cliente
    public void saveCliente(Cliente clien);
    
    //Obtener lista de clientes
    public List<Cliente> getCientes();
    
    //Obtener cliente en particular
    public Cliente findCliente(Long id);
    
    //Eliminar cliente
    public void deleteCLiente(Long id);
    
    //Editar cliente
    public void editCliente(Long idOriginal, Long idNueva,
                            String nuevoNombre,
                            String nuevoApellido,
                            String nuevoDni);

    public void editCliente(Cliente clien);
    
}