package com.Model;

import java.sql.Date;

public class Appointment {
    private int id;
    Patient patient;
    private int doctorId;
    private Date date;
    private String motif;

    public Appointment(int id, Patient patient, int doctorId, Date date, String motif) {
        this.id = id;
        this.patient = patient;
        this.doctorId = doctorId;
        this.date = date;
        this.motif = motif;
    }

    public Appointment(Patient patient, int doctorId, Date date, String motif) {
        this.patient = patient;
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

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
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
                ", patient=" + patient +
                ", doctorId=" + doctorId +
                ", date=" + date +
                ", motif='" + motif + '\'' +
                '}';
    }
}
