package resources;

public class TabelClienti1 {

    private int clientId;
    private String fnameC;
    private String lnameC;
    private String phoneC;

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getFnameC() {
        return fnameC;
    }

    public void setFnameC(String fnameC) {
        this.fnameC = fnameC;
    }

    public String getLnameC() {
        return lnameC;
    }

    public void setLnameC(String lnameC) {
        this.lnameC = lnameC;
    }

    public String getPhoneC() {
        return phoneC;
    }

    public void setPhoneC(String phoneC) {
        this.phoneC = phoneC;
    }

    public String getEmailC() {
        return emailC;
    }

    public void setEmailC(String emailC) {
        this.emailC = emailC;
    }

    public Integer getSubId() {
        return subId;
    }

    public void setSubId(Integer subId) {
        this.subId = subId;
    }

    public String getGymLoc() {
        return gymLoc;
    }

    public void setGymLoc(String gymLoc) {
        this.gymLoc = gymLoc;
    }

    public String getDietType() {
        return dietType;
    }

    public void setDietType(String dietType) {
        this.dietType = dietType;
    }

    public Integer getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Integer trainerId) {
        this.trainerId = trainerId;
    }

    public Integer getDietId() {
        return dietId;
    }

    public void setDietId(Integer dietId) {
        this.dietId = dietId;
    }

    private String emailC;
    private  Integer subId;
    private String usernameC;
    private String passwordC;
    private String gymLoc;
    private String dietType;
    private Integer trainerId, dietId;

    public TabelClienti1(String fnameC, String emailC, String dietType) {
        this.fnameC = fnameC;
        this.emailC = emailC;
        this.dietType = dietType;

    } public void Clientfull(int clientId, String fnameC, String lnameC, String phoneC, String emailC, Integer subId, String usernameC, String passwordC, String gymLoc, String dietType, Integer trainerId, Integer dietId) {
        this.clientId = clientId;
        this.fnameC = fnameC;
        this.lnameC = lnameC;
        this.phoneC = phoneC;
        this.emailC = emailC;
        this.subId = subId;
        this.usernameC = usernameC;
        this.passwordC = passwordC;
        this.gymLoc = gymLoc;
        this.dietType = dietType;
        this.trainerId = trainerId;
        this.dietId = dietId;
    }
    public  TabelClienti1(int clientId, String fnameC, String lnameC, String phoneC, String emailC, Integer subId, String usernameC, String passwordC, String gymLoc, String dietType, Integer trainerId, Integer dietId) {
        this.clientId = clientId;
        this.fnameC = fnameC;
        this.lnameC = lnameC;
        this.phoneC = phoneC;
        this.emailC = emailC;
        this.subId = subId;
        this.usernameC = usernameC;
        this.passwordC = passwordC;
        this.gymLoc = gymLoc;
        this.dietType = dietType;
        this.trainerId = trainerId;
        this.dietId = dietId;
    }
}

