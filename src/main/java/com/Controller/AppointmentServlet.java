//package com.Controller;
//
//import com.Model.Appointment;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//@WebServlet('/')
//public class AppointmentServlet extends HttpServlet {
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        try {
//            String dateString = request.getParameter("date");
//            String doctorName = request.getParameter("docId");
//            String patientName = request.getParameter("patient");
//            String motif = request.getParameter("motif");
//
//
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            Date date = sdf.parse(dateString);
//
//
//            Appointment appointment = new Appointment();
//            appointment.setDate(date);
//            appointment.setDoctorId(doctorName);
//            appointment.setPatientName(patientName);
//            appointment.setDescription(description);
//
//
//            AppointmentDAO appointmentDAO = new AppointmentDAO();
//            boolean isAdded = appointmentDAO.addAppointment(appointment);
//
//            if (isAdded) {
//                response.sendRedirect("appointmentSuccess.jsp");
//            } else {
//                response.sendRedirect("appointmentError.jsp");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            response.sendRedirect("appointmentError.jsp");
//        }
//    }
//}

package com.Controller;

import com.DAO.AppointmentDAO;
import com.Model.Appointment;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insertAppointment")
public class AppointmentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AppointmentDAO appointmentDAO;

    public void init() {
        appointmentDAO = new AppointmentDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {

                case "/TakeAppointmentServlet":
                    addAppointment(request, response);
                    break;
                default:

                    break;
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void addAppointment(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int patientId = Integer.parseInt(request.getParameter("patient_id"));
        int doctorId = Integer.parseInt(request.getParameter("doctor_id"));
//        LocalDate date = Date.parse(request.getParameter("appointmentDate"));
        String date = request.getParameter("appointmentDate");
        Date appointmentDate = Date.valueOf(date);
        String motif = request.getParameter("motif");



        response.sendRedirect("appointments");
    }

}

