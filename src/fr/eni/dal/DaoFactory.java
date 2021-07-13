package fr.eni.dal;

public class DaoFactory {
    public static CouleurDao getCouleurDao(){
        return new CouleurDaoJdbcImpl();
    }
}
