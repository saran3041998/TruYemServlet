<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.cognizant.truyum.model.MenuItem"  %>

<!doctype html>
<html>
<head>
<title>Menu item list admin</title>
<link rel="stylesheet" href="style/style.css"/>
</head>
<body>
<header class="header container-fluid">
<h2 class="header-itemleft">truYum</h2>
<img src="images/truYum_logo.png" class="center">
<a class="header-itemright" href="ShowMenuItemListAdminServlet"  style="margin:15px">Menu</a>
</header>

<section class="body-main" style="overflow-x:auto;">
                <h1 class="h1-left">Menu Items</h1>
                <table style="width:100%;" id="books" >
                                <tr>
                                                <th class="td-name">Name</th>
                                                <th class="td-price">Price</th>
                                                <th>Active</th>
                                                <th>Date of Launch</th>
                                                <th>category</th>
                                                 <th>Free Delivery</th>
                                                <th>Action</th>
                                </tr>
                                <c:forEach var="item" items="${adminmenuitem}">
                                <tr>
                                <td class="td-name">${item.name }</td>
                                <td class="td-price"><fmt:setLocale value="en_IN"/><fmt:formatNumber type="currency" value="${item.price }"/></td>
    							<td>${item.active ? 'Yes' : 'No'  }</td>
   								<td><fmt:formatDate pattern="dd/MM/yyyy"  value="${item.dateOfLaunch }"/></td>
								<td>${item.category}</td>
								<td>${item.freedelivery ? 'yes' : 'No' }</td>
								<td><a href="ShowEditMenuItemServlet?menuItemId=${item.id}">Edit</a></td>
								</tr>
                                
                                
                                </c:forEach>
                                
                                
                                
                               
                                </table>
</section>
                                                
<div class="footer container-fluid">
                <p>&nbsp;&nbsp;Copyright &copy;2019</p>
</div>
</body>
</html>