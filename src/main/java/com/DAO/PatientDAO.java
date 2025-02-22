package com.DAO;

import com.Model.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/DoctorRV?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "admin";
    private static final String SELECT_ALL_PATIENTS = "SELECT * FROM Patient";
    private static final String INSERT_PATIENT_SQL = "INSERT INTO Patient (usename, email, telephone, motif) VALUES (?, ?, ?, ?)";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public List<Patient> selectAllPatients() {
        List<Patient> patients = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PATIENTS)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("usename");
                String email = rs.getString("email");
                int telephone = rs.getInt("telephone");
                String motif = rs.getString("motif");

            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return patients;
    }

    public void addPatient(Patient patient) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PATIENT_SQL)) {
            preparedStatement.setString(1, patient.getUsername());
            preparedStatement.setString(2, patient.getEmail());
            preparedStatement.setInt(3, patient.getTelephone());


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
    public int getPatientIdByUsername(String username) {
        int id = -1;
        String query = "SELECT id FROM Patient WHERE usename = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

}

