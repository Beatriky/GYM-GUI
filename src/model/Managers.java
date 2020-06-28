package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Managers {
    private int managerId;
    private String fnameM;
    private String lnameM;
    private String phoneM;
    private String emailM;

    @Id
    @Column(name = "managerId")
    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    @Basic
    @Column(name = "fnameM")
    public String getFnameM() {
        return fnameM;
    }

    public void setFnameM(String fnameM) {
        this.fnameM = fnameM;
    }

    @Basic
    @Column(name = "lnameM")
    public String getLnameM() {
        return lnameM;
    }

    public void setLnameM(String lnameM) {
        this.lnameM = lnameM;
    }

    @Basic
    @Column(name = "phoneM")
    public String getPhoneM() {
        return phoneM;
    }

    public void setPhoneM(String phoneM) {
        this.phoneM = phoneM;
    }

    @Basic
    @Column(name = "emailM")
    public String getEmailM() {
        return emailM;
    }

    public void setEmailM(String emailM) {
        this.emailM = emailM;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Managers managers = (Managers) o;
        return managerId == managers.managerId &&
                Objects.equals(fnameM, managers.fnameM) &&
                Objects.equals(lnameM, managers.lnameM) &&
                Objects.equals(phoneM, managers.phoneM) &&
                Objects.equals(emailM, managers.emailM);
    }

    @Override
    public int hashCode() {
        return Objects.hash(managerId, fnameM, lnameM, phoneM, emailM);
    }
}
