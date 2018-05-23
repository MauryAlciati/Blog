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
@Table(name = "account")
@NamedQueries({
    @NamedQuery(
            name = "account.selectAll",
            query = "SELECT a "
            + "FROM accountEntity a "
            + "ORDER BY a.nome"
    )
})
public class accountEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private long ID;

    @Column(table = "account", name = "nome", nullable = true)
    private String nome;

    @Column(table = "account", name = "cognome", nullable = true)
    private String cognome;

    @Column(table = "account", name = "username", nullable = false)
    private String username;

    @Column(table = "account", name = "email", unique = true, nullable = false)
    private String email;

    @Column(table = "account", name = "password", nullable = false)
    private String password;

    @Column(table = "account", name = "data_registrazione", nullable = false)
    private LocalDate dataRegistrazione;

    @Column(table = "account", name = "data_ultimo_accesso", nullable = false)
    private LocalDate dataUltimoAccesso;

    @Column(table = "account", name = "attivo", nullable = false)
    private boolean attivo;

    @Column(table = "account", name = "bloccato", nullable = false)
    private boolean bloccato;

    @Column(table = "account", name = "numero_tentativi", nullable = false)
    private int numeroTentativi;

    @Column(table = "account", name = "id_ruolo",unique = false, nullable = true)
    private Long idRuolo;

    public accountEntity() {
    }

    public accountEntity(long ID, String nome, String cognome, String username, String email, String password, LocalDate dataRegistrazione, LocalDate dataUltimoAccesso, boolean attivo, boolean bloccato, int numeroTentativi, Long idRuolo) {
        this.ID = ID;
        this.nome = nome;
        this.cognome = cognome;
        this.username = username;
        this.email = email;
        this.password = password;
        this.dataRegistrazione = dataRegistrazione;
        this.dataUltimoAccesso = dataUltimoAccesso;
        this.attivo = attivo;
        this.bloccato = bloccato;
        this.numeroTentativi = numeroTentativi;
        this.idRuolo = idRuolo;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDataRegistrazione() {
        return dataRegistrazione;
    }

    public void setDataRegistrazione(LocalDate dataRegistrazione) {
        this.dataRegistrazione = dataRegistrazione;
    }

    public LocalDate getDataUltimoAccesso() {
        return dataUltimoAccesso;
    }

    public void setDataUltimoAccesso(LocalDate dataUltimoAccesso) {
        this.dataUltimoAccesso = dataUltimoAccesso;
    }

    public boolean isAttivo() {
        return attivo;
    }

    public void setAttivo(boolean attivo) {
        this.attivo = attivo;
    }

    public boolean isBloccato() {
        return bloccato;
    }

    public void setBloccato(boolean bloccato) {
        this.bloccato = bloccato;
    }

    public int getNumeroTentativi() {
        return numeroTentativi;
    }

    public void setNumeroTentativi(int numeroTentativi) {
        this.numeroTentativi = numeroTentativi;
    }

    public Long getIdRuolo() {
        return idRuolo;
    }

    public void setIdRuolo(Long idRuolo) {
        this.idRuolo = idRuolo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (int) (this.ID ^ (this.ID >>> 32));
        hash = 79 * hash + Objects.hashCode(this.nome);
        hash = 79 * hash + Objects.hashCode(this.cognome);
        hash = 79 * hash + Objects.hashCode(this.username);
        hash = 79 * hash + Objects.hashCode(this.email);
        hash = 79 * hash + Objects.hashCode(this.password);
        hash = 79 * hash + Objects.hashCode(this.dataRegistrazione);
        hash = 79 * hash + Objects.hashCode(this.dataUltimoAccesso);
        hash = 79 * hash + (this.attivo ? 1 : 0);
        hash = 79 * hash + (this.bloccato ? 1 : 0);
        hash = 79 * hash + this.numeroTentativi;
        hash = 79 * hash + Objects.hashCode(this.idRuolo);
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
        final accountEntity other = (accountEntity) obj;
        if (this.ID != other.ID) {
            return false;
        }
        if (this.attivo != other.attivo) {
            return false;
        }
        if (this.bloccato != other.bloccato) {
            return false;
        }
        if (this.numeroTentativi != other.numeroTentativi) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cognome, other.cognome)) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.dataRegistrazione, other.dataRegistrazione)) {
            return false;
        }
        if (!Objects.equals(this.dataUltimoAccesso, other.dataUltimoAccesso)) {
            return false;
        }
        if (!Objects.equals(this.idRuolo, other.idRuolo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "accountEntity{" + "ID=" + ID + ", nome=" + nome + ", cognome=" + cognome + ", username=" + username + ", email=" + email + ", password=" + password + ", dataRegistrazione=" + dataRegistrazione + ", dataUltimoAccesso=" + dataUltimoAccesso + ", attivo=" + attivo + ", bloccato=" + bloccato + ", numeroTentativi=" + numeroTentativi + ", idRuolo=" + idRuolo + '}';
    }

}
