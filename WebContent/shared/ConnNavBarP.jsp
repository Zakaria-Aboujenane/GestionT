	<div class="head">
		<nav>
			<ul class="menu">
				<li class="logo"><a href="#">GestionTp</a></li>
			
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
					<label>email: </label> <label>${email}</label>
				</div>
				<div class="cne">
					<label>CIN: </label> <label id="CNE" class="CNE" >${CIN}</label>
				</div>
				<div class="cne">
					<label>Role: </label> <label id="CNE" class="CNE" >${role}</label>
				</div>
				<form action="/GestionTp/Logout">
					<input class="deconnecter" type="submit" value="deconnecter" />
				</form>
			</div>
		</div>
	</div>