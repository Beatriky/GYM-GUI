package resources;

public class Notif {
    String notif;
    String fname;
    public String getNotif() {
        return notif;
    }

    public void setNotif(String notif) {
        this.notif = notif;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }


    public Notif(String notif, String fname) {
        this.notif = notif;
        this.fname = fname;
    }



}
