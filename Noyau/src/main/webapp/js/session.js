(function(){
	
	var ses = angular.module('session',[])
	

	ses.directive('ecranConnexion',function(){
		return{
			restrict:'E',
			templateUrl:'ecran-connexion.html'
		};
	});
	
	ses.controller('SessionController',function($http){
		var self = this;
		self.creation = false;
		self.droits = null;
		
		self.utilisateur = {};
		self.utilisateurTemporaire = null;
		
		self.utilisateurNonTrouve = false;
		
		self.cgLogin = false;
		self.cgMdp = false;
		
		self.creerUtilisateur = function(){
			if(!self.creation){
				self.creation = true;
				self.utilisateurTemporaire = {};
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
				data : self.utilisateurTemporaire
			}).then(function success(response) {
				self.utilisateur = response.data;
				self.droits = self.utilisateur.droits;
				self.utilisateurTemporaire = null;
				self.utilisateurNonTrouve = false;			
			}, function error(response) {
				self.utilisateurNonTrouve = true;
			});
		}
		
		self.pasDBol = function(){
			alert("Pas d'bol !");
		};
		
		self.effacer = function(){
			self.utilisateurTemporaire = {};
			self.utilisateurForm.$setPristine();
			self.utilisateurNonTrouve = false;
		};
		
		self.connexion = function(){
			$http({
				method : 'GET',
				url : 'api/utilisateur/code/'
					+ self.utilisateurTemporaire.login
					+ ':'
					+ self.utilisateurTemporaire.password
			}).then(function success(response) {
				self.utilisateur = response.data;
				self.droits = self.utilisateur.droits;
				self.utilisateurNonTrouve = false;
				self.utilisateurTemporaire = null;
			}, function error(response) {
				self.utilisateurNonTrouve = true;
			});
		};
		
		self.changerLogin = function(){
			self.cgLogin = true;
			self.cgMdp = false;
			$http({
				method : 'GET',
				url : 'api/utilisateur_login/'+self.utilisateur.login
			}).then(function success(response) {
				self.utilisateurTemporaire = response.data; 
			}, function error(response) {
			});
		};
		
		self.changerMdp = function(){
			self.cgLogin = false;
			self.cgMdp = true;
			$http({
				method : 'GET',
				url : 'api/utilisateur_login/'+self.utilisateur.login
			}).then(function success(response) {
				self.utilisateurTemporaire = response.data; 
			}, function error(response) {
			});
		};
		
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
			self.utilisateurTemporaire = null;
			self.utilisateurForm.$setPristine();
			self.utilisateurCreationForm.$setPristine();
		};
		
		self.deconnexion = function(){
			self.utilisateur = null;
			self.utilisateurTemporaire = null;
			self.droits = null;
			self.utilisateurForm.$setPristine();
			self.utilisateurCreationForm.$setPristine();
		};
	});
})();