package Labs.Lab9;

import Labs.LabSetup;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import jdk.swing.interop.SwingInterOpUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab9 extends LabSetup {
    private OHash<Martyr> linearMartyr = new OHash<>(23);
    private OHash<Martyr> QuadMartyr = new OHash<>(23);
    private OHash<Martyr> doubleMartyr = new OHash<>(23);
    private SHash<Martyr> SeparateMartyr = new SHash<>(23);

    public Lab9(String s) {
        super(s);

    }

    @Override
    public void create() {
        Button btLoad = new Button("Load");
        Button btTraverse = new Button("Traverse");
        Button btGetAverage = new Button("get Average");

//        Label nameLabel = new Label("Name:");
//        Label ageLabel = new Label("Age:");
//        Label genderLabel = new Label("Gender:");
//        Label dateLabel = new Label("Date:");

        TextField nameField = new TextField();
        TextField ageField = new TextField();
        TextField genderField = new TextField();
        TextField dateField = new TextField();

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setHgap(10);
        grid.setVgap(10);


        grid.add(btLoad, 1, 0);
        grid.add(btTraverse, 2, 0);
        grid.add(btGetAverage, 3, 0);
        //    grid.add(nameLabel, 0, 1);
        grid.add(nameField, 1, 1);
        //      grid.add(ageLabel, 0, 2);
        grid.add(ageField, 1, 2);
//        grid.add(genderLabel, 0, 3);
        grid.add(genderField, 1, 3);
//        grid.add(dateLabel, 0, 4);
        grid.add(dateField, 1, 4);

        setContent(grid);


        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose a file");
        fileChooser.setInitialDirectory(new File("C:\\Users"));

        btLoad.setOnAction(e -> {
            try {
                File file = fileChooser.showOpenDialog(new Stage());


                if (file == null || !file.getName().contains("csv")) {
                    try {
                        throw new FileNotFoundException();
                    } catch (FileNotFoundException e1) {
                        throw new RuntimeException(e1);
                    }
                }
                System.out.println(file.getName() + " Found! \nReading...");

                read(file);


                System.out.println("Reading Successful");

            } catch (Exception ex) {
                System.out.println("error");
            }
        });


        btGetAverage.setOnAction(e -> {
            System.out.println("AVERAGE IS " + getAverage());
        });

        btTraverse.setOnAction(event -> {
            linearMartyr.traverse();
            QuadMartyr.traverse();
            doubleMartyr.traverse();
            SeparateMartyr.traverse();
        });
    }

    public void read(File file) throws FileNotFoundException {

        int count = 0;
        System.out.println(file);
        Scanner input = new Scanner(file);
        input.nextLine();

        while (input.hasNextLine()) {
            String row = input.nextLine();
            String[] data = row.split(",");
            try {
                String name = data[0];
                String Date = data[1];
                int age = Integer.parseInt(data[2].trim());
                String LocationName = data[3];
                String DistrictName = data[4];
                char Gender = data[5].charAt(0);
                Martyr mar = new Martyr(name, Date, age, LocationName, DistrictName, Gender);

                linearMartyr.addLinear(mar);
                QuadMartyr.addQuadratic(mar);
                doubleMartyr.addDoubleHash(mar);
                SeparateMartyr.add(mar);

                System.out.println(count + " " + mar.getName() + mar.getDate() + " " + mar.getLocationName() + " " + mar.getDistrictName());
                count++;

            } catch (NumberFormatException ex) {
                System.out.println("Error ADDING THIS ENTRY.");
                input.nextLine();
            }
        }
    }

    public int getAverage() {
        int n = 0;
        int m = 0;
        for (SingleLinkedList<Martyr> martyrs : SeparateMartyr.table) {

            n = n + martyrs.size();
            m++;
        }
        return m == 0 ? n : n / m;
    }
}
