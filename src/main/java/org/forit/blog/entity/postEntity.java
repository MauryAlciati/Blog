/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.blog.entity;

import java.io.Serializable;
import java.time.LocalDate;
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
@Table(name = "post")
@NamedQueries({
    @NamedQuery(
            name = "post.selectAll",
            query = "SELECT p "
            + "FROM postEntity p "
            + "ORDER BY p.titolo"
    )
})
public class postEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private long ID;

    @Column(table = "post", name = "id_categoria",unique = false, nullable = false)
    private Long idCategoria;

    @Column(table = "post", name = "titolo", nullable = false)
    private String titolo;

    @Column(table = "post", name = "descrizione", nullable = false)
    private String descrizione;

    @Column(table = "post", name = "data", nullable = false)
    private LocalDate data;

    @Column(table = "post", name = "visibile", nullable = false)
    private boolean visibile;

    @Column(table = "post", name = "visite", nullable = true)
    private int visite;

    @Column(table = "post", name = "id_autore",unique = false, nullable = false)
    private Long idAutore;

    public postEntity() {
    }

    public postEntity(long ID, Long idCategoria, String titolo, String descrizione, LocalDate data, boolean visibile, int visite, Long idAutore) {
        this.ID = ID;
        this.idCategoria = idCategoria;
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.data = data;
        this.visibile = visibile;
        this.visite = visite;
        this.idAutore = idAutore;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public boolean isVisibile() {
        return visibile;
    }

    public void setVisibile(boolean visibile) {
        this.visibile = visibile;
    }

    public int getVisite() {
        return visite;
    }

    public void setVisite(int visite) {
        this.visite = visite;
    }

    public Long getIdAutore() {
        return idAutore;
    }

    public void setIdAutore(Long idAutore) {
        this.idAutore = idAutore;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + (int) (this.ID ^ (this.ID >>> 32));
        hash = 61 * hash + Objects.hashCode(this.idCategoria);
        hash = 61 * hash + Objects.hashCode(this.titolo);
        hash = 61 * hash + Objects.hashCode(this.descrizione);
        hash = 61 * hash + Objects.hashCode(this.data);
        hash = 61 * hash + (this.visibile ? 1 : 0);
        hash = 61 * hash + this.visite;
        hash = 61 * hash + Objects.hashCode(this.idAutore);
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
        final postEntity other = (postEntity) obj;
        if (this.ID != other.ID) {
            return false;
        }
        if (this.visibile != other.visibile) {
            return false;
        }
        if (this.visite != other.visite) {
            return false;
        }
        if (!Objects.equals(this.titolo, other.titolo)) {
            return false;
        }
        if (!Objects.equals(this.descrizione, other.descrizione)) {
            return false;
        }
        if (!Objects.equals(this.idCategoria, other.idCategoria)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (!Objects.equals(this.idAutore, other.idAutore)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "postEntity{" + "ID=" + ID + ", idCategoria=" + idCategoria + ", titolo=" + titolo + ", descrizione=" + descrizione + ", data=" + data + ", visibile=" + visibile + ", visite=" + visite + ", idAutore=" + idAutore + '}';
    }

}
