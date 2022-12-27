package com.parking.parkinglot.servlets;


import com.parking.parkinglot.common.CarDto;
import com.parking.parkinglot.ejb.CarsBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;

@MultipartConfig
@WebServlet(name="AddCarPhoto",value ="/AddCarPhoto")
public class AddCarPhoto extends HttpServlet {

    @Inject
    CarsBean carsBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    {
        Long carId=Long.parseLong(request.getParameter("id"));
        CarDto car=carsBean.findById(carId);
        request.setAttribute("car",car);

        request.getRequestDispatcher("/WEB-INF/pages/addCarPhoto.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        Long carId=Long.parseLong(request.getParameter("car_id"));

        Part filePart=request.getPart("file");
        String fileName=filePart.getSubmittedFileName();  //filename in case of errors
        String fileType=filePart.getContentType();
        long fileSize=filePart.getSize();
        byte[] fileContent= new byte[(int) fileSize];
        filePart.getInputStream().read(fileContent);

        carsBean.addPhotoToCar(carId,fileName,fileType,fileContent);
        response.sendRedirect(request.getContextPath()+"/Cars");


    }

}
