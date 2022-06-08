package fr.eni.ProjetJee.dal.sqlServer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import fr.eni.ProjetJee.bo.ArticleVendu;
import fr.eni.ProjetJee.bo.Categorie;
import fr.eni.ProjetJee.bo.Retrait;
import fr.eni.ProjetJee.bo.Utilisateur;
import fr.eni.ProjetJee.dal.ArticleVenduDAO;
import fr.eni.ProjetJee.dal.CategorieDAO;
import fr.eni.ProjetJee.dal.DALException;
import fr.eni.ProjetJee.dal.DAOFactory;
import fr.eni.ProjetJee.dal.RetraitDAO;
import fr.eni.ProjetJee.dal.UtilisateursDAO;

import fr.eni.ProjetJee.dal.ConnectionProvider;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class ArticleVenduDAOSqlServerlmpl implements ArticleVenduDAO {
	
	private static final String INSERT = "insert into ARTICLES_VENDUS(nom_article, description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,no_utilisateur,no_categorie) values (?, ? ,?,?,?,?,?,?)";
	private static final String SELECTALL = "Select * from ARTICLES_VENDUS";
	private static final String SELECT = "Select * from ARTICLES_VENDUS where no_article=?";
	private static final String SELECTBYUTILISATEUR = "Select * from ARTICLES_VENDUS where no_utilisateur=?";
	private static final String SELECTBYCATEGORIE = "Select * from ARTICLES_VENDUS where no_categorie=?";
	private static final String DELETE = "DELETE FROM ARTICLES_VENDUS WHERE no_article=?;";
	private static final String UPDATE = "UPDATE ARTICLES_VENDUS SET nom_article = ?, description = ? , date_debut_encheres = ?, date_fin_encheres = ?, prix_initial = ?, prix_vente = ?, no_utilisateur = ?, no_categorie = ? , no_retrait =? ,photo=? ,etat_vente = ? WHERE no_article=?;";

	@Override
	public void insert(ArticleVendu article) throws DALException {
			try(Connection conn = ConnectionProvider.getConnection();) {
			
			PreparedStatement stmt = conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, article.getNomArticle());
			stmt.setString(2, article.getDescription());
			 Date date1 = Date.from(article.getDateDebutEncheres().atZone(ZoneId.systemDefault()).toInstant());
			stmt.setDate(3, (java.sql.Date) date1);
			 Date date2 = Date.from(article.getDateFinEncheres().atZone(ZoneId.systemDefault()).toInstant());
			stmt.setDate(4, (java.sql.Date) date2);
			stmt.setInt(5, article.getMiseAPrix());
			stmt.setInt(6, article.getPrixDeVente());
			stmt.setInt(7, article.getUtilisateur().getNoUtilisateur());
			stmt.setInt(8, article.getCategorie().getNoCategorie());
			
			
			//Executer la requete
			stmt.executeUpdate();
			
			//Recupérer l'identifiant créé
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next()) {
				article.setNoArticle(rs.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public ArticleVendu select(int id) throws DALException {
		ArticleVendu articlevendu = null;

		try (Connection conn = ConnectionProvider.getConnection();) {

			PreparedStatement stmt = conn.prepareStatement(SELECT);
			stmt.setInt(1, id);

			// Executer la requete
			ResultSet res = stmt.executeQuery();

			// Recupérer l'identifiant créé

			if (res.next()) {
				
				 LocalDateTime date_debut_encheres = res.getDate("date_debut_encheres").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
				 LocalDateTime date_fin_encheres = res.getDate("date_fin_encheres").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
				 articlevendu = new ArticleVendu(res.getInt("no_article"),res.getString("nom_article"),res.getString("description"),date_debut_encheres,date_fin_encheres,res.getString("etat_vente"),res.getInt("prix_initial"),res.getInt("prix_vente"),res.getString("photo"),null,null,null);
				
				
				UtilisateursDAO daoUtilisateur=(UtilisateursDAO) DAOFactory.getDAOUtilisateur();
				Utilisateur utilisateur = daoUtilisateur.selectById(res.getInt("no_utilisateur"));
				articlevendu.setUtilisateur(utilisateur);
				
				CategorieDAO daoCategorie=(CategorieDAO) DAOFactory.getDAOCategorie();
				Categorie categorie = daoCategorie.selectById(res.getInt("no_categorie"));
				articlevendu.setCategorie(categorie);
				if(res.getInt("no_retrait")>=0) {
					RetraitDAO daoRetrait=(RetraitDAO) DAOFactory.getDAORetrait();
					Retrait retrait = daoRetrait.selectById(res.getInt("no_retrait"));
					articlevendu.setLieuRetrait(retrait);
				}
				
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return articlevendu;
		
	}

	@Override
	public ArrayList<ArticleVendu> select() throws DALException {
		ArrayList<ArticleVendu> articles =new ArrayList<ArticleVendu>();
		
		try(Connection conn = ConnectionProvider.getConnection();) {
			
			PreparedStatement stmt = conn.prepareStatement(SELECTALL);
			
			
			//Executer la requete
			ResultSet res= stmt.executeQuery();
			
			//Recupérer l'identifiant créé
			while(res.next()) {
				 LocalDateTime date_debut_encheres = res.getDate("date_debut_encheres").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
				 LocalDateTime date_fin_encheres = res.getDate("date_fin_encheres").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
				 ArticleVendu articlevendu = new ArticleVendu(res.getInt("no_article"),res.getString("nom_article"),res.getString("description"),date_debut_encheres,date_fin_encheres,res.getString("etat_vente"),res.getInt("prix_initial"),res.getInt("prix_vente"),res.getString("photo"),null,null,null);
				
				
				UtilisateursDAO daoUtilisateur=(UtilisateursDAO) DAOFactory.getDAOUtilisateur();
				Utilisateur utilisateur = daoUtilisateur.selectById(res.getInt("no_utilisateur"));
				articlevendu.setUtilisateur(utilisateur);
				
				CategorieDAO daoCategorie=(CategorieDAO) DAOFactory.getDAOCategorie();
				Categorie categorie = daoCategorie.selectById(res.getInt("no_categorie"));
				articlevendu.setCategorie(categorie);
				if(res.getInt("no_retrait")>=0) {
					RetraitDAO daoRetrait=(RetraitDAO) DAOFactory.getDAORetrait();
					Retrait retrait = daoRetrait.selectById(res.getInt("no_retrait"));
					articlevendu.setLieuRetrait(retrait);
				}
				articles.add(articlevendu);
			}
			
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return articles;
	}

	@Override
	public ArrayList<ArticleVendu> selectByUtilisateur(Utilisateur utilisateur) throws DALException {
		
		ArrayList<ArticleVendu> articles =new ArrayList<ArticleVendu>();
		
		try(Connection conn = ConnectionProvider.getConnection();) {
			
			PreparedStatement stmt = conn.prepareStatement(SELECTBYUTILISATEUR);
			stmt.setInt(1, utilisateur.getNoUtilisateur());
			
			//Executer la requete
			ResultSet res= stmt.executeQuery();
			
			//Recupérer l'identifiant créé
			while(res.next()) {
				 LocalDateTime date_debut_encheres = res.getDate("date_debut_encheres").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
				 LocalDateTime date_fin_encheres = res.getDate("date_fin_encheres").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
				 ArticleVendu articlevendu = new ArticleVendu(res.getInt("no_article"),res.getString("nom_article"),res.getString("description"),date_debut_encheres,date_fin_encheres,res.getString("etat_vente"),res.getInt("prix_initial"),res.getInt("prix_vente"),res.getString("photo"),null,null,null);
				
				
				UtilisateursDAO daoUtilisateur=(UtilisateursDAO) DAOFactory.getDAOUtilisateur();
				Utilisateur utilisateure = daoUtilisateur.selectById(res.getInt("no_utilisateur"));
				articlevendu.setUtilisateur(utilisateure);
				
				CategorieDAO daoCategorie=(CategorieDAO) DAOFactory.getDAOCategorie();
				Categorie categorie = daoCategorie.selectById(res.getInt("no_categorie"));
				articlevendu.setCategorie(categorie);
				if(res.getInt("no_retrait")>=0) {
					RetraitDAO daoRetrait=(RetraitDAO) DAOFactory.getDAORetrait();
					Retrait retrait = daoRetrait.selectById(res.getInt("no_retrait"));
					articlevendu.setLieuRetrait(retrait);
				}
				articles.add(articlevendu);
			}
			
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return articles;
	}

	@Override
	public ArrayList<ArticleVendu> selectByCategorie(Categorie categorie) throws DALException {
ArrayList<ArticleVendu> articles =new ArrayList<ArticleVendu>();
		
		try(Connection conn = ConnectionProvider.getConnection();) {
			
			PreparedStatement stmt = conn.prepareStatement(SELECTBYCATEGORIE);
			stmt.setInt(1, categorie.getNoCategorie());
			
			//Executer la requete
			ResultSet res= stmt.executeQuery();
			
			//Recupérer l'identifiant créé
			while(res.next()) {
				 LocalDateTime date_debut_encheres = res.getDate("date_debut_encheres").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
				 LocalDateTime date_fin_encheres = res.getDate("date_fin_encheres").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
				 ArticleVendu articlevendu = new ArticleVendu(res.getInt("no_article"),res.getString("nom_article"),res.getString("description"),date_debut_encheres,date_fin_encheres,res.getString("etat_vente"),res.getInt("prix_initial"),res.getInt("prix_vente"),res.getString("photo"),null,null,null);
				
				
				UtilisateursDAO daoUtilisateur=(UtilisateursDAO) DAOFactory.getDAOUtilisateur();
				Utilisateur utilisateur = daoUtilisateur.selectById(res.getInt("no_utilisateur"));
				articlevendu.setUtilisateur(utilisateur);
				
				CategorieDAO daoCategorie=(CategorieDAO) DAOFactory.getDAOCategorie();
				Categorie categoriee = daoCategorie.selectById(res.getInt("no_categorie"));
				articlevendu.setCategorie(categoriee);
				if(res.getInt("no_retrait")>=0) {
					RetraitDAO daoRetrait=(RetraitDAO) DAOFactory.getDAORetrait();
					Retrait retrait = daoRetrait.selectById(res.getInt("no_retrait"));
					articlevendu.setLieuRetrait(retrait);
				}
				articles.add(articlevendu);
			}
			
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return articles;
	}

	@Override
	public void delete(int id) throws DALException {
		
		try(Connection conn = ConnectionProvider.getConnection();) {
			
			PreparedStatement stmt = conn.prepareStatement(DELETE);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(ArticleVendu article) throws DALException {
		
		try(Connection conn = ConnectionProvider.getConnection();) {
	
			PreparedStatement stmt = conn.prepareStatement(UPDATE);
			stmt.setString(1, article.getNomArticle());
			stmt.setString(2, article.getDescription());
			 Date date1 = Date.from(article.getDateDebutEncheres().atZone(ZoneId.systemDefault()).toInstant());
			stmt.setDate(3, (java.sql.Date) date1);
			 Date date2 = Date.from(article.getDateFinEncheres().atZone(ZoneId.systemDefault()).toInstant());
			stmt.setDate(4, (java.sql.Date) date2);
			stmt.setInt(5, article.getMiseAPrix());
			stmt.setInt(6, article.getPrixDeVente());
			stmt.setInt(7, article.getUtilisateur().getNoUtilisateur());
			stmt.setInt(8, article.getCategorie().getNoCategorie());
			stmt.setInt(9, article.getLieuRetrait().getNoRetrait());
			stmt.setString(10, article.getPhoto());
			stmt.setString(11, article.getEtatVente());
			stmt.setInt(12, article.getNoArticle());
			
			
			//Executer la requete
			stmt.executeUpdate();
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
