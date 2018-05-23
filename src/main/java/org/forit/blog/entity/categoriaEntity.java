/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.blog.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
@NamedQueries({
    @NamedQuery(
            name = "categoria.selectAll",
            query = "SELECT c "
            + "FROM categoriaEntity c "
            + "ORDER BY c.nome"
    )
})
public class categoriaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private long ID;

    @Column(table = "categoria", name = "descrizione", nullable = true)
    private String descrizione;

    @Column(table = "categoria", name = "nome", nullable = false)
    private String nome;

    @Column(table = "categoria", name = "immagine", nullable = true)
    private String immagine;

    @Column(table = "categoria", name = "visibile", nullable = true)
    private boolean visibile;

    public categoriaEntity() {
    }

    public categoriaEntity(long ID, String descrizione, String nome, String immagine, boolean visibile) {
        this.ID = ID;
        this.descrizione = descrizione;
        this.nome = nome;
        this.immagine = immagine;
        this.visibile = visibile;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
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
        hash = 59 * hash + (int) (this.ID ^ (this.ID >>> 32));
        hash = 59 * hash + Objects.hashCode(this.descrizione);
        hash = 59 * hash + Objects.hashCode(this.nome);
        hash = 59 * hash + Objects.hashCode(this.immagine);
        hash = 59 * hash + (this.visibile ? 1 : 0);
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
        final categoriaEntity other = (categoriaEntity) obj;
        if (this.ID != other.ID) {
            return false;
        }
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
        return true;
    }

    @Override
    public String toString() {
        return "categoriaEntity{" + "ID=" + ID + ", descrizione=" + descrizione + ", nome=" + nome + ", immagine=" + immagine + ", visibile=" + visibile + '}';
    }

}
