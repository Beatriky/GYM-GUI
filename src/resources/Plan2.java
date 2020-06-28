package resources;

public class Plan2 extends Plan {

    @Override
    public String getDiettype() {
        return diettype;
    }

    @Override
    public void setDiettype(String diettype) {
        this.diettype = diettype;
    }

    @Override
    public String getDietdet() {
        return dietdet;
    }

    @Override
    public void setDietdet(String dietdet) {
        this.dietdet = dietdet;
    }

    String diettype;
    String dietdet;
    public Plan2(String diettype, String dietdet) {

        this.diettype=diettype;
        this.dietdet=dietdet;
    }


}
