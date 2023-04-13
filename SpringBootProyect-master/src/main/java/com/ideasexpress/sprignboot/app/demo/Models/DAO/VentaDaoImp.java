package com.ideasexpress.sprignboot.app.demo.Models.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.ideasexpress.sprignboot.app.demo.Models.Entity.Ventas;

@Repository
public class VentaDaoImp implements IVentaDao {

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Ventas> findAll() {

        return em.createQuery("from Ventas").getResultList();

    }

    @Transactional
    @Override
    public void save(Ventas Venta) {

        if (Venta.getId() != null && Venta.getId() > 0) {
            em.merge(Venta);
        } else {
            em.persist(Venta);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Ventas findOne(Long id) {
        return em.find(Ventas.class, id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Ventas Venta = findOne(id);
        em.remove(Venta);
    }

}