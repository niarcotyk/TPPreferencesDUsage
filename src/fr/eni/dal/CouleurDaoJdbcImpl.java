package fr.eni.dal;

import fr.eni.bo.Couleur;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CouleurDaoJdbcImpl implements CouleurDao{
    private final String FINDALL = "SELECT id, nom FROM COULEUR";
    @Override
    public List<Couleur> findAll() {
        List<Couleur>listeCouleurs = new ArrayList<>();
        try (Connection cnx = ConnectionProvider.getConnection();
                Statement stt = cnx.createStatement();){
            ResultSet rs = stt.executeQuery(FINDALL);
            while(rs.next()){
                int id = rs.getInt(1);
                String nom = rs.getString(2);
                Couleur c = new Couleur(id, nom);
                listeCouleurs.add(c);
            }
            rs.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return listeCouleurs;
    }
}
