package com.parking.parkinglot.servlets;

import com.parking.parkinglot.common.CarPhotoDto;
import com.parking.parkinglot.ejb.CarsBean;
import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sun.jvm.hotspot.types.CIntegerField;

import java.io.IOException;

@WebServlet(name="CarPhotos",value="/CarPhotos")
public class CarPhotos  extends HttpServlet {
    @Inject
    CarsBean carsBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer carId= Integer.parseInt(request.getParameter("id"));
        CarPhotoDto photo=carsBean.findPhotoByCarId(carId);
        if(photo!=null){
            response.setContentType(photo.getFileType());
            response.setContentLength(photo.getFileContent().length);
            response.getOutputStream().write(photo.getFileContent());
        }else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND); //error 404

        }


    }


}
