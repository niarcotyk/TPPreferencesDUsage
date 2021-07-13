package fr.eni.dal;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionProvider {
    private static DataSource dataSource;
    //lire le fichier context.xml
    static {
        try {
            Context context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:comp/env/jdbc/bdd");

        } catch (NamingException ne) {
            ne.printStackTrace();
        }

    }
    //Création de la connexion
    public static Connection getConnection() throws SQLException {
        return ConnectionProvider.dataSource.getConnection();
    }
}
