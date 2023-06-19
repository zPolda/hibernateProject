package com.lucas.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lucas.modelos.Consulta;

import java.util.List;

public class ConsultaDAO {

    private EntityManagerFactory emf;

    public ConsultaDAO() {
        emf = Persistence.createEntityManagerFactory("my-persistence-unit");
    }

    

    public void salvarConsulta(Consulta consulta) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(consulta);
        em.getTransaction().commit();
        em.close();
    }

    public Consulta buscarConsultaPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        Consulta consulta = em.find(Consulta.class, id);
        em.close();
        return consulta;
    }

    @SuppressWarnings("unchecked")
    public List<Consulta> buscarTodasConsultas() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT c FROM Consulta c");
        List<Consulta> consulta = query.getResultList();
        em.close();
        return consulta;
    }

    public void atualizarConsulta(Consulta consulta) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(consulta);
        em.getTransaction().commit();
        em.close();
    }

    public void excluirConsulta(Consulta consulta) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        consulta = em.merge(consulta);
        em.remove(consulta);
        em.getTransaction().commit();
        em.close();
    }
    
}
