package com.bazarapi.bazarapplication.dto;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class VentaProductoDTO {
    private Long codigoVenta;
    private Double total;
    private int cantidadProductos;
    private String nombreCliente;
    private String apellidoCliente;

    public VentaProductoDTO() {
    }

    public VentaProductoDTO(Long codigoVenta, Double total, int cantidadProductos, String nombreCliente, String apellidoCliente) {
        this.codigoVenta = codigoVenta;
        this.total = total;
        this.cantidadProductos = cantidadProductos;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
    }
    
    
}
