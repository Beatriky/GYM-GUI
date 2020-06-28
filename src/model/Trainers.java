package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Trainers {
    private int trainerId;
    private String fnameT;
    private String lnameT;
    private String phoneT;
    private String emailT;
    private String feedbackT;
    private Integer ratingT;
    private Integer workhoursT;

    @Id
    @Column(name = "trainerId")
    public int getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    @Basic
    @Column(name = "fnameT")
    public String getFnameT() {
        return fnameT;
    }

    public void setFnameT(String fnameT) {
        this.fnameT = fnameT;
    }

    @Basic
    @Column(name = "lnameT")
    public String getLnameT() {
        return lnameT;
    }

    public void setLnameT(String lnameT) {
        this.lnameT = lnameT;
    }

    @Basic
    @Column(name = "phoneT")
    public String getPhoneT() {
        return phoneT;
    }

    public void setPhoneT(String phoneT) {
        this.phoneT = phoneT;
    }

    @Basic
    @Column(name = "emailT")
    public String getEmailT() {
        return emailT;
    }

    public void setEmailT(String emailT) {
        this.emailT = emailT;
    }

    @Basic
    @Column(name = "feedbackT")
    public String getFeedbackT() {
        return feedbackT;
    }

    public void setFeedbackT(String feedbackT) {
        this.feedbackT = feedbackT;
    }

    @Basic
    @Column(name = "ratingT")
    public Integer getRatingT() {
        return ratingT;
    }

    public void setRatingT(Integer ratingT) {
        this.ratingT = ratingT;
    }

    @Basic
    @Column(name = "workhoursT")
    public Integer getWorkhoursT() {
        return workhoursT;
    }

    public void setWorkhoursT(Integer workhoursT) {
        this.workhoursT = workhoursT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trainers trainers = (Trainers) o;
        return trainerId == trainers.trainerId &&
                Objects.equals(fnameT, trainers.fnameT) &&
                Objects.equals(lnameT, trainers.lnameT) &&
                Objects.equals(phoneT, trainers.phoneT) &&
                Objects.equals(emailT, trainers.emailT) &&
                Objects.equals(feedbackT, trainers.feedbackT) &&
                Objects.equals(ratingT, trainers.ratingT) &&
                Objects.equals(workhoursT, trainers.workhoursT);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trainerId, fnameT, lnameT, phoneT, emailT, feedbackT, ratingT, workhoursT);
    }
}
