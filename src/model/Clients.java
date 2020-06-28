package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Clients {
    private int clientId;
    private String fnameC;
    private String lnameC;
    private String phoneC;
    private String emailC;
    private Integer subId;
    private String usernameC;
    private String passwordC;
    private String gymLoc;


    private String dietType;
    private Integer trainerId,dietId;



    public Clients(String fnameC, String emailC, String dietType) {
        this.fnameC = fnameC;
        this.emailC=emailC;
        this.dietType = dietType;
    }

    public Clients(String fnameC) {  this.fnameC = fnameC;
    }

    @Id
    @Column(name = "clientId")
    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Basic
    @Column(name = "fnameC")
    public String getFnameC() {
        return fnameC;
    }

    public void setFnameC(String fnameC) {
        this.fnameC = fnameC;
    }

    @Basic
    @Column(name = "lnameC")
    public String getLnameC() {
        return lnameC;
    }

    public void setLnameC(String lnameC) {
        this.lnameC = lnameC;
    }

    @Basic
    @Column(name = "phoneC")
    public String getPhoneC() {
        return phoneC;
    }

    public void setPhoneC(String phoneC) {
        this.phoneC = phoneC;
    }

    @Basic
    @Column(name = "emailC")
    public String getEmailC() {
        return emailC;
    }

    public void setEmailC(String emailC) {
        this.emailC = emailC;
    }

    @Basic
    @Column(name = "subId")
    public Integer getSubId() {
        return subId;
    }

    public void setSubId(Integer subId) {
        this.subId = subId;
    }

    @Basic
    @Column(name = "usernameC")
    public String getUsernameC() {
        return usernameC;
    }

    public void setUsernameC(String usernameC) {
        this.usernameC = usernameC;
    }

    @Basic
    @Column(name = "passwordC")
    public String getPasswordC() {
        return passwordC;
    }

    public void setPasswordC(String passwordC) {
        this.passwordC = passwordC;
    }

    @Basic
    @Column(name = "gymLoc")
    public String getGymLoc() {
        return gymLoc;
    }

    public void setGymLoc(String gymLoc) {
        this.gymLoc = gymLoc;
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

    public void setDietId(int dietId) {
        this.dietId = dietId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clients clients = (Clients) o;
        return clientId == clients.clientId &&
                Objects.equals(fnameC, clients.fnameC) &&
                Objects.equals(lnameC, clients.lnameC) &&
                Objects.equals(phoneC, clients.phoneC) &&
                Objects.equals(emailC, clients.emailC) &&
                Objects.equals(subId, clients.subId) &&
                Objects.equals(usernameC, clients.usernameC) &&
                Objects.equals(passwordC, clients.passwordC) &&
                Objects.equals(gymLoc, clients.gymLoc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, fnameC, lnameC, phoneC, emailC, subId, usernameC, passwordC, gymLoc);
    }


    public void setNewDietId(Integer newValue) {
        this.dietId=newValue;
    }
}
