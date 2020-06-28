package controllers;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTestTest {
    private  ControllerTest rocky=new ControllerTest(("Rocky"));
    @Test
    void getName() {
        ControllerTest ladybug=new ControllerTest(("Ladybug"));
        assertEquals("Ladybug",ladybug.getName());
    }

    @Test
    void testHappy(){
    ControllerTest ladybug=new ControllerTest(("Ladybug"));
    assertFalse(ladybug.isHappy());
    }

    @Test
    void testHappyAfterPlay() {
        rocky.playWith();
        assertTrue(rocky.isHappy());
    }
    /*@Ignore("Exception throwing not yet defined")
    @Test
    public void nameFail(){
        rocky.playWith();
        String msj=rocky.getHappyMessage();
        assertEquals("I'm happy!",msj);  */

    @Test
    public void name(){
        rocky.playWith();
        String msj=rocky.getHappyMessage();
        assertEquals("I'm happy!",msj);
    }

}