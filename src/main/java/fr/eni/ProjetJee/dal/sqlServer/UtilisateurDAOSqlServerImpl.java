package fr.eni.ProjetJee.dal.sqlServer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import fr.eni.ProjetJee.bo.Utilisateur;
import fr.eni.ProjetJee.dal.ConnectionProvider;
import fr.eni.ProjetJee.dal.DALException;
import fr.eni.ProjetJee.dal.UtilisateursDAO;

public class UtilisateurDAOSqlServerImpl implements UtilisateursDAO {
	
	private static final String INSERT = "INSERT INTO Utilisateurs(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur, active) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	@Override
	public void insert(Utilisateur utilisateur) throws DALException {
		try (Connection conn = ConnectionProvider.getConnection();) {
			PreparedStatement stmt = conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			
			// Faire les set(s)
			//Préparer la requete
			stmt.setString(1, utilisateur.getPseudo());
			stmt.setString(2, utilisateur.getNom());
			stmt.setString(1, utilisateur.getPrenom());
			stmt.setString(1, utilisateur.getEmail());
			stmt.setString(1, utilisateur.getTelephone());
			stmt.setString(1, utilisateur.getRue());
			stmt.setString(1, utilisateur.getCodePostal());
			stmt.setString(1, utilisateur.getVille());
			stmt.setString(1, utilisateur.getMotDePasse());
			stmt.setInt(1, utilisateur.getCredit());
			stmt.setBoolean(1, utilisateur.getAdministrateur());
			stmt.setBoolean(1, utilisateur.getActiver());
			
			//Executer la requete
			stmt.executeUpdate();
			
			//Recupérer l'identifiant créé
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next()) {
				utilisateur.setNoUtilisateur(rs.getInt(1));
			}
			
		} catch (Exception e) {
			throw new DALException("Utilisateur insert Error ", e);
		}		
	}

	@Override
	public Utilisateur selectById(Integer noUtilisateur) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Utilisateur> selectAll() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Utilisateur utilisateur) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer noUtilisateur) throws DALException {
		// TODO Auto-generated method stub
		
	}

}
