package Labs;

import javafx.scene.control.Tab;

public abstract class LabSetup extends Tab {

    public LabSetup(String s){
        this.setText(s);
        this.create();
    }

public abstract void create();
}
