package com.bazarapi.bazarapplication.service;

import com.bazarapi.bazarapplication.model.Producto;
import com.bazarapi.bazarapplication.repository.IProductoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService{
    
    @Autowired
    private IProductoRepository prodRepo;
    
    @Override
    public void saveProducto(Producto produc) {
        prodRepo.save(produc);
    }

    @Override
    public List<Producto> getProductos() {
        return prodRepo.findAll();
    }

    @Override
    public Producto findProducto(Long id) {
        return prodRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteProducto(Long id) {
        prodRepo.deleteById(id);
    }

    @Override
    public void editProducto(Long idOriginal, Long idNueva, String nuevoNombre, String nuevaMarca, Double nuevoCosto, Double nuevaCantidad_disponible) {
        Producto prod = this.findProducto(idOriginal);
        
        prod.setCodigo_producto(idNueva);
        prod.setNombre(nuevoNombre);
        prod.setMarca(nuevaMarca);
        prod.setCosto(nuevoCosto);
        prod.setCantidad_disponible(nuevaCantidad_disponible);
        
        this.saveProducto(prod);
    }

    @Override
    public void reduceProducto(Producto prod) {
        double nuevaCant;
        nuevaCant = prod.getCantidad_disponible()-1;
        prod.setCantidad_disponible(nuevaCant);
        this.saveProducto(prod);
    }

    @Override
    public List<Producto> revisarStock() {
        List<Producto> listProd = this.getProductos();
        List<Producto> listBajaCant = new ArrayList<>();
        for (Producto prod:listProd){
            if (prod.getCantidad_disponible()<5){
                listBajaCant.add(prod);
            }
        }
        return listBajaCant;
    }

    @Override
    public void editProducto(Producto prod) {
        this.saveProducto(prod);
    }
    
   
    
}
