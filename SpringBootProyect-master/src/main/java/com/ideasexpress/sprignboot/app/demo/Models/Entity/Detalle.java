package com.ideasexpress.sprignboot.app.demo.Models.Entity;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name = "detalle")
public class Detalle  implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Long idProducto, idVenta; 
    private int cantidad, valorVenta;

    public Long getId() {
        return Id;
    }
    public void setId(Long id) {
        Id = id;
    }
    public Long getIdProducto() {
        return idProducto;
    }
    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }
    public Long getIdVenta() {
        return idVenta;
    }
    public void setIdVenta(Long idVenta) {
        this.idVenta = idVenta;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public int getValorVenta() {
        return valorVenta;
    }
    public void setValorVenta(int valorVenta) {
        this.valorVenta = valorVenta;
    }




}
