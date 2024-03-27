package Manager;

import Labs.Lab0.Lab0;
import Labs.Lab1.Lab1;
import Labs.Lab2.Lab2;
import Labs.Lab3.Lab3;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tab;

public class CustomTab extends TabPane {
    TabPane tpTabs; //Main Tab Pane

    public CustomTab() {

        tpTabs = new TabPane();

        CreateLabs(tpTabs);

    }

    public TabPane getTpTabs() {
        return tpTabs;
    }

    public Tab get(String tabname) {
        for (Tab tabs : tpTabs.getTabs()) {
            if (tabname.compareTo(tabs.getText()) == 0)

                return tabs;
        }
        return null;
    }

    public Tab getEachTab(int i) {
        return tpTabs.getTabs().get(i);
    }

    public void CreateLabs(TabPane tpTabs) {

        tpTabs.getTabs().add(new Lab0("Lab 0"));
        tpTabs.getTabs().add(new Lab1("Lab 1"));
        tpTabs.getTabs().add(new Lab2("Lab 2"));
        tpTabs.getTabs().add(new Lab3("Lab 3"));
        tpTabs.setPrefWidth(100);

    }



}
