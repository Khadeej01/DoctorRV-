package com.DAO;

import com.Model.Appointment;
import com.Model.Doctor;
import com.Model.Patient;

import java.sql.*;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/DoctorRV";
    private static final String USER = "root";
    private static final String PASSWORD = "";


    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public void addPatient(Patient patient) {
        String sql = "INSERT INTO Patient (usename, Email, telephone, motif) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, patient.getUsername());
            stmt.setString(2, patient.getEmail());
            stmt.setInt(3, patient.getTelephone());
            stmt.setString(4, patient.getMotif());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//    public Patient getPatientById(int id) {
//        String sql = "SELECT * FROM Patient WHERE id = ?";
//        Patient patient = null;
//
//        try (Connection conn = DBConnection.getConnection();
//             PreparedStatement stmt = conn.prepareStatement(sql)) {
//
//            stmt.setInt(1, id);
//            ResultSet rs = stmt.executeQuery();
//
//            if (rs.next()) {
//                patient = new Patient(rs.getInt("id"), rs.getString("usename"),
//                        rs.getString("email"), rs.getInt("telephone"), rs.getString("motif"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return patient;
//    }
//
//
//
//    public void addAppointment(Appointment appointment) {
//        String sql = "INSERT INTO Appointment (patient_id, doctor_id, Date, motif) VALUES (?, ?, ?, ?)";
//
//        try (Connection conn = DBConnection.getConnection();
//             PreparedStatement stmt = conn.prepareStatement(sql)) {
//
//            stmt.setInt(1, appointment.getPatientId());
//            stmt.setInt(2, appointment.getDoctorId());
//            stmt.setDate(3, java.sql.Date.valueOf(appointment.getDate()));
//            stmt.setString(4, appointment.getMotif());
//
//            stmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
//
//
//
//
//
