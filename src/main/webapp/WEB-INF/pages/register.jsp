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
  	<input type="text" id="pseudo" name="pseudo"  required="required"> 
  	<label for="nom">Nom :  </label>
  	<input type="text" id="nom" name="nom"  required="required"> <br><br>

  	<label for="prenom">Prénom :  </label>
  	<input type="text" id="prenom" name="prenom"  required="required"> 
  	<label for="email">Email :  </label>
  	<input type="email" id="email" name="email"  required="required"><br><br>
 
 	<label for="tel">Teléphone :  </label>
  	<input type="tel" id="tel" name="tel"  required="required"> 
  	<label for="rue">Rue :  </label>
  	<input type="text" id="rue" name="rue"  required="required"><br><br>
  	
  	<label for="codePostal">Code postal :  </label>
  	<input type="text" id="codePostal" name="codePostal"  required="required"> 
  	<label for="ville">Ville :  </label>
  	<input type="text" id="ville" name="ville"  required="required"><br><br>
	
	<label for="mdp">Mot de passe :  </label>
  	<input type="password" id="mdp" name="mdp"  required="required"> 
  	<label for="confirmation">Confirmation :  </label>
  	<input type="password" id="confirmation" name="confirmation"  required="required"><br><br>
	
	<br><br>
	
	<input type="submit" value="Créer">
	<input onclick="window.location.href = 'http://localhost:8080/Projet_ENI-Encheres/accueil';">Annuler</input>
</form>

</body>
</html>