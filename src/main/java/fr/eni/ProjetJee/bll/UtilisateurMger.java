package fr.eni.ProjetJee.bll;

import java.util.List;

import fr.eni.ProjetJee.bo.Utilisateur;
import fr.eni.ProjetJee.dal.DALException;
import fr.eni.ProjetJee.dal.DAOFactory;
import fr.eni.ProjetJee.dal.UtilisateursDAO;


public class UtilisateurMger {

	UtilisateursDAO utilisateurDAO = DAOFactory.getDAOUtilisateur();
	
	public void ajouterUtilisateur(Utilisateur utilisateur) throws BLLException {
		try {
			utilisateurDAO.insert(utilisateur);
		} catch (DALException e) {
			throw new BLLException("ajouterUtilisateur Error ", e);
		}
	}
	
	public Utilisateur utilisateurById(int noUtilisateur) throws BLLException {
		try {
			return utilisateurDAO.selectById(noUtilisateur);
		} catch (DALException e) {
			throw new BLLException("utilisateurById Error ", e);
		}
	}
	
	public List<Utilisateur> allUtilisateurs() throws BLLException{
		try {
			return utilisateurDAO.selectAll();
		} catch (DALException e) {
			throw new BLLException("allUtilisateurs Error ", e);
		}
	}
	
	public void majUtilisateur(Utilisateur user) throws BLLException {
		try {
			utilisateurDAO.update(user);
		} catch (DALException e) {
			throw new BLLException("majUtilisateur Error ", e);
		}
	}
	
	public void supprimerUtilisateur(int noUtilisateur) throws BLLException {
		try {
			utilisateurDAO.delete(noUtilisateur);
		} catch (DALException e) {
			throw new BLLException("supprimerUtilisateur Error ", e);
		}
	}
}
