package fr.eni.ProjetJee.dal.sqlServer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import fr.eni.ProjetJee.bo.Retrait;
import fr.eni.ProjetJee.dal.ConnectionProvider;
import fr.eni.ProjetJee.dal.DALException;
import fr.eni.ProjetJee.dal.RetraitDAO;

public class RetraitDAOImpl implements RetraitDAO{
	
	private static final String INSERT = "insert into RETRAITS(noArticle, rue,code_postal,ville) values (?, ?,?,?)";

	@Override
	public void insert(Retrait retrait) throws DALException {
		
		Connection conn = null;
		try {
			//Récupérer une connexion
			conn = ConnectionProvider.getConnection();

			//Préparer la requete
			PreparedStatement stmt = conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, retrait.getNoArticle());
			stmt.setString(2, retrait.getRue());
			stmt.setString(3, retrait.getCodePostal());
			stmt.setString(4,retrait.getVille());
			
			//Executer la requete
			stmt.executeUpdate();
			
			//Recupérer l'identifiant créé
			/*ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next()) {
				avis.setIdentifiant(rs.getInt(1));
			}*/
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DALException("Erreur insert", e);
		
		}finally {
			//Fermer la connexion
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public Retrait selectById(Integer noRetrait) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Retrait> selectAll() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Retrait retrait) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer noRetrait) throws DALException {
		// TODO Auto-generated method stub
		
	}

}
