package com.Model;


public class Doctor {
    private int docId;
    private String docUsername;
    private String password;

    public Doctor(int docId, String docUsername, String password) {
        this.docId = docId;
        this.docUsername = docUsername;
        this.password = password;
    }
    public Doctor( String docUsername, String password) {

        this.docUsername = docUsername;
        this.password = password;
    }


    public int getDocId() {
        return docId;
    }

    public void setDocId(int docId) {
        this.docId = docId;
    }

    public String getDocUsername() {
        return docUsername;
    }

    public void setDocUsername(String docUsername) {
        this.docUsername = docUsername;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "docId=" + docId +
                ", docUsername='" + docUsername + '\'' +
                ", password=" + password +
                '}';
    }
}