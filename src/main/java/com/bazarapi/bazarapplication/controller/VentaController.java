package com.bazarapi.bazarapplication.controller;

import com.bazarapi.bazarapplication.dto.VentaProductoDTO;
import com.bazarapi.bazarapplication.model.Cliente;
import com.bazarapi.bazarapplication.model.Producto;
import com.bazarapi.bazarapplication.model.Venta;
import com.bazarapi.bazarapplication.service.IVentaService;
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
public class VentaController {
    
    @Autowired
    private IVentaService venServ;
    
    @PostMapping("/ventas/crear")
    public String saveVenta(@RequestBody Venta ven){
       venServ.saveVenta(ven);
       return "Venta creada correctamente";
    }
    
    @GetMapping ("/ventas")
    public List<Venta> getVentas(){
        return venServ.getVentas();
    }
    
    @GetMapping ("/ventas/{codigo_venta}")
    public Venta findVenta(@PathVariable long codigo_venta){
        return venServ.findVenta(codigo_venta);
    }
    
    @DeleteMapping ("/ventas/eliminar/{codigo_venta}")
    public String deleteVenta(@PathVariable long codigo_venta){
        venServ.deleteVenta(codigo_venta);
        return "Venta eliminada correctamente";
    }
    
    @PutMapping ("/ventas/editar/{codigo_venta}")
    public Venta editVenta(@PathVariable long codigo_venta,
                           @RequestParam (required = false, name = "codigo_venta") long idNueva,
                           @RequestParam (required = false, name = "fecha_venta") String nuevaFecha_venta,
                           @RequestParam (required = false, name = "total") Double nuevoTotal,
                           @RequestParam (required = false, name = "listaProductos") List<Producto> nuevaListaProductos,
                           @RequestParam (required = false, name = "unCliente") Cliente nuevoCliente){
        
        
        venServ.editVenta(codigo_venta, idNueva, nuevaFecha_venta, nuevoTotal, nuevaListaProductos, nuevoCliente);
        
        return venServ.findVenta(idNueva);
    }
    
    @PutMapping ("/ventas/editar")
    public Venta editVenta(@RequestBody Venta ven){
        venServ.editVenta(ven);
        return venServ.findVenta(ven.getCodigo_venta());
    }
    
    
    @GetMapping ("/ventas/productos/{codigo_venta}")
    public List<Producto> getListaProductos(@PathVariable long codigo_venta){
        return venServ.getProductosVenta(codigo_venta);
    }
    
    @GetMapping ("/ventas/{fecha_venta}")
    public String getDetallesDiaVenta(@PathVariable String fecha_venta){
        return venServ.getDetallesDiaVenta(fecha_venta);
        
    }
    
    @GetMapping ("/ventas/mayor_venta")
    public VentaProductoDTO getMayorVenta(){
        return venServ.getMayorVenta();
    }
}
