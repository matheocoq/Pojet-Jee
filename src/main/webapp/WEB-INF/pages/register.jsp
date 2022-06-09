<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	
	<style>
            h1
            {
               padding-left: 300px;
            }
            label
            {
            	padding-left: 100px;
				width: 200px;
            }
           
     </style>
	<title>Register</title>
</head>
<body>
<%@ include file="header/headerRegister.html"%>

<form action="http://localhost:8080/Projet_ENI-Encheres/ajouter" method="post">

  	<label for="pseudo">Pseudo :  </label>
  	<input type="text" id="pseudo" name="pseudo"> 
  	<label for="nom">Nom :  </label>
  	<input type="text" id="nom" name="nom"> <br><br>

  	<label for="prenom">Prénom :  </label>
  	<input type="text" id="prenom" name="prenom"> 
  	<label for="email">Email :  </label>
  	<input type="email" id="email" name="email"><br><br>
 
 	<label for="tel">Teléphone :  </label>
  	<input type="tel" id="tel" name="tel"> 
  	<label for="rue">Rue :  </label>
  	<input type="text" id="rue" name="rue"><br><br>
  	
  	<label for="codePostal">Code postal :  </label>
  	<input type="text" id="codePostal" name="codePostal"> 
  	<label for="ville">Ville :  </label>
  	<input type="text" id="ville" name="ville"><br><br>
	
	<label for="mdp">Mot de passe :  </label>
  	<input type="password" id="mdp" name="mdp"> 
  	<label for="confirmation">Confirmation :  </label>
  	<input type="password" id="confirmation" name="confirmation"><br><br>
	
	<br><br>
	
	<input type="submit" value="Créer">
	<button onclick="window.location.href = 'http://localhost:8080/Projet_ENI-Encheres/accueil';">Annuler</button>
</form>

</body>
</html>