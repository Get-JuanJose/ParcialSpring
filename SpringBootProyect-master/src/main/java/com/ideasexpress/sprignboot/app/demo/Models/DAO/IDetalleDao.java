package com.ideasexpress.sprignboot.app.demo.Models.DAO;

import java.util.List;

import com.ideasexpress.sprignboot.app.demo.Models.Entity.Detalle;

public interface IDetalleDao {
    
    public List<Detalle> findAll();
    public void save(Detalle Venta);
    public Detalle findOne(Long id);
    public void delete(Long id);
}