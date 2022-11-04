package com.bazarapi.bazarapplication.service;

import com.bazarapi.bazarapplication.dto.VentaProductoDTO;
import com.bazarapi.bazarapplication.model.Cliente;
import com.bazarapi.bazarapplication.model.Producto;
import com.bazarapi.bazarapplication.model.Venta;
import java.util.List;

public interface IVentaService {
    //Crear Venta
    public void saveVenta(Venta vent);
    
    //Obtener lista de ventas
    public List<Venta> getVentas();
    
    //Obtener venta en particular
    public Venta findVenta(Long id);
    
    //Eliminar venta
    public void deleteVenta(Long id);
    
    //Editar venta
    public void editVenta(Long idOriginal, Long idNueva,
                          String nuevaFecha_venta,
                          Double nuevoTotal,
                          List<Producto> nuevaListaProductos,
                          Cliente nuevoCliente);
    
    //Obtener productos de una venta
    public List<Producto> getProductosVenta(Long id);
    
    //Obtener la sumatoria del monto y también cantidad total de ventas
    public String getDetallesDiaVenta(String fecha);
    
    //Obtener la venta con el monto más alto de todas 
    public VentaProductoDTO getMayorVenta();

    public void editVenta(Venta ven);
}
