package fr.eni.bll;

import fr.eni.bo.Couleur;
import fr.eni.dal.CouleurDao;
import fr.eni.dal.DaoFactory;

import java.util.List;

public class CouleurManager {
    private CouleurDao cDao;

    public CouleurManager() {
        cDao =DaoFactory.getCouleurDao();
    }

    public List<Couleur> trouverTous(){
        return cDao.findAll();
    }
}
