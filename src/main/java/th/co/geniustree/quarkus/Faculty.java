package th.co.geniustree.quarkus;

import jakarta.validation.constraints.NotEmpty;

public class Faculty {
    @NotEmpty
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
