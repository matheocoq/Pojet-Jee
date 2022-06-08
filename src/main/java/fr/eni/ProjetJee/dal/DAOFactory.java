package fr.eni.ProjetJee.dal;




import fr.eni.ProjetJee.dal.sqlServer.CategorieDAOImpl;
import fr.eni.ProjetJee.dal.sqlServer.RetraitDAOImpl;
import fr.eni.ProjetJee.dal.sqlServer.UtilisateurDAOSqlServerImpl;

public class DAOFactory {

	public static UtilisateursDAO getDAOUtilisateur() {
		return new UtilisateurDAOSqlServerImpl();
	}
	
	public static CategorieDAO getDAOCategorie() {
		return new CategorieDAOImpl();
	}
	
	public static RetraitDAO getRetraitDAO() {
		return new RetraitDAOImpl();
	}
	
}
