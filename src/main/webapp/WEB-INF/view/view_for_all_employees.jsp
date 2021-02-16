<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>This are all employees</title>
</head>
<body>
<br/><br/>
<security:authorize access="hasAnyRole('HR','MANAGER')">//делаем кнопку видимой только этим ролям
    <input type="button" value="salary" onclick="window.location.href = 'hr_info'">
    only for HR staff
</security:authorize>

<br/><br/>

<security:authorize access="hasRole('MANAGER')">//делаем кнопку видимой только этой роли
    <input type="button" value="performance" onclick="window.location.href = 'manager_info'">
    only for Manager
</security:authorize>

</body>
</html>
