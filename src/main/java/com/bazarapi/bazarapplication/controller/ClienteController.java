package com.bazarapi.bazarapplication.controller;

import com.bazarapi.bazarapplication.model.Cliente;
import com.bazarapi.bazarapplication.service.IClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
    
    @Autowired
    private IClienteService clienServ;
    
    @PostMapping ("/clientes/crear")
    public String saveCliente(@RequestBody Cliente cli){
        clienServ.saveCliente(cli);
        return "Cliente creado correctamente";
    }
    
    @GetMapping ("/clientes")
    public List<Cliente> getClientes(){
        return clienServ.getCientes();
    }
    
    @GetMapping ("/clientes/{id_cliente}")
    public Cliente findCliente(@PathVariable long id_cliente){
        return clienServ.findCliente(id_cliente);
    }
    
    @DeleteMapping ("/clientes/eliminar/{id_cliente}")
    public String deleteCliente(@PathVariable long id_cliente){
        clienServ.deleteCLiente(id_cliente);
        return "Cliente eliminado correctamente";
    }
    
    @PutMapping ("/clientes/editar/{id_cliente}")
    public Cliente editCliente(@PathVariable long id_cliente,
                               @RequestParam (required = false, name = "id_cliente") long idNueva,
                               @RequestParam (required = false, name = "nombre") String nuevoNombre,
                               @RequestParam (required = false, name = "apellido") String nuevoApellido,
                               @RequestParam (required = false, name = "dni") String nuevoDni){
        
        
        clienServ.editCliente(id_cliente, idNueva, nuevoNombre, nuevoApellido, nuevoDni);
        
        return clienServ.findCliente(idNueva);
    }
    
    @PutMapping ("/clientes/editar")
    public Cliente editCliente (@RequestBody Cliente clien){
        clienServ.editCliente(clien);
        return clienServ.findCliente(clien.getId_cliente());
    }    
}
