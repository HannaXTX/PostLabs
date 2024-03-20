package Labs.Lab0;

public class Name implements Comparable<Name> {

    private String name;
    private char gender;
    private int frequency;

    public Name() {
        super();
    }

    public Name(String name, char gender, int frequency) {
        super();

            setName(name);
            setGender(gender);
            setFrequency(frequency);


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) throws IllegalArgumentException {
        if (gender == 'M' || gender == 'F') {
            this.gender = gender;
        } else {

            System.out.println("Gender must be either M or F");
            throw new IllegalArgumentException();
        }
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        if (frequency > 0)
            this.frequency = frequency;
        else {
            System.out.println("Frequency has to be above 0");
            throw new IllegalArgumentException();
        }
    }

    @Override
    public int compareTo(Name o) {

        return this.getName().compareTo(o.getName());
    }


}
