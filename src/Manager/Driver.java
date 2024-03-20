package Manager;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Driver extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        CustomTab Tabs = new CustomTab();

        Scene scene = new Scene(Tabs.getTpTabs(),900,300);
        stage.setScene(scene);
        stage.setTitle("LABS");
        stage.show();
    }
}
