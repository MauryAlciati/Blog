/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.blog.rest;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.forit.blog.DAO.utenteDAO;
import org.forit.blog.DTO.accountDTO;
import org.forit.blog.exceptions.blogException;

@Path("/account")
public class accountRest {

    @Path("/")
    @GET()
    @Produces("application/json")
    public List<accountDTO> getAccount() {

        utenteDAO utenteDAO = new utenteDAO();
        return utenteDAO.getListaUtenti();
    }

    @Path("/{id}")
    @GET()
    @Produces("application/json")
    public accountDTO getPost(@PathParam("id") long ID) {
        utenteDAO utenteDAO = new utenteDAO();
        return utenteDAO.getUtente(ID);
    }

    @Path("/")
    @POST()
    @Produces("application/json")
    public boolean postAccount(accountDTO a) {
        try {
            utenteDAO account = new utenteDAO();
            account.insertAccount(a.getNome(), a.getCognome(), a.getUsername(), a.getEmail(), a.getPassword(), a.getDataRegistrazione(), a.getDataUltimoAccesso(), a.isAttivo(), a.isBloccato(), a.getNumeroTentativi(), a.getIdRuolo());
            return true;
        } catch (blogException ex) {
            System.out.println("Errore: " + ex.getMessage());
            return false;
        }
    }

    @Path("/")
    @PUT()
    @Consumes("application/json")
    @Produces("application/json")
    public boolean putAccount(accountDTO a) {
        try {
            utenteDAO utenteDAO = new utenteDAO();
            utenteDAO.updateAccount(a.getID(), a.getNome(), a.getCognome(), a.getUsername(), a.getEmail(), a.getPassword(), a.getDataRegistrazione(), a.getDataUltimoAccesso(), a.isAttivo(), a.isBloccato(), a.getNumeroTentativi(), a.getIdRuolo());
            return true;
        } catch (blogException ex) {
            return false;
        }
    }

    @Path("/")
    @DELETE()
    @Produces("application/json")
    public boolean deleteAccount(accountDTO a) {
        try {
            utenteDAO account = new utenteDAO();
            account.deleteAccount(a.getID());
            return true;
        } catch (blogException ex) {
            System.out.println("Errore: " + ex.getMessage());
            return false;
        }
    }
}
