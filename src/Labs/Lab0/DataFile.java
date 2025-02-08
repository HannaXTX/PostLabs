package Labs.Lab0;

import Labs.Lab0.ADT.MyList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;



public class DataFile {



    public void readFile(MyList<Name> nameList, File file) throws FileNotFoundException {
        //  nameList.clear();
        Scanner input = new Scanner(file);
        System.out.println("Beginning reading Procedure");
        while (input.hasNext()) {
            String[] split = input.nextLine().split(",");
            String name = split[0];
            char gender = split[1].charAt(0);
            int freq = Integer.parseInt(split[2]);

            try {
                nameList.add(new Name(name, gender, freq));
            } catch (IllegalArgumentException ex) {

            }

        }
        input.close();
        System.out.println("Reading DONE!");
    }

    public boolean writeToFile(String text, File file, MyList<Name> nameList) throws FileNotFoundException {


        PrintWriter printWriter = new PrintWriter(new FileOutputStream(file, true));

        String[] split = text.split(",");
        if (split.length == 3) {
            System.out.println("Writing....");
            String name = split[0];
            char gender = split[1].charAt(0);
            int freq = Integer.parseInt(split[2]);



            try {
                nameList.add(new Name(name, gender, freq));
                printWriter.println(name + "," + gender + "," + freq);
            } catch (IllegalArgumentException ex) {
                printWriter.close();
                return false;
            }
            printWriter.close();

            return true;

        }


        printWriter.close();

        return false;
    }

    public boolean save(MyList<Name> nameList, File file) throws FileNotFoundException {
        PrintWriter save = new PrintWriter(file);

        for (int i = 0; i < nameList.size(); i++) {
            if (nameList.get(i) == null)
                continue;

            String s = nameList.get(i).getName() + "," + nameList.get(i).getGender() + "," + nameList.get(i).getFrequency();
            save.println(s);

        }
        save.close();
        return true;
    }

}
