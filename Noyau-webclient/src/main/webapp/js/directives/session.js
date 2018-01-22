(function(){
	
	angular.module('sessionDirective',[])
	
	.directive('ecranConnexion', directiveEcranConnexion);
	
	function directiveEcranConnexion(){return{restrict:'E',templateUrl:'templates/pages/login/index.html'};};
	
})();