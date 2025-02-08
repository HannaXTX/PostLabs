package Labs.Lab0;

import Labs.Lab0.ADT.MyList;
import Labs.LabSetup;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;


import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;


public class Lab0 extends LabSetup {


    int width = 900;
    int height = 300;
    Button btLoad, btAdd, btFind, btDel, btGetTotalM, btGetMaxFreq, btSortbyName;
    TextField tfAdd, tfFind, tfDel;

    Label lblTotal;

    public Lab0(String s) {
        super(s);
    }

    public void create() {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20,20,20,20));

        MyList<Name> list = new MyList<>(40);

        File file = new File("read.txt");

        DataFile df = new DataFile();

        btLoad = new Button(" Load ");
        grid.add(btLoad, 2, 1);
        fixNode(btLoad);
        btLoad.setOnAction(e -> {

            try {
                df.readFile(list, file);

            } catch (FileNotFoundException ex) {
                System.out.println("File not found");
            }
        });


        btAdd = new Button(" Add ");
        grid.add(btAdd, 1, 2);
        tfAdd = new TextField();
        fixNode(tfAdd);
        grid.add(tfAdd, 2, 2);

        tfAdd.setOnMouseClicked(e -> tfAdd.setText(""));


        btAdd.setOnAction(e -> {
            if (tfAdd.getText().isEmpty()) {
                tfAdd.setText("EMPTY");
            } else {
                try {

                    if (df.writeToFile(tfAdd.getText(), file, list)) {
                        tfAdd.setText("Added SuccessFully");
                    } else {
                        tfAdd.setText("Wrong Format");
                    }
                } catch (FileNotFoundException ex) {
                    System.out.println("File not found");

                }
            }
        });


        btFind = new Button(" Find ");
        grid.add(btFind, 1, 3);
        tfFind = new TextField();
        tfFind.setOnMouseClicked(e -> tfFind.setText(""));
        fixNode(tfFind);
        grid.add(tfFind, 2, 3);
        btFind.setOnAction(e -> {
            Name name1 = getNamefromList(list, tfFind.getText());
            if (list.find(name1))
                tfFind.setText(name1.getName() + " " + name1.getGender() + " " + name1.getFrequency());
            else
                tfFind.setText("False");


        });

        btDel = new Button(" Delete ");
        grid.add(btDel, 1, 4);
        tfDel = new TextField();
        tfDel.setOnMouseClicked(e -> tfDel.setText(""));
        fixNode(tfDel);
        grid.add(tfDel, 2, 4);
        btDel.setOnAction(e -> {
            list.remove(getNamefromList(list, tfDel.getText()));
            try {
                df.save(list, file);
                tfDel.setText("Removed SuccessFully");
            } catch (FileNotFoundException ex) {
                System.out.println("Couldn't save task");
            }
        });

        btGetTotalM = new Button("Total Males");
        grid.add(btGetTotalM, 3, 2);
        lblTotal = new Label("output");
        grid.add(lblTotal, 4, 2);
        btGetTotalM.setOnAction(e -> lblTotal.setText("Males : " + getTotal(list)));

        btGetMaxFreq = new Button("Highest recorded freq");
        grid.add(btGetMaxFreq, 3, 3);
        btGetMaxFreq.setOnAction(e -> lblTotal.setText("Most named : " + getMostNamed(list)));

        btSortbyName = new Button("Sort File by Name");
        grid.add(btSortbyName, 3, 4);
        btSortbyName.setOnAction(e -> {

            try {
                df.save(sortbyName(list), file);
                lblTotal.setText("Sorted!");
            } catch (FileNotFoundException ex) {
                System.out.println("file not found!");
            }
        });
        grid.setMinSize(300,300);
        grid.setHgap(30);
        grid.setVgap(30);
        grid.setAlignment(Pos.TOP_CENTER);
        setContent(grid);

    }

    public void fixNode(Node node) {
        if (node instanceof Button) {
            ((Button) node).setPrefSize(100, 30);
            node.setStyle("-fx-font-size: 18;");

        }

        if (node instanceof TextField) {
            ((TextField) node).setPrefSize(150, 20);

        }
    }

    public Name getNamefromList(MyList<Name> list, String name) {
        for (int i = 0; i < list.size(); i++) {

            if (list.get(i) == null)
                continue;

            if (name.compareTo(list.get(i).getName()) == 0) {
                System.out.println("Name Found!");
                return list.get(i);
            }
        }
        System.out.println(name + " is not in List!");

        return null;
    }

    public int getTotal(MyList<Name> list) {
        int totalM = 0;
        for (int i = 0; i < list.size(); i++)
            if (list.get(i).getGender() == 'M')
                totalM = totalM + list.get(i).getFrequency();

        return totalM;
    }

    public String getMostNamed(MyList<Name> list) {
        int max = 0;
        int index = 0;
        for (int i = 0; i < list.size(); i++)
            if (list.get(i).getFrequency() > max) {
                max = list.get(i).getFrequency();
                index = i;

            }

        return max == list.get(index).getFrequency() ? max + " " + list.get(index).getName() : null;

    }

    public MyList<Name> sortbyName(MyList<Name> nameList) {
        int size = nameList.size();
        System.out.println("Please wait about 10 seconds for sorting...   (was 5 mins because the comment below this message)");
        // System.out.println("Comparing " + i + " with " + j +" // output " + nameList.get(i).compareTo(nameList.get(j)));

        for (int i = 0; i < size; i++) {

            for (int j = i + 1; j < size; j++) {

                if (nameList.get(i).compareTo(nameList.get(j)) < 0)
                    continue;


                if (nameList.get(i).compareTo(nameList.get(j)) > 0) {
                    Name temp = nameList.get(i);
                    nameList.set(i, nameList.get(j));
                    nameList.set(j, temp);
                }

            }

        }

        System.out.println("Sorted Array and File!");
        return nameList;
    }
}

