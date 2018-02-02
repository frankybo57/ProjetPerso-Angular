(function() {

	angular.module("ControllerAfficherListeModules", [])

	.controller('ControllerAfficherListeModules', ControllerAfficherListeModules);

	function ControllerAfficherListeModules(ModuleFactory){

		var ctrl = this;

		ctrl.module = null;
		ctrl.modules = [];
		ctrl.etats = [];

		ctrl.liste = function() {
			ModuleFactory.findAllOrderById()
			.then(function success(response) {
				ctrl.modules = response.data;
			}, function error(response) {

			});
		};

		ctrl.add = function() {
			ctrl.moduleForm.$setPristine();
			this.module = {};
		};

		ctrl.edit = function(id) {
			ctrl.moduleForm.$setPristine();
			ModuleFactory.findOne(id)
			.then(function success(response) {
				ctrl.module = response.data;
			}, function error(response) {

			});
		};

		ctrl.save = function() {
			if (ctrl.module.id == null) {
				ModuleFactory.create(module)
				.then(function success(response) {
					ctrl.liste();
					ctrl.cancel();
				}, function error(response) {

				});
			} else {
				ModuleFactory.update(module)
				.then(function success(response) {
					ctrl.liste();
					ctrl.cancel();
				}, function error(response) {

				});
			}
		};

		ctrl.toggle = function(id){
			ModuleFactory.findOne(id)
			.then(function success(response) {
				var temp  = response.data;
				if(temp.etat==='ACTIF'){
					temp.etat = 'INACTIF';
				}
				else{
					temp.etat = 'ACTIF';
				}
				ModuleFactory.update(module)
				.then(function success(response) {
					ctrl.liste();
					ctrl.cancel();
				}, function error(response) {

				});
			}, function error(response) {

			});
		};

		ctrl.remove = function(id) {
			ModuleFactory.remove(id)
			.then(function success(response) {
				ctrl.liste();
			}, function error(response) {

			});

		};

		ctrl.cancel = function() {
			ctrl.module = null;
		};

		ctrl.listeEtats = function() {
			ModuleFactory.findAllEtats()
			.then(function success(response) {
				ctrl.etats = response.data;
			}, function error(response) {

			});
		};

		ctrl.liste();
		ctrl.listeEtats();
	}

})();
