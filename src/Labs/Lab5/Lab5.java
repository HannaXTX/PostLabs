package Labs.Lab5;

import Labs.Lab4.MyCursorArray;
import Labs.LabSetup;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Lab5 extends LabSetup {

    public Lab5(String s) {
        super(s);
    }

    Labs.Lab4.MyCursorArray<Integer> list = new MyCursorArray<>(15);
    Button btPretoPost, btIntoPost;
    TextField tfData;
    Label lblOutput;
    int width = 700, height = 500;

    CursorStack<String> stack = new CursorStack<>();



    @Override
    public void create() {

        ShapeGrid();

        btIntoPost.setOnAction(e->{
            lblOutput.setText(Driver.inToPost(tfData.getText()));
        });

        btPretoPost.setOnAction(e->{
            lblOutput.setText((Driver.preToPost(tfData.getText())));
        });


    }


    public void ShapeGrid() {
        GridPane grid = new GridPane(width / 10, height / 10);
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setHgap(20);
        grid.setVgap(20);

        grid.setAlignment(Pos.TOP_CENTER);


        grid.add(lblOutput = new Label("Input data in each field"), 4, 3);
        grid.add(btPretoPost = new Button("PREFIX TO POSTFIX"), 0, 2);

        grid.add(btIntoPost = new Button("INFIX TO POSTFIX"), 2, 2);

        grid.add(tfData = new TextField(""), 3, 2);


        setContent(grid);
    }
}
