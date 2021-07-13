<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Résultat</title>
</head>
<body >
    <p><%
    //    String couleur = (String) session.getAttribute("couleur");
        String couleur = (String) request.getAttribute("couleur");
    %></p>
    <p><font color="<%= couleur%>">
      <h1>UNE JSP</h1>
        <p>
            <label>Vous avez choisi la couleur = <%= couleur%></label>
        </p>
        <p>
          <a href="<%=request.getContextPath()%>/home">Retour</a>
        </p>
    </font>
    </p>
</body>
</html>
