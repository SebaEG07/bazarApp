package com.bazarapi.bazarapplication.service;

import com.bazarapi.bazarapplication.model.Cliente;
import com.bazarapi.bazarapplication.repository.IClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private IClienteRepository clienRepo;
    
    @Override
    public void saveCliente(Cliente clien) {
        clienRepo.save(clien);
    }

    @Override
    public List<Cliente> getCientes() {
        return clienRepo.findAll();
    }

    @Override
    public Cliente findCliente(Long id) {
        return clienRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteCLiente(Long id) {
        clienRepo.deleteById(id);
    }

    @Override
    public void editCliente(Long idOriginal, Long idNueva, String nuevoNombre, String nuevoApellido, String nuevoDni) {
        Cliente clien = this.findCliente(idOriginal);
        
        clien.setId_cliente(idNueva);
        clien.setNombre(nuevoNombre);
        clien.setApellido(nuevoApellido);
        clien.setDni(nuevoDni);
        
        this.saveCliente(clien);
        
    }

    @Override
    public void editCliente(Cliente clien) {
        this.saveCliente(clien);
    }
}
