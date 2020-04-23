	<div class="head">
		<nav>
			<ul class="menu">
				<li class="logo"><a href="#">GestionTp</a></li>
				<li class="item"><a href="#">Accueil</a></li>
				<li class="item"><a href="#">About</a></li>
				<li class="item"><a href="#">Services</a></li>
				<li class="item button secondary" id="modaleBtn"><a href="#">Profile</a></li>
				<li class="toggle"><span class="bars"></span></li>
			</ul>
		</nav>
		<div id="simpleModal" class="modal">
			<div class="profilEtudiant">
				<span class="closeBtnDeconnecte">&times;</span> <img class="imageE"
					src="./photo/profil.png">
				<div class="nomE">
					<label>nom: </label> <label>${nom} ${prenom}</label>
				</div>
				<div class="filierE">
					<label>Filiere: </label> <label>${Filiere}</label>
				</div>
				<div class="cne">
					<label>cne: </label> <label id="CNE" class="CNE" >${CNE}</label>
				</div>
				<form action="/GestionTp/Logout">
					<input class="deconnecter" type="submit" value="deconnecter" />
				</form>
			</div>
		</div>
	</div>