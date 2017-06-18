define(['scripts/appModule'], function(app){
	app.lazy.controller('indexController', ["$scope","$rootScope","$location","Auth","$cookies",function($scope,$rootScope,$location,Auth,$cookies){
		$scope.userdetails={};
            $scope.sess=$cookies.jsession;
            $scope.$parent.sess=$cookies.jsession;
            $rootScope.sess=$cookies.jsession;
            console.log($rootScope.sess);
            if($scope.sess!=null){
                $location.path("/home");
            }
		$scope.process={
			"login":function(){
				var uname=$scope.userdetails.username;
				var pass=$scope.userdetails.password;
				if(uname=="" || pass==""){
					$scope.err=true;
				}else{
					$scope.err=false;
					$scope.wait=true;
					var req={
						'username':uname,
						'password':pass
					}
					$scope.load.login(req,function(data){
						$cookies.jsession=data.sessionId;
						$location.path("/home");
					},function(){

					})
				}
			},
			"logout":function(){
					$scope.load.login(req,function(){

					},function(){

					})
			},
			"submitmsg":function(){
				$scope.msg="Sent and Submitted";
			}
		};

		$scope.load={
			"login":function(req,success,failure){
				console.log("sd");
				Auth.loginuser(req).query(function(data){
					success(data);
				}).error(function(data){
					failure(data);
				});
			},

			"logout":function(){
				Auth.loginuser(req).query(function(data){
					success(data);
				});
			}

		}
	}]);
});