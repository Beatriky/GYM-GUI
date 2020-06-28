package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Subscription {
    private int subId;
    private Integer trainerId;
    private Integer dietId;
    private Integer gymId;
    private Integer exId;

    @Id
    @Column(name = "subId")
    public int getSubId() {
        return subId;
    }

    public void setSubId(int subId) {
        this.subId = subId;
    }

    @Basic
    @Column(name = "trainerId")
    public Integer getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Integer trainerId) {
        this.trainerId = trainerId;
    }

    @Basic
    @Column(name = "dietId")
    public Integer getDietId() {
        return dietId;
    }

    public void setDietId(Integer dietId) {
        this.dietId = dietId;
    }

    @Basic
    @Column(name = "gymId")
    public Integer getGymId() {
        return gymId;
    }

    public void setGymId(Integer gymId) {
        this.gymId = gymId;
    }

    @Basic
    @Column(name = "exId")
    public Integer getExId() {
        return exId;
    }

    public void setExId(Integer exId) {
        this.exId = exId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscription that = (Subscription) o;
        return subId == that.subId &&
                Objects.equals(trainerId, that.trainerId) &&
                Objects.equals(dietId, that.dietId) &&
                Objects.equals(gymId, that.gymId) &&
                Objects.equals(exId, that.exId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subId, trainerId, dietId, gymId, exId);
    }
}
