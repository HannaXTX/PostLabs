package Labs.Lab4;

import Labs.Lab3.MyDoublyLinkedList;
import Labs.LabSetup;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Lab4 extends LabSetup {
    public Lab4(String s) {
        super(s);
    }

    MyCursorArray<Integer> list = new MyCursorArray<>(15);
    Button btInsert, btDelete, btMerge, btCreateList;
    TextField tfData, tfList;
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
                list.insert(Integer.parseInt(data[i].trim()), Integer.parseInt(tfList.getText()));
            list.traversList(Integer.parseInt(tfList.getText()));
            tfData.setText("");
        });

        btMerge.setOnAction(e -> {
            String[] data = tfData.getText().split(" ");
            list.merge(Integer.parseInt(data[0].trim()),Integer.parseInt(data[1].trim()));
            list.traversList(Integer.parseInt(data[0].trim()));
        });


        btDelete.setOnAction(e -> {
            try {


            } catch (NullPointerException ex) {
                lblOutput.setText("Please make sure the list isn't empty");
            }


        });

        btCreateList.setOnAction(e -> System.out.println("Newly created list symbol is " + list.createList()));


    }

    public void ShapeGrid() {
        GridPane grid = new GridPane(width / 10, height / 10);
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setHgap(20);
        grid.setVgap(20);

        grid.setAlignment(Pos.TOP_CENTER);

        grid.add(lblOutput = new Label("Input data in each field // InsertSorted working,merge sorted not"), 4, 3);
        grid.add(btInsert = new Button("Insert"), 0, 2);
        grid.add(btMerge = new Button("Merge"), 1, 2);
        grid.add(btDelete = new Button("Delete"), 2, 2);
        grid.add(btCreateList = new Button("Create List"), 3, 3);

        grid.add(tfList = new TextField(), 4, 2);
        tfList.setMaxWidth(30);

        grid.add(tfData = new TextField(""), 3, 2);


        setContent(grid);
    }
}
