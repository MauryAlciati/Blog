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
import org.forit.blog.DTO.commentoDTO;
import org.forit.blog.entity.commentoEntity;
import org.forit.blog.exceptions.blogException;

/**
 *
 * @author forIT
 */
public class commentoDAO {

    public List<commentoDTO> getListaCommento() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog_pu");
        EntityManager em = emf.createEntityManager();

        TypedQuery<commentoEntity> query = em.createNamedQuery("commento.selectAll", commentoEntity.class);
        List<commentoEntity> list = query.getResultList();
        List<commentoDTO> commento = list.stream().map(entity -> {
            return new commentoDTO(entity.getID(),
                    entity.getNickname(),
                    entity.getEmail(),
                    entity.getDataInserimento(),
                    entity.getTesto(),
                    entity.getDataRisposta(),
                    entity.getRisposta(),
                    entity.isVisibile(),
                    entity.getIdPost()
            );
        }).collect(Collectors.toList());

        em.close();
        emf.close();

        return commento;
    }

    public commentoDTO getCommento(long ID) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog_pu");
        EntityManager em = emf.createEntityManager();

        commentoEntity entity = em.find(commentoEntity.class, ID);
        commentoDTO commento = new commentoDTO(entity.getID(),
                entity.getNickname(),
                entity.getEmail(),
                entity.getDataInserimento(),
                entity.getTesto(),
                entity.getDataRisposta(),
                entity.getRisposta(),
                entity.isVisibile(),
                entity.getIdPost());

        em.close();
        emf.close();

        return commento;
    }

    public void insertCommento(String nickname, String email, LocalDate dataInserimento, String testo, LocalDate dataRisposta, String risposta, boolean visibile, long idPost) throws blogException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog_pu");
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            commentoEntity commento = new commentoEntity();
            commento.setNickname(nickname);
            commento.setEmail(email);
            commento.setDataInserimento(dataInserimento);
            commento.setTesto(testo);
            commento.setDataRisposta(dataRisposta);
            commento.setRisposta(risposta);
            commento.setVisibile(visibile);
            commento.setIdPost(idPost);

            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            throw new blogException();
        } finally {
            em.close();
            emf.close();
        }
    }

    public void deleteCommento(long ID) throws blogException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog_pu");
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            commentoEntity commento = em.find(commentoEntity.class, ID);

            em.remove(commento);

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
