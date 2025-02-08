package Labs.Lab6;

import Labs.LabSetup;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Lab6 extends LabSetup {
    public Lab6(String s) {
        super(s);
    }
Button btRun;
    @Override
    public void create() {  // Create a Text node with a long string
        VBox grid = new VBox(20);

        ScrollPane scrollPane = new ScrollPane();
        Text text = new Text(" ");
        text.setWrappingWidth(900);


        // Create a ScrollPane and set the text as its content
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setContent(text);
        grid.getChildren().addAll(btRun = new Button("Run"),scrollPane);
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(20,20,20,20));
        setContent(grid);



        btRun.setOnAction(e->{

           text.setText( Driver.CustomerRun());
           text.resize(18,18);
        });


    }


}
