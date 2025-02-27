package fr.eni.ProjetJee.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ProjetJee.bll.BLLException;
import fr.eni.ProjetJee.bll.UtilisateurMger;
import fr.eni.ProjetJee.bo.Utilisateur;
import fr.eni.ProjetJee.dal.DALException;

/**
 * Servlet implementation class EditProfilServlet
 */
@WebServlet({"/editProfil","/saveProfil"})
public class EditProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Avant d'afficher la page, il faut recuperer les infos du profil
		// avec session.getAttribute
		
		request.getRequestDispatcher("/WEB-INF/pages/editProfil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Modification du profil!!!");
		// on verifie les champs uniques et s'il ya un nouveau mot de passe 
		
		// recuperation de tous les champs
				String speudo = request.getParameter("pseudo");
				String nom = request.getParameter("nom");
				String prenom = request.getParameter("prenom");
				String email = request.getParameter("email");
				String tel = request.getParameter("tel");
				String rue = request.getParameter("rue");
				String codePostal = request.getParameter("codePostal");
				String ville = request.getParameter("ville");
				String mdp = request.getParameter("mdp");
				String newMdp = request.getParameter("newMdp");
				String confirmation = request.getParameter("confirmation");
				
				
				UtilisateurMger userMgr = UtilisateurMger.getInstance();
				try {
					// on verifie la longueur du numero de tel et si le pseudo, l'email ou telephone existe déjà dans la base de données.
					if(tel.length()<10 || userMgr.checkPseudoEmailTel(speudo,email,tel)) {
						request.setAttribute("errorModification", " Modification incorrect.");
						request.getRequestDispatcher("/WEB-INF/pages/editProfil.jsp").forward(request, response);
					}else {
						// Apres les verifications, on regarde si ya pas un new mot de passe
						if(newMdp.isEmpty()) {
							Utilisateur user = new Utilisateur(0, speudo, nom, prenom, email, tel, rue, codePostal, ville, userMgr.generateHash(mdp), 0,false);
							try {
								userMgr.majUtilisateur(user);
								//Faut il remettre en session? je ne pense pas. A demander à Matteo
								//request.getSession().setAttribute("utilisateur", user);
							} catch (BLLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							// on redirectionné vers la page d'acceuil du user connecté
							response.sendRedirect("http://localhost:8080/Projet_ENI-Encheres/");
						}else {
							// s'il ya un new mot de passe, on sauve le user avec le new mdp
							if(newMdp.equals(confirmation)) {
								Utilisateur user = new Utilisateur(0, speudo, nom, prenom, email, tel, rue, codePostal, ville, userMgr.generateHash(newMdp), 0,false);
								try {
									userMgr.ajouterUtilisateur(user);
									request.getSession().setAttribute("utilisateur", user);
								} catch (BLLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								// on redirectionné vers la page d'acceuil du user connecté
								response.sendRedirect("http://localhost:8080/Projet_ENI-Encheres/");
							}else {
								// le mot de passe et la confirmation doivent être identiques.
								System.out.println("mdp et confirmation sont pas identiques!");
								request.setAttribute("errorInscription", " Inscription incorrect.");
								request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
							}
						}
					}
				} catch (DALException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}		
	}
}
