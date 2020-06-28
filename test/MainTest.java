import application.Main;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import static javafx.application.Application.launch;

public class MainTest {
    @Test

    public void start(Stage primaryStage) throws Exception {
    }

    @BeforeClass
    public static void initJFX() {
        Thread t = new Thread("JavaFX Init Thread") {
            public void run() {
                launch(Main.class, new String[0]);
            }
        };
        t.setDaemon(true);
        t.start();
        System.out.printf("FX App thread started\n");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {  System.out.println("Prob la test ceva cu sleep-main");
            e.printStackTrace();
        }
    }


}