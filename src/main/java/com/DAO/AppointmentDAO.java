package com.DAO;

import com.Model.Appointment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/DoctorRV?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "admin";

    private static final String SELECT_ALL_APPOINTMENTS = "SELECT * FROM Appointment";
    private static final String INSERT_APPOINTMENT_SQL = "INSERT INTO Appointment (patient_id, doctor_id, Date, motif) VALUES (?, ?, ?, ?)";

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

    public List<Appointment> selectAllAppointments() {
        List<Appointment> appointments = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_APPOINTMENTS)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int patientId = rs.getInt("patient_id");
                int doctorId = rs.getInt("doctor_id");
                Date date = rs.getDate("Date");
                String motif = rs.getString("motif");

                appointments.add(new Appointment(id, patientId, doctorId, date, motif));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return appointments;
    }

    public void addAppointment(Appointment appointment) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_APPOINTMENT_SQL)) {
            preparedStatement.setInt(1, appointment.getPatientId());
            preparedStatement.setInt(2, appointment.getDoctorId());
            preparedStatement.setDate(3, appointment.getDate());
            preparedStatement.setString(4, appointment.getMotif());

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
    public void addAppointmentt(Appointment appointment) {
        String INSERT_APPOINTMENT_SQL = "INSERT INTO Appointment (patient_id, doctor_id, Date, motif) VALUES (?, ?, ?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_APPOINTMENT_SQL)) {
            preparedStatement.setInt(1, appointment.getPatientId());
            preparedStatement.setInt(2, appointment.getDoctorId());
            preparedStatement.setDate(3, appointment.getDate());
            preparedStatement.setString(4, appointment.getMotif());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

}

