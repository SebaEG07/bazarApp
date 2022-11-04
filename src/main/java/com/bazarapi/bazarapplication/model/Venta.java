package com.bazarapi.bazarapplication.model;


import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Entity
public class Venta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo_venta;
    private String fecha_venta;
    private Double total;
    @OneToOne
    @JoinColumn (name = "un_cliente_id_cliente", referencedColumnName = "id_cliente")
    private Cliente unCliente;
    @OneToMany
    private List<Producto> listaProductos;

    public Venta() {
    }

    public Venta(Long codigo_venta, String fecha_venta, Double total, List<Producto> listaProductos, Cliente unCliente) {
        this.codigo_venta = codigo_venta;
        this.fecha_venta = fecha_venta;
        this.total = total;
        this.listaProductos = listaProductos;
        this.unCliente = unCliente;
    }
    
}
