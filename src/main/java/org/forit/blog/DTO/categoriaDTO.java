/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.blog.DTO;

import java.util.Objects;

/**
 *
 * @author forIT
 */
public class categoriaDTO {
    
    private Long ID;
    private String descrizione;
    private String nome;
    private String immagine;
    private boolean visibile;

    public categoriaDTO() {
    }

    public categoriaDTO(Long ID, String descrizione, String nome, String immagine, boolean visibile) {
        this.ID = ID;
        this.descrizione = descrizione;
        this.nome = nome;
        this.immagine = immagine;
        this.visibile = visibile;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImmagine() {
        return immagine;
    }

    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }

    public boolean isVisibile() {
        return visibile;
    }

    public void setVisibile(boolean visibile) {
        this.visibile = visibile;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.ID);
        hash = 23 * hash + Objects.hashCode(this.descrizione);
        hash = 23 * hash + Objects.hashCode(this.nome);
        hash = 23 * hash + Objects.hashCode(this.immagine);
        hash = 23 * hash + (this.visibile ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final categoriaDTO other = (categoriaDTO) obj;
        if (this.visibile != other.visibile) {
            return false;
        }
        if (!Objects.equals(this.descrizione, other.descrizione)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.immagine, other.immagine)) {
            return false;
        }
        if (!Objects.equals(this.ID, other.ID)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "categoriaDTO{" + "ID=" + ID + ", descrizione=" + descrizione + ", nome=" + nome + ", immagine=" + immagine + ", visibile=" + visibile + '}';
    }

    
    
    
    
}
