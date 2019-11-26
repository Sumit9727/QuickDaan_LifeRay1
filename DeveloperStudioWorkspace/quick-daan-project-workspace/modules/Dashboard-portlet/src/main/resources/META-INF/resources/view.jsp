<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ page import="java.util.Date" %>

<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<liferay-theme:defineObjects />

<portlet:defineObjects />

   
    <!--<link rel="stylesheet" href="user.css">-->
    <style>
        body {
            margin-top: 100px;
        }

        h2 {
            color: #3AADA1;
        }
.nav>li>a:focus, .nav>li>a:hover {
    text-decoration: none;
    background-color: #bf221d;
    </style>

                <div class="container">
                    <center>
                        <h2><b>User Management</b></h2>
                    </center>
                    <br /><br />
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4><b>Manage User</b></h4>
                        </div>
                        <div class="panel-body">
                            <div class="col-sm-1"></div>
                            <div class="col-sm-5">
                                <form>

                                    <!--<div class="form-group">
                                        <label for="customer_name">Customer Name</label>:
                                        <select class="form-control" id="customer_name">
                                            <option>Select</option>
                                            <option>2</option>
                                            <option>3</option>
                                            <option>4</option>
                                        </select>
                                    </div>-->

                                    <!--<div class="form-group">
                                        <label for="facility_name">Facility Name</label>:
                                        <select class="form-control" id="facility_name">
                                            <option>Select</option>
                                            <option>2</option>
                                            <option>3</option>
                                            <option>4</option>
                                        </select>
                                    </div>-->
                                    <div class="form-group">
                                        <label for="full_name">Full Name</label>:
                                        <input type="name" class="form-control" id="full_name" placeholder="Enter Full Name" name="first_name" onblur="validateEmail(this);" required>
                                    </div>


                                    <div class="form-group">
                                        <label for="role">Role</label>:
                                        <select class="form-control" id="role">
                                            <option>Select</option>
                                            <option>Admin</option>
                                            <option>Manager</option>
                                        </select>
                                    </div>

                                    <div class="form-group">
                                        <label for="email">Email</label>:
                                        <input type="email" class="form-control" id="email" placeholder="Enter Email" name="email" onblur="validateEmail(this);" required>
                                    </div>

                                </form>

                            </div>
                            <div class="col-sm-5">

                                <form>

                                    <div class="form-group">
                                        <label for="user_name">Username</label>:
                                        <input type="name" class="form-control" id="user_name" placeholder="Enter User Name" name="user_name" onblur="validateEmail(this);" required>
                                    </div>

                                    <div class="form-group">
                                        <label for="password">Password</label>:
                                        <input type="password" class="form-control" id="password" placeholder="Enter Password" name="password" onblur="validateEmail(this);" required>
                                    </div>

                                  
                                    <!-- <div class="checkbox">
                                        <label><input type="checkbox" value=""><b>Active</b></label>
                                    </div>-->
                                    <div class="form-group">
                                        <label for="phone">Phone Number</label>:
                                        <input type="phone" class="form-control" id="phone" placeholder="Enter Phone Number" name="phone" onblur="validateEmail(this);" required>
                                    </div>

                                </form>

                            </div>
                            <div class="col-sm-1"></div>

                        </div>

                        <div class="panel-footer">
                            <div class="row">
                                <div class="col-sm-12">
                                    <div class="col-sm-8"></div>
                                    <div class="col-sm-4">

                                        <button type="button" class="btn btn-lg btn-primary"><span class="glyphicon glyphicon-floppy-saved"></span>&nbsp;Save</button>
                                        <button type="button" class="btn btn-lg btn-danger"><span class="	glyphicon glyphicon-remove"></span>&nbsp;Cancel</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
       