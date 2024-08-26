package th.co.geniustree.quarkus;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.List;

public class Student {
    @NotEmpty
    public String name;
    @Valid
    public List<@NotEmpty String> subjects = new ArrayList<>(); //<list item>

    @Valid
    private Faculty faculty = new Faculty();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSubjects() {
        if (subjects == null) {
            this.subjects = new ArrayList<>();
        }
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", subjects=" + subjects +
                ", faculty=" + faculty +
                '}';
    }
}
