package fr.eni.ProjetJee.dal;

import java.util.List;

import fr.eni.ProjetJee.bo.Utilisateurs;

public interface UtilisateursDAO {
	
	void insert (Utilisateurs utilisateur) throws DALException;
	Utilisateurs selectById(Integer noUtilisateur) throws DALException;
	List<Utilisateurs> selectAll() throws DALException;
	void update(Utilisateurs utilisateur) throws DALException;
	void delete(Integer noUtilisateur) throws DALException;

}
