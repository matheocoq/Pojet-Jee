
<%@ page import="fr.eni.ProjetJee.bo.Utilisateur"%>
<jsp:include page="header/headerConnecter.jsp" />
<div class="container">

	<div class="row">
		<div class="col-3">
			<img alt="" src="/WEB-INF/resources/imgTestNouvelleVente.jpg">
			<p>IMAGE</p>
		</div>
		<div class="col-9">
			<h5 style="text-align: center">Nouvelle vente</h5>
			<form action="" method="post"">
				<div class="form-group mt-3">
					<label for="article">Article</label>
					<input type="text" class="form-control" name="article" id="article" >
				</div>
				
				<div class="form-floating mt-3">
				  <textarea class="form-control" placeholder="Description" name="description" id="description"></textarea>
				  <label for="description">Description</label>
				</div>
				
				<div class="mt-3">
					<label for="categorie">Catégorie</label>
					<select class="form-select" name="categorie" id="categorie">
					  <option selected></option>
					  <option value="1">Informatique</option>
					  <option value="2">Ameublement</option>
					  <option value="3">Sport&Loisir</option>
					  <option value="4">Vetement</option>
					</select>
				</div>
				
				<div class="input-group mt-3">
				  <label class="input-group-text" for="photo">Uploader</label>
				  <input type="file" class="form-control" name="photo" id="photo">
				</div>
				
				<div class="form-group mt-3">
					<label for="prix">Mise à prix</label>
					<input type="number" min="0" max="" class="form-control" name="prix" id="prix" >
				</div>
				
				<div class="form-group mt-3">
					<label for="dateDebut">Date de début</label>
					<input type="date" name="dateDebut" id="dateDebut" class="input-group-date">
				</div>
				
			</form>
		</div>
	</div>
</div>
<jsp:include page="footer/footer.jsp" />