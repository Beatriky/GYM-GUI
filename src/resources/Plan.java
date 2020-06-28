package resources;

public class Plan {
    String extype;
    String time;
    String diettype;
    String dietdet;

    public Plan(String exType, String time) {
        this.extype=exType;
        this.time=time;
    }

    public Plan() {
    }


    public String getExtype() {
        return extype;
    }

    public void setExtype(String extype) {
        this.extype = extype;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDiettype() {
        return diettype;
    }

    public void setDiettype(String diettype) {
        this.diettype = diettype;
    }

    public String getDietdet() {
        return dietdet;
    }

    public void setDietdet(String dietdet) {
        this.dietdet = dietdet;
    }


   /* public Plan(String extype, String time) {
        this.extype = extype;
        this.time = time;
       // this.diettype = diettype;
        //this.dietdet = dietdet;
    }*/

}
