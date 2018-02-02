describe('UtilisateurController', function() {
  beforeEach(module('utilisateurs'));

  var $controller;

  beforeEach(inject(function(_$controller_){
    // The injector unwraps the underscores (_) from around the parameter names when matching
    $controller = _$controller_;
  }));

  describe('initialisation', function(){
	  it('initialise changerLogin et changerPassword à false', function(){
		  var controller = $controller('UtilisateurController',{});
		  controller.initialisation();
		  expect(controller.changerLogin).toEqual(false);
		  expect(controller.changerPassword).toEqual(false);
	  });
  });
});
