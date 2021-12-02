<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Banda</title>
</head>
<body>

<h1>Banda-Editar</h1>
       
 
   <form action="update">
   
 
        
        <table >
           
                      
            <tr>
                <th>Nome: </th>
                <td>
                 <input type="text" name="nome"
                  value="<c:out value='${banda.nome}' "/>
                </td>
            </tr>
            <tr>
                <th>Gênero: </th>
                <td>
                 <input type="text" name="genero" value="<c:out value='${banda.genero}'" />
                </td>
            </tr>
           
            <tr>
             <td >
              <input type="submit" value="Editar " />
             </td>
            </tr>
        </table>
        </form>

</body>
</html>