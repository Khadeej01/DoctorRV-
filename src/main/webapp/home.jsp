<%@ page import="java.util.List" %>
<%@ page import="com.Model.Doctor" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>DoctorRV</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-cover bg-center h-screen flex items-center justify-center" style="background-image: url('./imgs/Doc.jpg')">
<h1 class="absolute top-8 left-4 text-4xl font-bold  text-blue-600">
    Welcome to DoctorRV
</h1>


<button id="loginBtn" class="absolute top-4 right-4 bg-blue-600 text-white py-2 px-6 rounded-lg hover:bg-blue-700">
   Doctor Login
</button>



<div id="loginModal" class="hidden fixed inset-0 bg-black bg-opacity-50 flex items-center justify-center">
    <div class="bg-white p-8 rounded-lg shadow-lg w-80">
        <h3 class="text-xl   font-bold text-blue-600 text-center mb-4"> Doctor Login</h3>
        <form action="LoginServlet" method="POST" class="space-y-4">

            <div>
                <label for="username" class="block font-semibold">Username:</label>
                <input type="text" name="username" id="username" required class="w-full p-2 border rounded mt-1">
            </div>

            <div>
                <label for="password" class="block font-semibold">Password:</label>
                <input type="password" name="password" id="password" required class="w-full p-2 border rounded mt-1">
            </div>



            <div>
                <input type="submit" value="Login" class="w-full bg-blue-600 text-white py-2 rounded-lg hover:bg-blue-700">
            </div>
        </form>

        <button id="closeModal" class="mt-4 w-full bg-gray-500 text-white py-2 rounded-lg hover:bg-gray-600">Close</button>
    </div>
</div>
<div class="container flex flex-col md:flex-row justify-center gap-8 p-6">

    <div class="bg-white bg-opacity-80 p-6 rounded-lg shadow-lg w-full md:w-1/3">
        <h3 class="text-xl font-bold text-blue-600 text-center">Book Your Appointment</h3>
        <form action="insertDoctor" method="POST" class="mt-4">
            <label for="username" class="block font-semibold">Username:</label>
            <input type="text" name="username" id="usernamee" required class="w-full p-2 border rounded mt-1">

            <div>
                <label for="email" class="block font-semibold mt-3">Email:</label>
                <input type="email" name="email" id="email" required class="w-full p-2 border rounded mt-1">
            </div>
            <div>
                <label for="telephone" class="block font-semibold mt-3">Telephone:</label>
                <input type="tel" name="telephone" id= "telephone" required class="w-full p-2 border rounded mt-1">
            </div>

            <label for="doctor1" class="block font-semibold mt-3">Choose a Doctor:</label>
            <select  id="doctor1" name="doctorid"  class="w-full p-2 border rounded mt-1">
                <%
                    List<Doctor> doctors = (List<Doctor>) request.getAttribute("listDoctor");

                    for (Doctor doctor : doctors) {
                %>
                <option value="<%= doctor.getDocId() %>">
                    <%= doctor.getDocUsername() %>
                </option>
                <% } %>
            </select>

            <div value=""></div>




            <label for="appointmentDate" class="block font-semibold mt-3">Choose Date:</label>
            <input type="date" name="appointmentDate" id="appointmentDate" required
                   class="w-full p-2 border rounded mt-1">
            <div>
                <label for="motif" class="block font-semibold mt-3">Motif:</label>
                <textarea name="motif" id="motif" required class="w-full p-2 border rounded mt-1" rows="3"></textarea>
            </div>

            <input type="submit" value="Book Appointment"
                   class="w-full bg-blue-600 text-white py-2 mt-4 rounded-lg hover:bg-blue-700">
        </form>
    </div>
</div>

    <script>

        const loginBtn = document.getElementById("loginBtn");
        const loginModal = document.getElementById("loginModal");
        const closeModal = document.getElementById("closeModal");
        loginBtn.addEventListener("click", function() {
        loginModal.classList.remove("hidden");
    });
        closeModal.addEventListener("click", function() {
        loginModal.classList.add("hidden");
    });
        window.addEventListener("click", function(event) {
        if (event.target === loginModal) {
        loginModal.classList.add("hidden");
    }
    });


</script>

</body>
</html>