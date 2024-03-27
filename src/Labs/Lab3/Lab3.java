package Labs.Lab3;

import Labs.Lab3.MyDoublyLinkedList;
import Labs.LabSetup;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Lab3 extends LabSetup {
    public Lab3(String s) {
        super(s);
    }

    MyDoublyLinkedList<Integer> list = new MyDoublyLinkedList<>();
    Button btInsert, btDelete, btRemoveDuplicate, btReverse;
    TextField tfData;
    Label lblOutput;
    int width = 700, height = 500;

    @Override
    public void create() {
        ShapeGrid();
        Events();


    }

    public void Events() {

        btInsert.setOnAction(e -> {
            String[] data = tfData.getText().split(" ");
            for (int i = 0; i < data.length; i++)
                list.insert(Integer.parseInt(data[i].trim()));
            list.traverse();
            tfData.setText("");
        });

        btRemoveDuplicate.setOnAction(e -> {
            list.removeDuplicaterec();
            list.traverse();
        });


        btDelete.setOnAction(e -> {
            try {
                list.delete(Integer.parseInt(tfData.getText()));
                list.traverse();
            } catch (NullPointerException ex) {
                lblOutput.setText("Please make sure the list isn't empty");
            }


        });

        btReverse.setOnAction(e -> {
            list.recursiveReverse();
            list.traverse();
        });


    }

    public void ShapeGrid() {
        GridPane grid = new GridPane(width / 10, height / 10);
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setHgap(20);
        grid.setVgap(20);

        grid.setAlignment(Pos.TOP_CENTER);

        grid.add(lblOutput = new Label("Input data in each field"), 4, 2);
        grid.add(btInsert = new Button("Insert"), 0, 2);
        grid.add(btRemoveDuplicate = new Button("Remove Duplicates"), 1, 2);
        grid.add(btDelete = new Button("Delete"), 2, 2);
        grid.add(btReverse = new Button("Reverse"), 3, 3);

        grid.add(tfData = new TextField(""), 3, 2);


        setContent(grid);
    }
}
