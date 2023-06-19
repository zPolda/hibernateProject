package com.lucas.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lucas.modelos.Hospital;

import java.util.List;

public class HospitalDAO {

    private EntityManagerFactory emf;

    public HospitalDAO() {
        emf = Persistence.createEntityManagerFactory("my-persistence-unit");
    }

    public void salvarHospital(Hospital hospital) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(hospital);
        em.getTransaction().commit();
        em.close();
    }

    public Hospital buscarHospitalPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        Hospital hospital = em.find(Hospital.class, id);
        em.close();
        return hospital;
    }

    @SuppressWarnings("unchecked")
    public List<Hospital> buscarTodasHospitais() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT h FROM Hospital h");
        List<Hospital> hospital = query.getResultList();
        em.close();
        return hospital;
    }

    public void atualizarHospital(Hospital hospital) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(hospital);
        em.getTransaction().commit();
        em.close();
    }

    public void excluirHospital(Hospital hospital) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        hospital = em.merge(hospital);
        em.remove(hospital);
        em.getTransaction().commit();
        em.close();
    }
    
}
