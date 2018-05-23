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
import org.forit.blog.DTO.accountDTO;
import org.forit.blog.entity.accountEntity;
import org.forit.blog.exceptions.blogException;

/**
 *
 * @author forIT
 */
public class utenteDAO {

    public List<accountDTO> getListaUtenti() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog_pu");
        EntityManager em = emf.createEntityManager();

        TypedQuery<accountEntity> query = em.createNamedQuery("account.selectAll", accountEntity.class);
        List<accountEntity> list = query.getResultList();
        List<accountDTO> account = list.stream().map(entity -> {
            return new accountDTO(entity.getID(), entity.getNome(), entity.getCognome(),
                    entity.getUsername(), entity.getEmail(), entity.getPassword(),
                    entity.getDataRegistrazione(), entity.getDataUltimoAccesso(),
                    entity.isAttivo(), entity.isBloccato(), entity.getNumeroTentativi(),
                    entity.getIdRuolo()
            );
        }).collect(Collectors.toList());

        em.close();
        emf.close();

        return account;
    }

    public accountDTO getUtente(long ID) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog_pu");
        EntityManager em = emf.createEntityManager();

        accountEntity entity = em.find(accountEntity.class, ID);
        accountDTO account = new accountDTO(entity.getID(),
                entity.getNome(),
                entity.getCognome(),
                entity.getUsername(),
                entity.getEmail(),
                entity.getPassword(),
                entity.getDataRegistrazione(),
                entity.getDataUltimoAccesso(),
                entity.isAttivo(),
                entity.isBloccato(),
                entity.getNumeroTentativi(),
                entity.getIdRuolo());

        em.close();
        emf.close();

        return account;
    }

    public void insertAccount(String nome, String cognome, String username, String email, String password, LocalDate dataRegistrazione, LocalDate dataUltimoAccesso, boolean attivo, boolean bloccato, int numeroTentativi, Long idRuolo) throws blogException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog_pu");
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            accountEntity account = new accountEntity();
            account.setNome(nome);
            account.setCognome(cognome);
            account.setUsername(username);
            account.setEmail(email);
            account.setPassword(password);
            account.setDataRegistrazione(dataRegistrazione);
            account.setDataUltimoAccesso(dataUltimoAccesso);
            account.setAttivo(attivo);
            account.setBloccato(bloccato);
            account.setNumeroTentativi(numeroTentativi);
            account.setIdRuolo(idRuolo);
            em.persist(account);

            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            throw new blogException();
        } finally {
            em.close();
            emf.close();
        }
    }

    public void deleteAccount(long ID) throws blogException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog_pu");
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            accountEntity account = em.find(accountEntity.class, ID);

            em.remove(account);

            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            throw new blogException();
        } finally {
            em.close();
            emf.close();
        }
    }

    public void updateAccount(long ID, String nome, String cognome, String username, String email, String password, LocalDate dataRegistrazione, LocalDate dataUltimoAccesso, boolean attivo, boolean bloccato, int numeroTentativi, long idRuolo) throws blogException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog_pu");
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            accountEntity account = em.find(accountEntity.class, ID);
            account.setNome(nome);
            account.setCognome(cognome);
            account.setUsername(username);
            account.setEmail(email);
            account.setPassword(password);
            account.setDataRegistrazione(dataRegistrazione);
            account.setDataUltimoAccesso(dataUltimoAccesso);
            account.setAttivo(attivo);
            account.setBloccato(bloccato);
            account.setNumeroTentativi(numeroTentativi);
            account.setIdRuolo(idRuolo);
            em.merge(account);

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
