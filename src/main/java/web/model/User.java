package web.model;

import jakarta.validation.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name = "new_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    int id;
    @Column(name = "name")
    String name;
    @Column(name = "surname")
    String surName;

    public User(){};

    public User(int id,String name,String surName){
        this.id = id;
        this.name = name;
        this.surName = surName;
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

    public String getSurName() {
        return surName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    @Override
    public String toString() {
        return "UserId " +
                " = " + id +
                "\n name = '" + name + '\'' +
                "\n surName = '" + surName + '\'';
    }
}
