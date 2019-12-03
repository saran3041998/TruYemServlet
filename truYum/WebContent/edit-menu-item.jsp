<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.cognizant.truyum.model.MenuItem"  %>


<!Doctype html>
<html>
<head>
<title>Edit Menu Item</title>
<script type="text/javascript" src="js/script.js">

</script>
<link rel="stylesheet" href="style/style.css"/>

<style type="text/css">
.body-main th
{
text-align:left;
padding-top:20px;
}
.body-main td
{
text-align:left;
}
button[type="submit"]
{
padding-top:15px;
padding-bottom:15px;
padding-left:15px;
padding-right:15px;
background-color:#004080;
color:white;
border:0;

}              
</style>
</head>
<body>

<c:set var="categories" value="Fast Food,Drinks,Starters,Main Course" scope="application"/>
<c:set var="selected" value="${menuItem.category}" scope="application"/>
<header class="header container-fluid">
                <h2 class="header-itemleft">truYum</h2>
                <img src="images/truYum_logo.png" class="center">
                <a class="header-itemright" href="ShowMenuItemListAdminServlet" style="margin:15px;">Menu</a>  
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
</header>          

<section class="body-main" style="overflow-x:auto;">
     
                <h1 class="style-color">Edit Menu item</h1>
                <form name="editMenuForm" action="EditMenuItemServlet" method="post" onsubmit="return validateMenuItem()">
               <table style="width:100%" id="">
        
                <tr><th colspan="4"><label for="mname">Name</label></th></tr>
                
                <tr><td colspan="4"><input type="text" id="mname" style="width:1050px;height:30px;" style="width:50%" name="mname" value=<c:out value="${menuItem.name}"/>></td></tr>
                <tr>
                <th><label for="price">Price</label></th>
                <th><label for="active">Active</label></th>
                <th><label for="launch">Date of Launch</label></th>
                <th><label for="category">Category</label></th>
                </tr>
                

                <tr>
                <td><input type="text" name="price" id="price" value=<c:out value="${menuItem.price}"/>></td>
                
                 <c:choose>
                                                <c:when test="${menuItem.active=='Yes'}">
                                                      <td><input type="radio" id="mactive"
                                                            name="active" value="Yes" style="font-size: 20px"
                                                            checked>Yes <input type="radio" id="mactive"
                                                            name="active" value="No" style="font-size: 20px">No
                                                      </td>
                                                </c:when>
                                                <c:otherwise>
                                                      <td><input type="radio" id="mactive"
                                                            name="active" value="Yes" style="font-size: 20px">Yes
                                                            <input type="radio" id="mactive" name="active"
                                                            value="No" style="font-size: 20px" checked>No
                                                      </td>
                                                </c:otherwise>
                                          </c:choose>

                <td><input type="date" name="date" id="launch" value=<fmt:formatDate pattern="dd/MM/yyyy" value="${menuItem.dateOfLaunch}"/> ></td>
                <td>
                <select name="category" id="category">
                
                
                <option value="${selected}" selected>${selected}</option>
                                                                      
                
                <c:forEach items="${categories}" var="category">
                <c:if test="${category!=selected}">
                <option value="${category}">${category}</option>
                
                
                
                </c:if>
                </c:forEach>
                </select>
                </td>
                </tr>
                

                <tr>
                <td>
                
                <td><input type="checkbox" name="freedelivery"
                                                value="${user.menuItem.Delivery}"
                                                <c:if test="${menuItem.freedelivery}">checked="checked"</c:if> />
                                                <label>Free Delivery</label></td>
                
                
                
                </tr>

                <tr>
                <td><a href="edit-menu-item-status.jsp"><input type="submit" class="button" value="Save"></a>
</td>
                </tr>
                


               </table>
        
</section>
<input type="hidden" id="menuitemid" name="menuitemid" value="${menuItem.id }"/>
</form>
<footer class="footer container-fluid">
                <p>&nbsp;&nbsp;Copyright &copy; 2019</p>
</footer>
</body>
</html>
