package com.Model;

import java.sql.Date;

public class Appointment {
    private int id;
    private int patientId;
    private int doctorId;
    private Date date;
    private String motif;

    public Appointment(int id, int patientId, int doctorId, Date date, String motif) {
        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
        this.motif = motif;
    }

    public Appointment(int patientId, int doctorId, Date date, String motif) {

        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
        this.motif = motif;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", patientId=" + patientId +
                ", doctorId=" + doctorId +
                ", date=" + date +
                ", motif='" + motif + '\'' +
                '}';
    }
}
