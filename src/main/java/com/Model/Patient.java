package com.Model;

import java.sql.Date;

public class Patient {
        private int id;
        private String username;
        private String email;
        private int telephone;
        Date date;


    public Patient(int id, String username, String email, int telephone, Date date) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.telephone = telephone;
        this.date = date;
    }

    public Patient(String username, String email, int telephone, Date date) {
        this.username = username;
        this.email = email;
        this.telephone = telephone;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", telephone=" + telephone +
                ", date=" + date +
                '}';
    }
}
