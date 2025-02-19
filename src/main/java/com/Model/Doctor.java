package com.Model;


public class Doctor {
    private int docId;
    private String docUsername;
    private int password;

    public Doctor(int docId, String docUsername, int password) {
        this.docId = docId;
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

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
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