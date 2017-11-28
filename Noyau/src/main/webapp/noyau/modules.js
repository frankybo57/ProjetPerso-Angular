(function() {
	
	mod = angular.module("modules", []);
	
	mod.controller('ModuleController', function($http){
		
		var self = this;
		
		self.onglet = "Accueil";
		self.module = null;
		self.modules = [];
		self.modulesActifs = [];
		self.etats = [];
	
		self.liste = function() {
			$http({
				method : 'GET',
				url : 'api/modules'
			}).then(function success(response) {
				self.modules = response.data; 
			}, function error(response) {

			});
		};
		
		self.listeActifs = function() {
			$http({
				method : 'GET',
				url : 'api/modules-actifs'
			}).then(function success(response) {
				self.modulesActifs = response.data; 
			}, function error(response) {

			});
		};
		
		self.add = function() {
			self.moduleForm.$setPristine();
			this.module = {};
		};
		
		self.edit = function(id) {
			self.moduleForm.$setPristine();
			$http({
				method : 'GET',
				url : 'api/modules/'+id
			}).then(function success(response) {
				self.module = response.data; 
			}, function error(response) {

			});
		};
		
		self.save = function() {
			if (self.module.id == null) {
				$http({
					method : 'POST',
					url : 'api/modules/',
					data : self.module
				}).then(function success(response) {
					self.liste();
					self.cancel();
				}, function error(response) {

				});
			} else {
				$http({
					method : 'PUT',
					url : 'api/modules/',
					data : self.module
				}).then(function success(response) {
					self.liste();
					self.cancel();
				}, function error(response) {

				});
			}
		};
		
		self.toggle = function(id){
			$http({
				method : 'GET',
				url : 'api/modules/'+id
			}).then(function success(response) {
				var temp  = response.data;
				if(temp.etat==='Actif'){
					temp.etat = 'Inactif';
				}
				else{
					temp.etat = 'Actif';
				}
				$http({
					method : 'PUT',
					url : 'api/modules/',
					data : temp
				}).then(function success(response) {
					self.liste();
					self.cancel();
				}, function error(response) {

				});
			}, function error(response) {

			});
		};
		
		self.remove = function(id) {
			$http({
				method : 'DELETE',
				url : 'api/modules/'+id
			}).then(function success(response) {
				self.liste();
			}, function error(response) {

			});
			
			
		};

		self.cancel = function() {
			self.module = null;
		};
		
				
		self.setOnglet = function(onglet){
			self.onglet = onglet;
		};
				
		self.isOnglet = function(onglet){
			return self.onglet === onglet;
		};
		
		self.listeEtats = function() {
			$http({
				method : 'GET',
				url : 'api/etats'
			}).then(function success(response) {
				self.etats = response.data;
			}, function error(response) {

			});
		};
				
		self.liste();
		self.listeActifs();
		self.listeEtats();
	});
				
})();