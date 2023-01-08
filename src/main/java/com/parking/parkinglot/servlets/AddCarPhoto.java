package com.parking.parkinglot.servlets;

import com.parking.parkinglot.common.CarDto;
import com.parking.parkinglot.ejb.CarsBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
@MultipartConfig
@WebServlet(name = "AddCarPhoto", value = "/AddCarPhoto")
public class AddCarPhoto extends HttpServlet {
    @Inject
    CarsBean carsBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long carId=Long.parseLong(request.getParameter("id"));
        CarDto car=carsBean.findById(carId);
        request.setAttribute("car",car);
        request.getRequestDispatcher("/WEB-INF/pages/addCarPhoto.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long carId=Long.parseLong(request.getParameter("car_id"));

        Part filePart=request.getPart("file");
        String fileNmae=filePart.getSubmittedFileName();
        String fileType=filePart.getContentType();
        long fileSize=filePart.getSize();
        byte[] fileContent=new byte[(int) fileSize];
        filePart.getInputStream().read(fileContent);

        carsBean.addPhotoToCar(carId,fileNmae,fileType,fileContent);
        response.sendRedirect(request.getContextPath()+"/Cars");
    }
}
