package Labs.Lab1;

import Labs.LabSetup;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.Arrays;

public class Lab1 extends LabSetup {

    Label lblOutput;
    Button btSum, btBinarySearch, btReverse;
    TextField tfInsert, tfBinarySearch, tfReverse, tfKey;
    int width = 700, height = 500;

    public Lab1(String s) {
        super(s);
    }

    public void create() {
        recursion rec = new recursion();

        ShapeGrid();

        btSum.setOnAction(e -> {
            willClear(tfInsert);
            try {
                Integer.parseInt(tfInsert.getText());
                lblOutput.setText("Answer is " + recursion.sumofsumdigit(Integer.parseInt(tfInsert.getText())));
            } catch (Exception ex) {
                tfInsert.setText("Error");
            }

        });

        btBinarySearch.setOnAction(e -> {
            try {
                willClear(tfKey);
                willClear(tfBinarySearch);
                String[] splitter = tfBinarySearch.getText().split(" ");
                int[] array = new int[splitter.length];
                for (int i = 0; i < array.length; i++) {
                    array[i] = Integer.parseInt(splitter[i]);
                }
                Arrays.sort(array);
                int result = BinarySearch.binarySearch(array, Integer.parseInt(tfKey.getText()), 0, array.length - 1);
                lblOutput.setText("Result is " + result);
            } catch (Exception ex) {
                lblOutput.setText("Error make sure you add the numbers and the key like this (n1 n2 n3 n4 n5 n6...) ");
            }

        });

        btReverse.setOnAction(e -> {
            willClear(tfReverse);
            try {
                String result = rec.reverseText(tfReverse.getText());
                lblOutput.setText("Result is " + result);
            } catch (Exception ex) {
                lblOutput.setText("Error");
            }


        });


    }


    public void ShapeGrid() {
        GridPane grid = new GridPane(width / 10, height / 10);
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setHgap(20);
        grid.setVgap(20);
        setContent(grid);


        grid.setAlignment(Pos.TOP_CENTER);

        grid.add(lblOutput = new Label("Input data in each field"), 4, 1);


        grid.add(btSum = new Button("get Sum"), 2, 2);
        grid.add(tfInsert = new TextField(""), 3, 2);

        grid.add(btBinarySearch = new Button("Search"), 2, 3);
        grid.add(tfBinarySearch = new TextField(""), 3, 3);

        grid.add(tfKey = new TextField(""), 4, 3);
        tfKey.setMaxWidth(30);

        grid.add(btReverse = new Button("Reverse"), 2, 4);
        grid.add(tfReverse = new TextField(""), 3, 4);


    }

    public void willClear(TextField text) {
        text.setOnMouseClicked(e -> text.setText(""));
    }
}
