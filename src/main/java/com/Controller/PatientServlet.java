package com.Controller;

import com.DAO.PatientDAO;
import com.Model.Patient;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/patient")
public class PatientServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PatientDAO patientDAO;

    public void init() {
        patientDAO = new PatientDAO();
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
                case "/newPatient":
                    showNewForm(request, response);
                    break;
                case "/insertPatient":
                    insertPatient(request, response);
                    break;
                default:
                    listPatients(request, response);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void listPatients(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Patient> listPatients = patientDAO.selectAllPatients();
        request.setAttribute("listPatients", listPatients);
        RequestDispatcher dispatcher = request.getRequestDispatcher("patient-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("patient-form.jsp");
        dispatcher.forward(request, response);
    }

    private void insertPatient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        int telephone = Integer.parseInt(request.getParameter("telephone"));
        String motif = request.getParameter("motif");

        Patient newPatient = new Patient(0, username, email, telephone, motif);
        patientDAO.addPatient(newPatient);
        response.sendRedirect("patient");
    }
}
