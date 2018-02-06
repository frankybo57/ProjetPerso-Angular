
describe('UtilisateurController', function() {
//	beforeEach(module('utilisateurs'));
	beforeEach(angular.mock.module('ValueUtilisateurConnecte'));
	beforeEach(angular.mock.module('utilisateurs'));

	var $controller;
	var $value;

	beforeEach(inject(function(_$controller_){
		// The injector unwraps the underscores (_) from around the parameter names when matching
		$controller = _$controller_;
	}));

	beforeEach(inject(function(_$value_){
		// The injector unwraps the underscores (_) from around the parameter names when matching
		$value = _$value_;
	}));

	describe('initialisation', function(){
		it('initialise changerLogin et changerPassword a false', function(){
			var value = $value('utilisateurConnecte');
//			var controller = $controller('UtilisateurController',utilisateurConnecte:utilisateurConnecte);
//			controller.initialisation();
//			expect(controller.changerLogin()).toEqual(false);
//			expect(controller.changerPassword()).toEqual(false);
		});
	});
});
