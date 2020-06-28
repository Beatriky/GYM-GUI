package resources;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TabelClienti1Test {
   private TabelClienti1 bea=new TabelClienti1("Beatrice","beamaria14@yahoo.com","Low Calorie Diet");
   private TabelClienti1 jaemin=new TabelClienti1(20,"Jaemin","Na","0748562390","jaemin@nct.com",5,"jaemin","15456","Platinum","No diet needed",34,0);
    @Test
    void testObjcreation(){

        assertEquals("Beatrice",bea.getFnameC());
        assertEquals("beamaria14@yahoo.com",bea.getEmailC());
        assertEquals("Low Calorie Diet",bea.getDietType());
    }


    @Test
    void getClientId() {
        assertEquals(20,jaemin.getClientId());

    }

    @Test
    public void setClientId() {
        jaemin.setClientId(4);
        assertNotNull(jaemin.getClientId());
    }

    @Test
    void getFnameC() {
        assertEquals("Jaemin",jaemin.getFnameC());
    }

    @Test
    void setFnameC() {
        jaemin.setFnameC("Jaeminie");
        assertNotNull(jaemin.getFnameC());
    }

    @Test
    void getLnameC() {
        assertEquals("Na",jaemin.getLnameC());
    }

    @Test
    void setLnameC() {
        jaemin.setFnameC("Nana");
        assertNotNull(jaemin.getLnameC());
    }

    @Test
    void getPhoneC() {
        assertEquals("0748562390",jaemin.getPhoneC());
    }

    @Test
    void setPhoneC() {
        bea.setPhoneC("0748562390");
        assertNotNull(bea.getPhoneC());
    }

    @Test
    void getEmailC() {
        assertEquals("beamaria14@yahoo.com",bea.getEmailC());
    }

    @Test
    void setEmailC() {
        bea.setPhoneC("beamaria@mail.com");
        assertNotNull(bea.getPhoneC());
    }

    @Test
    void getSubId() {
        assertNotNull(jaemin.getSubId());
    }

    @Test
    void setSubId() {
        jaemin.setSubId(4);
        assertNotNull(jaemin.getSubId());
    }

    @Test
    void getGymLoc() {
        assertNotNull(jaemin.getGymLoc());
    }

    @Test
    void setGymLoc() {
        jaemin.setGymLoc("Platinum");
        assertNotNull(jaemin.getGymLoc());
    }

    @Test
    void getDietType() {
        assertEquals("No diet needed",jaemin.getDietType());
    }

    @Test
    void setDietType() {
        jaemin.setDietType("Not neededed");
        assertNotNull(jaemin.getSubId());
    }

    @Test
    void getTrainerId() {
        assertNotNull(jaemin.getTrainerId());
    }

    @Test
    void setTrainerId() {
        jaemin.setTrainerId(32);
        assertNotNull(jaemin.getTrainerId());
    }

    @Test
    void getDietId() {
        assertEquals(0,jaemin.getDietId());
    }

    @Test
    void setDietId() {
        jaemin.setDietId(0);
        assertNotNull(jaemin.getDietId());
    }
}