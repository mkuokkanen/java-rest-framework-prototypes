package fi.mkuokkanen.webproto.dropwizard;


import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonJaxb {

    private String name;
    private int age;

    // Empty constructor for tools
    public PersonJaxb() {
    }

    public PersonJaxb(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    public int getAge() {
        return age;
    }
}
