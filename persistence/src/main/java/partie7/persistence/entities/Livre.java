package partie7.persistence.entities;// default package
// Generated 5 sept. 2021 20:06:27 by Hibernate Tools 6.0.0.Alpha5


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;



@Table
public class Livre implements java.io.Serializable {


    private int id;
    private String nom;
    private String langue;
    private int prix;

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public Livre() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livre livre = (Livre) o;
        return id == livre.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}


