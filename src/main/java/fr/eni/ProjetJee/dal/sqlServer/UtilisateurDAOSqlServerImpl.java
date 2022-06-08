package fr.eni.ProjetJee.dal.sqlServer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import fr.eni.ProjetJee.bo.Utilisateurs;
import fr.eni.ProjetJee.dal.ConnectionProvider;
import fr.eni.ProjetJee.dal.DALException;
import fr.eni.ProjetJee.dal.UtilisateursDAO;

public class UtilisateurDAOSqlServerImpl implements UtilisateursDAO {
	
	private static final String INSERT = "INSERT INTO Utilisateurs(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur, active) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	@Override
	public void insert(Utilisateurs utilisateur) throws DALException {
		try (Connection conn = ConnectionProvider.getConnection();) {
			PreparedStatement stmt = conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			
			// Faire les set(s)
			
			
		} catch (Exception e) {
			throw new DALException("Utilisateur insert Error ", e);
		}		
	}

	@Override
	public Utilisateurs selectById(Integer noUtilisateur) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Utilisateurs> selectAll() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Utilisateurs utilisateur) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer noUtilisateur) throws DALException {
		// TODO Auto-generated method stub
		
	}

}
