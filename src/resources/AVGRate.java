package resources;

public class AVGRate {

    public AVGRate(int id,int rate) {
        this.rate = rate;
        this.id=id;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int rate,id;


}
