package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Diets {
    private int dietId;
    private String dietType;

    public Diets(int dieId) {
    }

    @Id
    @Column(name = "dietId")
    public int getDietId() {
        return dietId;
    }

    public void setDietId(int dietId) {
        this.dietId = dietId;
    }

    @Basic
    @Column(name = "dietType")
    public String getDietType() {
        return dietType;
    }

    public void setDietType(String dietType) {
        this.dietType = dietType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Diets diets = (Diets) o;
        return dietId == diets.dietId &&
                Objects.equals(dietType, diets.dietType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dietId, dietType);
    }
}
