package fr.eni.ProjetJee.dal;

import fr.eni.ProjetJee.dal.sqlServer.RetraitDAOImpl;
import fr.eni.ProjetJee.dal.sqlServer.UtilisateurDAOSqlServerImpl;

public class DAOFactory {

	public static UtilisateursDAO getDAOUtilisateur() {
		return new UtilisateurDAOSqlServerImpl();
	}
	
	public static RetraitDAO getDAORetrait() {
		return new RetraitDAOImpl();
	}
}
