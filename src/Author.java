

import java.io.Serializable;

public class Author implements Serializable {
    private String name;
    private String yearOfBirth;
    private String gender;

    public Author() {
    }
    public Author(String name, String yearOfBirth, String gender) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "author{" +
                "name:" + name + '\'' +
                ", yearOfBirth:'" + yearOfBirth + '\'' +
                ", gender:2" +
                "'" + gender + '\'' +
                '}';
    }
}
