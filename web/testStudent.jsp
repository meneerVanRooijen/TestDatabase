<!DOCTYPE html>

<%@page import="model.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%

Student student;
student = new Student();
    
if(request.getParameter("update") != null) {
    student.setId(Integer.parseInt(request.getParameter("id")));
    student.setName(request.getParameter("name"));
            
    student.updateStudent();
}
else if(request.getParameter("delete") != null) {
    student.setId(Integer.parseInt(request.getParameter("id")));
    
    student.deleteStudent();
}
else if(request.getParameter("add") != null) {
    student.setId(Integer.parseInt(request.getParameter("id")));
    student.setName(request.getParameter("name"));

    student.addStudent();
}
else if(request.getParameter("read") != null) {
    student.setId(Integer.parseInt(request.getParameter("id")));
    
    student.readStudent();
}
else { 
    student.readStudent();
}

%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD Student</title>
    </head>
    <body>
        <form id="student" action=<%="testStudent.jsp"%> method="post">        
            
            <label for="id">Student id:</label>
            <input type="number" name="id" value="<%= student.getId() %>"/>
            <br/>
            <br/>
            <label for="name">Naam: </label>
            <input type="text" name="name" value="<%= student.getName() %>" />
            <br/>    
            <br/>
            <div class="row">
                <input type="submit" name="read" value="Ophalen" />
                <input type="submit" name="update" value="Wijzigen" />
                <input type="submit" name="delete" value="Verwijderen" />
                <input type="submit" name="add" value="Toevoegen" />
            </div>
        </form>
    </body>
</html>