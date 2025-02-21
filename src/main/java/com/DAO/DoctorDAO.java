package com.DAO;


    import com.Model.Doctor;

    import java.sql.*;
    import java.util.ArrayList;
    import java.util.List;

public class DoctorDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/DoctorRV?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "admin";
    private static final String SELECT_ALL_Doctor = "SELECT * FROM Doctor";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }
        public List< Doctor > selectAllDocters() {

            // using try-with-resources to avoid closing resources (boiler plate code)
            List < Doctor > doctors = new ArrayList< >();
            // Step 1: Establishing a Connection
            try (Connection connection = getConnection();

                 // Step 2:Create a statement using connection object
                 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_Doctor);) {
                System.out.println(preparedStatement);
                // Step 3: Execute the query or update query
                ResultSet rs = preparedStatement.executeQuery();

                // Step 4: Process the ResultSet object.
                while (rs.next()) {
                    int id = rs.getInt("docId");
                    String name = rs.getString("docUsername");
                    String password = rs.getString("password");
                    doctors.add(new Doctor(id, name, password));
                }
            } catch (SQLException e) {
                printSQLException(e);
            }
            System.out.println(doctors);
            return doctors;
        }
    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
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
    }


