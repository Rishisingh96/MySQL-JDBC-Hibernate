package DB.Hibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//@Entity(name="student_details")
//@Table(name="mystudents")
@Entity
public class Student {
    @Id
    private int id;
    private String name;
    private String city;
    private Certificate certificaet;

    public Student(int id, String name, String city) {
        super();
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public Student(){  //default constructor
        super();

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Certificate getCertificaet() {
        return certificaet;
    }

    public void setCertificaet(Certificate certificaet) {
        this.certificaet = certificaet;
    }

    @Override
    public String toString() {
        return this.id+ " : "+this.name + ":" + this.city;
    }
}
