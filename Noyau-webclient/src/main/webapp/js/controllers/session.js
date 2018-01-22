(function(){
	
	angular.module('sessionController',[])
	.controller('SessionController', SessionController);
	
	function SessionController($http){
		var self = this;
		self.creation = false;
		self.droits = null;
		
		self.utilisateur = {};
		self.utilisateurTemporaireLogin = null;
		self.utilisateurTemporaireCreation = null;
		
		self.utilisateurNonTrouve = false;
		
		self.cgLogin = false;
		self.cgMdp = false;
		
		self.creerUtilisateur = function(){
			if(!self.creation){
				self.creation = true;
				self.utilisateurTemporaireCreation = {};
				self.utilisateurCreationForm.$setPristine();
			}
			else{
				self.creation = false;
			}
		};
		
		self.saveUtilisateur = function(){
			$http({
				method : 'POST',
				url : 'api/utilisateur/code/',
				data : self.utilisateurTemporaireCreation
			}).then(function success(response) {
				self.utilisateur = response.data;
				self.droits = self.utilisateur.droits;
				self.utilisateurTemporaireCreation = null;
				self.utilisateurNonTrouve = false;			
			}, function error(response) {
				self.utilisateurNonTrouve = true;
			});
		}
		
		self.pasDBol = function(){
			alert("Pas d'bol !");
		};
		
		self.effacer = function(){
			self.utilisateurTemporaireLogin = {};
			self.utilisateurForm.$setPristine();
			self.utilisateurNonTrouve = false;
		};
		
		self.connexion = function(){
			$http({
				method : 'GET',
				url : 'api/utilisateur/code/'
					+ self.utilisateurTemporaireLogin.login
					+ ':'
					+ self.utilisateurTemporaireLogin.password
			}).then(function success(response) {
				self.utilisateur = response.data;
				self.droits = self.utilisateur.droits;
				self.utilisateurNonTrouve = false;
				self.utilisateurTemporaireLogin = null;
			}, function error(response) {
				self.utilisateurNonTrouve = true;
			});
		};
		
//		self.changerLogin = function(){
//			self.cgLogin = true;
//			self.cgMdp = false;
//			$http({
//				method : 'GET',
//				url : 'api/utilisateur_login/'+self.utilisateur.login
//			}).then(function success(response) {
//				self.utilisateurTemporaire = response.data; 
//			}, function error(response) {
//			});
//		};
//		
//		self.changerMdp = function(){
//			self.cgLogin = false;
//			self.cgMdp = true;
//			$http({
//				method : 'GET',
//				url : 'api/utilisateur_login/'+self.utilisateur.login
//			}).then(function success(response) {
//				self.utilisateurTemporaire = response.data; 
//			}, function error(response) {
//			});
//		};
		
//		self.save = function(){
//			$http({
//				method : 'PUT',
//				url : 'api/utilisateur_login/'+self.temp.login,
//				data : self.utilisateurTemporaire
//			}).then(function success(response) {
//				self.utilisateur = response.data;
//				self.temp = null;
//				self.cancel();
//			}, function error(response) {
//
//			});
//		};
		
		self.cancel = function(){
			self.cgLogin = false;
			self.cgMdp = false;
		};
		
//		self.supprimer = function(){
//			$http(
//				{
//					method : 'DELETE',
//					url : 'api/utilisateurs/' + self.utilisateur.id
//					}).then(function success(response) {
//						self.role = null;
//						self.temp = null;
//						self.utilisateurNonTrouve = false;
//						self.utilisateur = {};
//						self.utilisateurForm.$setPristine();
//						self.utilisateurCreationForm.$setPristine();
//				}, function error(response) {
//			});
//		};
		
		self.retourConnexion = function(){
			self.creation = false;
			self.utilisateurTemporaireCreation = null;
			self.utilisateurTemporaireCreation = {};
			self.utilisateurForm.$setPristine();
			self.utilisateurCreationForm.$setPristine();
		};
		
		self.deconnexion = function(){
			self.utilisateur = null;
			self.utilisateurTemporaireCreation = null;
			self.utilisateurTemporaireLogin = null;
			self.droits = null;
			self.utilisateurForm.$setPristine();
			self.utilisateurCreationForm.$setPristine();
		};
	}
})();