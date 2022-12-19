package com.parking.parkinglot.servlets;


import com.parking.parkinglot.common.CarDto;
import com.parking.parkinglot.common.UserDto;
import com.parking.parkinglot.ejb.CarsBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.util.List;

@ServletSecurity(value=@HttpConstraint(rolesAllowed = {"WRITE_CARS"}))
@WebServlet(name="EditCar",value="/EditCar")

public class EditCar extends HttpServlet {
    @Inject
    com.parking.parkinglot.ejb.UserBean userBean; //nu ma lasa fara path
    @Inject
    CarsBean carsBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<UserDto> users = userBean.findAllUsers();
        request.setAttribute("users",users);

        Long carId =Long.parseLong(request.getParameter("id"));
        CarDto car=carsBean.findById(carId);
        request.setAttribute("car",car);


        request.getRequestDispatcher("/WEB-INF/pages/editcar.jsp").forward(request,response);// daca las addCar.jsp adauga fara sa il stearga pe cel anterior
        //daca las editcar.jsp apare eroare de la glassfish

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String licensePlate=request.getParameter("license_plate");
        String parkingSpot=request.getParameter("parking_spot");
        Long userId=Long.parseLong(request.getParameter("owner_id"));
        Long carId=Long.parseLong(request.getParameter("car_id"));

        carsBean.updateCar(carId,licensePlate,parkingSpot,userId);

        response.sendRedirect(request.getContextPath() + "/Cars");
    }



}
