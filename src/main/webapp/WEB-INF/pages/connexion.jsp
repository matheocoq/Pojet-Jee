<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connexion</title>
</head>
<body>
	<%@ include file="header/header.html"%>
	<div class="container">
		<form action="" method="post">
		
			${not empty errorConnexion ? "<div class='alert alert-danger mb-4' role='alert'>Identifiant ou Mots de passe incorrect !!</div>" : null }
		
			<div class="form-group">
				<label>Identifiant</label>
				<input class="form-control" name="login" type="text">
			</div>
			 
			<div class="form-group mt-2">
				<label>Mots de passe</label> 
				<input class="form-control" name="mdp" type="password"> 
			</div>
			
			<!-- <div class="form-group mt-2">
				<input class="form-check-input" name="souvenir" type="checkbox"> 
				<label>Se souvenir de moi</label>
			</div>
			
			<div class="mt-2">
				<a>Mots de passe oublié</a>
			</div> -->
				
			<button class="btn btn-primary my-3">Connexion</button>
		</form>
		<a class="text-decoration-none text-primary fw-bold" href="/Projet_ENI-Encheres/register">Crée un compte</a>
	</div>
</body>
</html>