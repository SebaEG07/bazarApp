package com.bazarapi.bazarapplication.controller;

import com.bazarapi.bazarapplication.model.Producto;
import com.bazarapi.bazarapplication.service.IProductoService;
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
public class ProductoController {
    
    @Autowired
    private IProductoService prodServ;
    
    @PostMapping ("/productos/crear")
    public String saveProducto(@RequestBody Producto prod){
        prodServ.saveProducto(prod);
        return "Producto creado correctamente";
    }
    
    @GetMapping ("/productos")
    public List<Producto> getProductos(){
        return prodServ.getProductos();
    }
    
    @GetMapping ("/productos/{codigo_producto}")
    public Producto findProducto(@PathVariable long codigo_producto){
        return prodServ.findProducto(codigo_producto);
    }
    
    @DeleteMapping ("/productos/eliminar/{codigo_producto}")
    public String deleteProducto(@PathVariable long codigo_producto){
        prodServ.deleteProducto(codigo_producto);
        return "Producto eliminado correctamente";
    }
    
    @PutMapping ("/productos/editar/{codigo_producto}")
    public Producto editProducto(@PathVariable long codigo_producto,
                                 @RequestParam (required = false, name = "codigo_producto") long idNueva,
                                 @RequestParam (required = false, name = "nombre") String nuevoNombre,
                                 @RequestParam (required = false, name = "marca") String nuevaMarca,
                                 @RequestParam (required = false, name = "costo") Double nuevoCosto,
                                 @RequestParam (required = false, name = "cantidad_disponible") Double nuevaCantDisponible){
        
        
        prodServ.editProducto(codigo_producto, idNueva, nuevoNombre, nuevaMarca, nuevoCosto, nuevaCantDisponible);
        
        return prodServ.findProducto(idNueva);
    }
    
    @PutMapping ("/productos/editar")
    public Producto editProducto(@RequestBody Producto prod){
        prodServ.editProducto(prod);
        return prodServ.findProducto(prod.getCodigo_producto());
    }
    
    @GetMapping ("/productos/falta_stock")
    public List<Producto> revisarStock(){
        return prodServ.revisarStock();
    }
}
