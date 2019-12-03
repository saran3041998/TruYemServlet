<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.cognizant.truyum.model.Cart"  %>
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
<a class="header-itemright" href="ShowMenuItemListCustomerServlet"  style="margin:15px">Menu</a>
<a class="header-itemright" href="ShowCartServlet" style="margin:15px">Cart</a>
</header>
<section class="body-main" style="overflow-x:auto;">
                <h1 class="h1-left">Cart</h1>
                <c:if test="${removeCartStatus}">
                <h2 >Item removed from the  Cart Successfully</h2>
                
                </c:if>
                
 <table style="width:100%;" id="books" >
                                <tr>
                                                <th class="td-name">Name</th>
                                                <th>Free Delivery</th>
                                                <th class="td-price">Price</th>
                                                
                                                
                                                
                                </tr>
                                <c:set var="total" value="${0}" ></c:set>
                                <c:forEach var="item" items="${customerMenuItemList}">
                                <tr>
                                                <td class="td-name">${item.name}</td>
                                                <td>${item.freedelivery ? 'yes' : 'No' }</td>
                                                <td class="td-price"><fmt:setLocale value="en_IN"/><fmt:formatNumber type="currency" value="${item.price }"/></td>
                                                <c:set var="total" value="${total+item.price}" ></c:set>
                                                
                                                <td><a href="RemoveCartServlet?menuItemId=${item.id}">Delete</a>
                                                </td>
                                </tr>
                                </c:forEach>
                                <tr>
                                <td></td>
                                <td>Total :</td>
                                <td class="td-price"><fmt:setLocale value="en_IN"/><fmt:formatNumber type="currency" value="${total}"/></td>
                                </tr>

                                </table>
</section>
<footer class="footer container-fluid">
                <p>&nbsp;&nbsp;Copyright &copy;2019</p>
</footer>
</body>
</html>