package fi.mkuokkanen.webproto.springboot;


public class PersonJaxb {

    public String name;
    public int age;

    public PersonJaxb() {
    }

    public PersonJaxb(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
