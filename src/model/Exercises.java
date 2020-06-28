package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Exercises {
    private int exId;
    private String exType;

    @Id
    @Column(name = "exId")
    public int getExId() {
        return exId;
    }

    public void setExId(int exId) {
        this.exId = exId;
    }

    @Basic
    @Column(name = "exType")
    public String getExType() {
        return exType;
    }

    public void setExType(String exType) {
        this.exType = exType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exercises exercises = (Exercises) o;
        return exId == exercises.exId &&
                Objects.equals(exType, exercises.exType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(exId, exType);
    }
}
