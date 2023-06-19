package com.lucas.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lucas.modelos.Usuario;

import java.util.List;

public class UsuarioDAO {
    private EntityManagerFactory emf;

    public UsuarioDAO() {
        emf = Persistence.createEntityManagerFactory("my-persistence-unit");
    }

    public void salvarUsuario(Usuario usuario) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
        em.close();
    }

    public Usuario buscarUsuarioPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        Usuario usuario = em.find(Usuario.class, id);
        em.close();
        return usuario;
    }

    @SuppressWarnings("unchecked")
    public List<Usuario> buscarTodosUsuarios() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT u FROM Usuario u");
        List<Usuario> usuario = query.getResultList();
        em.close();
        return usuario;
    }

    @SuppressWarnings("unchecked")
    public List<Usuario> buscarTodosPacientes() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT p FROM Paciente p");
        List<Usuario> usuario = query.getResultList();
        em.close();
        return usuario;
    }

    @SuppressWarnings("unchecked")
    public List<Usuario> buscarTodosAdministradores(){
          EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT a FROM Administrador a");
        List<Usuario> usuario = query.getResultList();
        em.close();
        return usuario;
    }

    public void atualizarPessoa(Usuario usuario) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(usuario);
        em.getTransaction().commit();
        em.close();
    }

    public void excluirPessoa(Usuario usuario) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        usuario = em.merge(usuario);
        em.remove(usuario);
        em.getTransaction().commit();
        em.close();
    }

    public boolean validarUsername(String username) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.username = :username");
        query.setParameter("username", username);
        query.setMaxResults(1);

        boolean exists = query.getResultList().size() > 0;
        em.close();

        return exists;
    }
    
}
