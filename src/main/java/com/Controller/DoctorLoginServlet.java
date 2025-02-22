package com.Controller;

import com.DAO.DoctorDAO;
import com.Model.Appointment;
import com.Model.Doctor;
import com.Model.Patient;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/")
public class DoctorLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DoctorDAO doctorDAO;

    public void init() {
        doctorDAO = new DoctorDAO();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {

                case "/insertDoctor":
                    addAppointment(request,response);
                    break;
                default:
                    listDoctor(request, response);
                    break;
            }
        }catch(Exception e) {
            e.printStackTrace();
        }


    }
    private void addAppointment(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String usename = request.getParameter("username");
        String email = request.getParameter("email");
        int telephone = Integer.parseInt(request.getParameter("telephone"));
        String motif = request.getParameter("motif");
        String date = request.getParameter("appointmentDate");
        Date dt = Date.valueOf(date);
        int doctorid = Integer.parseInt(request.getParameter("doctorid"));
        doctorDAO = new DoctorDAO();
        Patient patient = new Patient(usename,email,telephone,dt);
        doctorDAO.addPatient(patient);
        Appointment appointment = new Appointment(patient,doctorid,dt,motif);
doctorDAO.addAppointment(appointment);





    }
    private void listDoctor(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List< Doctor > listDoctor = doctorDAO.selectAllDocters();
        request.setAttribute("listDoctor", listDoctor);
        RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
        dispatcher.forward(request, response);
    }



}
