package com.bazarapi.bazarapplication.service;

import com.bazarapi.bazarapplication.model.Producto;
import java.util.List;

public interface IProductoService {
    
    //Crear producto
    public void saveProducto(Producto produc);
    
    //Obtener lista de productos
    public List<Producto> getProductos();
    
    //Obtener producto en particular
    public Producto findProducto(Long id);
    
    //Eliminar un producto
    public void deleteProducto(Long id);
    
    //Descontar un producto
    public void reduceProducto(Producto prod);
    
    //Editar un producto
    public void editProducto(Long idOriginal, Long idNueva,
                            String nuevoNombre,
                            String nuevaMarca,
                            Double nuevoCosto,
                            Double nuevaCantidad_disponible);
    
    //Revisar producto
    public List<Producto> revisarStock();

    public void editProducto(Producto prod);

}
