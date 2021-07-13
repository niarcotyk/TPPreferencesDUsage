package fr.eni.servlets;

import fr.eni.bll.CouleurManager;
import fr.eni.bo.Couleur;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class Home extends HttpServlet {
    String color = null;
    List<Couleur> listeCouleurs = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Cookie
        Cookie[] cookies = request.getCookies(); //récupération
        boolean trouve = false;
        Cookie cookie = null;
        if(cookies!=null){ //si cookie
            for(Cookie c : cookies){
                if(c.getName().equals("nbVisites")){
                    trouve = true;
                    int valeur = Integer.parseInt(c.getValue());
                    //valeur++;
                    c.setValue(String.valueOf(++valeur)); //auto-incrémentation
                    c.setMaxAge(Integer.MAX_VALUE);
                    cookie = c; //affectation du cookie en cours
                    response.addCookie(cookie);
                }
            }
            //Si pas de cookies, création d'un cookie
            if (!trouve){
                cookie = new Cookie("nbVisites", "1");
                cookie.setMaxAge(Integer.MAX_VALUE);
                response.addCookie(cookie);
            }
        }
        request.setAttribute("nbVisites", cookie.getValue());
        //Session
        HttpSession session = request.getSession();
        if(session.getAttribute("compteur") != null){
            int cpt = (int) session.getAttribute("compteur"); //récupération du compteur
            session.setAttribute("compteur", ++cpt); //ajout de 1 avant le setAttribute

        }
        else{
            session.setAttribute("compteur", 0); // création du compteur
        }

        CouleurManager cm =new CouleurManager();
        listeCouleurs = cm.trouverTous();
        request.setAttribute("couleur",listeCouleurs);
        session.setAttribute("couleur",session.getAttribute("combo"));

        request.getRequestDispatcher("WEB-INF/home.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Session
        request.getSession().setAttribute("couleurChoisie", request.getParameter("combo"));
        //Récupération de la valeur sélectionnée
        String choix = request.getParameter("combo");
        //Application de la couleur choisie
        request.setAttribute("couleur", choix);
        request.getRequestDispatcher("WEB-INF/resultat.jsp").forward(request,response);
    }
}
