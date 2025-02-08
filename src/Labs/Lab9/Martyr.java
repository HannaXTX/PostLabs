package Labs.Lab9;

public class Martyr implements Comparable<Martyr> {


    public Martyr(String name, String date, int age, String locationName, String districtName, char gender) {
        setName(name);
        setDate(date);
        setAge(age);
        setLocationName(locationName);
        setDistrictName(districtName);
        setGender(gender);
    }

    private String name;
    private String date;
    private int age;
    private String locationName;
    private String district;
    private char gender;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() > 0)
            this.name = name;

        else throw new IllegalArgumentException();

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        String[] split = date.split("/");

        int month = Integer.parseInt(split[0]);
        int day = Integer.parseInt(split[1]);
        int year = Integer.parseInt(split[2]);
        if ((split.length == 3) && (year > 1900 && year < 2100) && (month >= 1 && month <= 12) && (day >= 1 && day <= 31)) {
            this.date = date;
        } else throw new IllegalArgumentException();


    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0 && age < 121)
            this.age = age;
        else throw new NumberFormatException();
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String location) {
        this.locationName = location;
    }

    public String getDistrictName() {
        return district;
    }

    public void setDistrictName(String district) {
        this.district = district;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        if (Character.toLowerCase(gender) == 'm' || Character.toLowerCase(gender) == 'f')
            this.gender = Character.toUpperCase(gender);

        else throw new IllegalArgumentException();

    }

    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Martyr o) {
        if (this.gender != o.gender && (this.age - o.age == 0))
            return String.valueOf(this.gender).compareTo(String.valueOf(o.gender));

        return this.age - o.age;
    }

    @Override
    public int hashCode() {
        int hash = 11;
        hash = 23 * hash + name.hashCode();
        hash = 23 * hash + date.hashCode();

        return hash;
    }
}
