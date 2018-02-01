describe('UtilisateurController', function() {
  beforeEach(module('utilisateurs'));

  var $controller;

  beforeEach(inject(function(_$controller_){
    // The injector unwraps the underscores (_) from around the parameter names when matching
    $controller = _$controller_;
  }));

//  describe('$scope.grade', function() {
//    it('sets the strength to "strong" if the password length is >8 chars', function() {
//      var $scope = {};
//      var controller = $controller('PasswordController', { $scope: $scope });
//      $scope.password = 'longerthaneightchars';
//      $scope.grade();
//      expect($scope.strength).toEqual('strong');
//    });
//  });
  
  describe('initialisation', function(){
	  it('initialise changerLogin et changerPassword à false', function(){
		  var controller = $controller('UtilisateurController',{});
		  controller.initialisation();
		  expect(controller.changerLogin).toEqual(false);
		  expect(controller.changerPassword).toEqual(false);
	  });
  });
});