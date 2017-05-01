package fi.iki.mkuokkanen.undertowresteasy;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PersonJaxb {

    public String name;
    public int age;

    // Empty constructor for tools
    public PersonJaxb() {
    }

    public PersonJaxb(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
