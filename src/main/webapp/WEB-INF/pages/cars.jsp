<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Cars">

    <h1>Cars</h1>

    <form method="POST" action="${pageContext.request.contextPath}/Cars">
    <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/AddCar">Add Car</a>
        <button class="btn btn-danger" type="submit"> Delete Cars</button>
    <div class="container text-center">
        <c:forEach var="car" items="${cars}">


            <div class="row">
                <div class="col">
                    <input type="checkbox" name="car_ids"  value="${car.id}"/>
                </div>
                <div class="col">
                        ${car.licensePlate}
                </div>
                <div class="col">
                        ${car.parkingSpot}
                </div>
                <div class="col">
                        ${car.ownerName}
                </div>
                <div class="col">
                    <img src="${pageContext.request.contextPath}/CarPhotos?id=${car.id}" width="48"/>
                </div>
                <c:if test="${pageContext.request.isUserInRole('WRITE_CARS')}">
                    <div class="col">
                    <a class="btn btn-secondary"
                       href="${pageContext.request.contextPath}/AddCarPhoto?id=${car.id}" role="button">Add Photo</a>
                    </div>


                <div class="col">
                    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/EditCar?id=${car.id}">Edit
                        Car</a>
                </div>
                    ${numberOfFreeParkingSpots=numberOfFreeParkingSpots-1}


            </div>
        </c:forEach>
    </div>

    </form>

    <h5>Free parking spots: ${numberOfFreeParkingSpots-count}</h5>
</t:pageTemplate>