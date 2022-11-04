package com.bazarapi.bazarapplication.service;

import com.bazarapi.bazarapplication.dto.VentaProductoDTO;
import com.bazarapi.bazarapplication.model.Cliente;
import com.bazarapi.bazarapplication.model.Producto;
import com.bazarapi.bazarapplication.model.Venta;
import com.bazarapi.bazarapplication.repository.IVentaRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService{

    @Autowired
    private IVentaRepository venRepo;
    //private IProductoService prodServ;
    
    @Override
    public void saveVenta(Venta vent) {
      venRepo.save(vent);
    }

    @Override
    public List<Venta> getVentas() {
        return venRepo.findAll();
    }

    @Override
    public Venta findVenta(Long id) {
        return venRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteVenta(Long id) {
        venRepo.deleteById(id);
    }

    @Override
    public void editVenta(Long idOriginal, Long idNueva, String nuevaFecha_venta, Double nuevoTotal, List<Producto> nuevaListaProductos, Cliente nuevoCliente) {
        Venta ven = this.findVenta(idOriginal);
        
        ven.setCodigo_venta(idNueva);
        ven.setFecha_venta(nuevaFecha_venta);
        ven.setTotal(nuevoTotal);
        ven.setListaProductos(nuevaListaProductos);
        ven.setUnCliente(nuevoCliente);
        
        this.saveVenta(ven);
    }

    @Override
    public List<Producto> getProductosVenta(Long id) {
        Venta vent = this.findVenta(id);
        return vent.getListaProductos();
    }

    @Override
    public String getDetallesDiaVenta(String fecha) {
        List<Venta> listaVent = this.getVentas();
        int cont = 0;
        double total=0;
        for(Venta vent:listaVent){
            if(vent.getFecha_venta().equals(fecha)){
                cont++;
                total +=vent.getTotal(); 
            }
        }
        return "Cantidad de venta/s del día " + fecha + ": " + cont 
             + "\nMonto total de la/s venta/s del día: " + total;
    }

    @Override
    public VentaProductoDTO getMayorVenta() {
        VentaProductoDTO venProdDTO = new VentaProductoDTO();
        List<Venta> listaVentas = this.getVentas();
        Venta mayorVenta = null;
        
        for (Venta vent:listaVentas){
           
            if(mayorVenta==null){
                mayorVenta = vent;
            }
            else{
                if(mayorVenta.getTotal()<vent.getTotal()){
                    mayorVenta = vent;
                }
            }
                
        }
        
        venProdDTO.setCodigoVenta(mayorVenta.getCodigo_venta());
        venProdDTO.setTotal(mayorVenta.getTotal());
        venProdDTO.setCantidadProductos(mayorVenta.getListaProductos().size());
        venProdDTO.setNombreCliente(mayorVenta.getUnCliente().getNombre());
        venProdDTO.setApellidoCliente(mayorVenta.getUnCliente().getApellido());
        
        return venProdDTO;
    }

    @Override
    public void editVenta(Venta ven) {
        this.saveVenta(ven);
    }
    
}
