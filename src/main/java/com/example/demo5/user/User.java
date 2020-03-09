package com.example.demo5.user;

import com.example.demo5.persistance.model.AbstractBaseEntity;

import javax.persistence.*;
import java.util.Objects;
@Entity
public class User extends AbstractBaseEntity {
    private String name;

    //region Properties
    private String pass;
    //endregion

    public User(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public User() {
    }
    //region Getter and Setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    //endregion

    //region toString HashCode and equals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(pass, user.pass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, pass);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
    //endregion


}
