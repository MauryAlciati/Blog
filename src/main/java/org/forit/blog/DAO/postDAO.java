/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.blog.DAO;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import org.forit.blog.DTO.postDTO;
import org.forit.blog.entity.postEntity;
import org.forit.blog.exceptions.blogException;

/**
 *
 * @author forIT
 */
public class postDAO {

    public List<postDTO> getListaPost() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog_pu");
        EntityManager em = emf.createEntityManager();

        TypedQuery<postEntity> query = em.createNamedQuery("post.selectAll", postEntity.class);
        List<postEntity> list = query.getResultList();
        List<postDTO> post = list.stream().map(entity -> {
            return new postDTO(entity.getID(),
                    entity.getIdCategoria(),
                    entity.getTitolo(),
                    entity.getDescrizione(),
                    entity.getData(),
                    entity.isVisibile(),
                    entity.getVisite(),
                    entity.getIdAutore()
            );
        }).collect(Collectors.toList());

        em.close();
        emf.close();

        return post;
    }

    public postDTO getPost(long ID) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog_pu");
        EntityManager em = emf.createEntityManager();

        postEntity entity = em.find(postEntity.class, ID);
        postDTO post = new postDTO(entity.getID(),
                entity.getIdCategoria(),
                entity.getTitolo(),
                entity.getDescrizione(),
                entity.getData(),
                entity.isVisibile(),
                entity.getVisite(),
                entity.getIdAutore());

        em.close();
        emf.close();

        return post;
    }

    public void insertPost(Long id_categoria, String titolo, String descrizione, LocalDate data, boolean visibile, int visite, Long id_autore) throws blogException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog_pu");
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            postEntity post = new postEntity();
            post.setIdCategoria(id_categoria);
            post.setTitolo(titolo);
            post.setDescrizione(descrizione);
            post.setData(data);
            post.setVisibile(visibile);
            post.setVisite(visite);
            post.setIdAutore(id_autore);
            em.persist(post);

            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            throw new blogException();
        } finally {
            em.close();
            emf.close();
        }
    }

    public void deletePost(long ID) throws blogException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog_pu");
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            postEntity post = em.find(postEntity.class, ID);

            em.remove(post);

            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            throw new blogException();
        } finally {
            em.close();
            emf.close();
        }
    }

    public void updatePost(long ID, long id_categoria, String titolo, String descrizione, LocalDate data, boolean visibile, int visite, long id_autore) throws blogException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog_pu");
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            postEntity post = em.find(postEntity.class, ID);
            post.setIdCategoria(id_categoria);
            post.setTitolo(titolo);
            post.setDescrizione(descrizione);
            post.setData(data);
            post.setVisibile(visibile);
            post.setVisite(visite);
            post.setIdAutore(id_autore);
            em.merge(post);

            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            throw new blogException();
        } finally {
            em.close();
            emf.close();
        }
    }

}
