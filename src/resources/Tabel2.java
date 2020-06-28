package resources;

public class Tabel2 {  //traineri
    int id;
    String name;
    String email;
    String hour;
    int rating;

    public Tabel2() {
        this.id= this.id;
    }

    public void Tabel2(int id){this.id=id;}
    public Tabel2(String name, String email, String hour, int rating) {

        this.name = name;
        this.email = email;
        this.hour = hour;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
    public Tabel2(int id, String name,int rating){
        this.id = id;
        this.name = name;
        this.rating = rating;
    }
    public Tabel2(int id, String name, String email, String hour, int rating) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.hour = hour;
        this.rating = rating;
    }
}
