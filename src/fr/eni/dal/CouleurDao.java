package fr.eni.dal;

import fr.eni.bo.Couleur;

import java.util.List;

public interface CouleurDao {
    List<Couleur> findAll();
}
