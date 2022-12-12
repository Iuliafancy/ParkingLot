<%--
  Created by IntelliJ IDEA.
  User: Iulia
  Date: 12/11/2022
  Time: 5:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:pageTemplate pageTitle="EditCar">
  <h1>EditCar</h1>
  <form class="needs-validation" novalidate method="post" action="${pageContext.request.contextPath}/EditCar">

    <div class="row">
      <div class="col-md-6 mb-3">
        <label for="license_plate">License Plate</label>
        <input type="text" class="form-control" id="license_plate" name="license_plate" placeholder="" value="${car.licensePlate}" required>
        <div class="invalid-feedback">
          Licence Plate is required
        </div>
      </div>
    </div>

    <div class="row">
      <div class="col-md-6 mb-3">
        <label for="parking_spot">Parking Spot</label>
        <input type="text" class="form-control" id="parking_spot" name="parking_spot" placeholder="" value="${car.parkingSpot}" required>
        <div class="invalid-feedback">
          Parking Spot is required
        </div>
      </div>
    </div>

    <div class="row">
      <div class="col-md-6 mb-3">
        <label for="owner_id">Owner</label>
        <select class="custom-select d-block w-100" id="owner_id" name="owner_id" required>
          <option value="">Choose...</option>
          <c:forEach var="user" items="${users}" varStatus="status">
            <option value="${user.id}"${car.ownerName eq user.username ? 'selected' : '' }>${user.username}</option>
          </c:forEach>
        </select>
        <div class="invalid-feedback">
          Please select the owner
        </div>
      </div>
    </div>

    <hr class="nb-4">
    <input  type="hidden" name="car_id" value="${car.id}" />
    <hr class="nb-4">
    <input  class="btn btn-primary btn-lg" type="submit" value="Submit">
  </form>
</t:pageTemplate>
