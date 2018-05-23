/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.blog.rest;

import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.forit.blog.DAO.tagDAO;
import org.forit.blog.DTO.tagDTO;
import org.forit.blog.exceptions.blogException;

@Path("/tag")
public class tagRest {

    @Path("/")
    @GET()
    @Produces("application/json")
    public List<tagDTO> getListaTag() {

        tagDAO tagDAO = new tagDAO();
        return tagDAO.getListaTag();
    }

    @Path("/{id}")
    @GET()
    @Produces("application/json")
    public tagDTO getTag(@PathParam("id") long ID) {
        tagDAO tagDAO = new tagDAO();
        return tagDAO.getTag(ID);
    }

    @Path("/")
    @POST()
    @Produces("application/json")
    public boolean postTag(tagDTO t) {
        try {
            tagDAO tag = new tagDAO();
            tag.insertTag(t.getNome());
            return true;
        } catch (blogException ex) {
            System.out.println("Errore: " + ex.getMessage());
            return false;
        }
    }

    @Path("/")
    @DELETE()
    @Produces("application/json")
    public boolean deleteTag(tagDTO t) {
        try {
            tagDAO tag = new tagDAO();
            tag.deleteTag(t.getID());
            return true;
        } catch (blogException ex) {
            System.out.println("Errore: " + ex.getMessage());
            return false;
        }
    }
}
