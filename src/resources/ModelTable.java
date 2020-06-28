package resources;

public class ModelTable {
    String name;
    String hour;
    String feedback;

    public ModelTable(String fnameC, String string) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }



    public ModelTable(String name, String hour, String feedback) {
        this.name = name;
        this.feedback = feedback;
        this.hour = hour;
    }



}
