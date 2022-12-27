<%--
  Created by IntelliJ IDEA.
  User: Iulia
  Date: 12/27/2022
  Time: 2:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Add car photos">
    <form  class="needs-validation" novalidate method="POST" enctype="multipart/form-data "
    action="${pageContext.request.contextPath}/AddCarPhoto">

        <div class="row">
            <div class="col-md-6 mb-3">
                Lincence plate:${car.licencePlate}
            </div>
        </div>
        <div class="row">
            <div class="col-mb-6 mb-3">
                <%--@declare id="file"--%><label for="file">Photo</label>
                <input type="file" name="file" required>
                <div class="invalid-feedback">
                    Photo is required.
                </div>
            </div>
        </div>
        <input type="hidden" name="car_id" value="${car.id}"/>
        <hr class="mb-4">
        <button class="btn btn-primary btn-lg btn-block " type="submit">Save</button>



    </form>
</t:pageTemplate>