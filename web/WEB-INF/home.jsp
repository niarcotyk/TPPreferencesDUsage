<%@ page import="fr.eni.bo.Couleur" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Accueil</title>
    <%
      int compteur = (int) session.getAttribute("compteur");
      String couleur = (String) session.getAttribute("couleurChoisie");
      List<Couleur> listeCouleurs = (List<Couleur>) request.getAttribute("couleur");
    %>
  </head>
  <body>
    <p></p><font color="<%= couleur%>">
      <h1>ACCUEIL</h1>
      <form action="resultat" method="post">
        <select name = "combo" class="combo" id="combo" value="combo"> <!--Création ComboBox-->
          <% //plus simple de construire la comboBox
            if (listeCouleurs != null) {
            for(Couleur chaqueCouleur : listeCouleurs){
              out.print("<option value=" + chaqueCouleur.getNom() + ">" + chaqueCouleur.getNom() + "</option>");
            }
          }
          %>
        </select>
        <a href="<%=request.getContextPath()%>/resultat"><button type=submit id="Valider">Valider</button></a>
        <p>
          <label id="compteur">Vous êtes venus <%= compteur%> fois</label>
        </p>
      </form>
    </font>
  </body>
</html>
