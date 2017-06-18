(function(fYLService) {
	var host="http://localhost:8080/crossoverfed/";
		fYLService.factory('Auth', [ "$resource", function($resource) {	
		return {
			loginuser : function(req) {
				// return $resource('jsons/view-complaints.json', {}, {
				return $resource(host+'auth/userlogin/', {}, {
					// query: {method:'GET', params:{}, isArray: false}
					query : {
						method : 'POST',
						params :req
					}
				});

			},
			"getuserdetails":function(req){
				return $resource(host+'auth/user/', {}, {
					// query: {method:'GET', params:{}, isArray: false}
					query : {
						method : 'POST',
						params :req
					}
				});
			}
		}
	} ]);
		fYLService.factory('GetData', [ "$resource", function($resource) {	
		return {
			getSalesmanData : function(req) {
				// return $resource('jsons/view-complaints.json', {}, {
				return $resource(host+'data/salesmandata/', {}, {
					// query: {method:'GET', params:{}, isArray: false}
					query : {
						method : 'POST',
						params :req
					}
				});

			},
			getMonthwiseData : function(req) {
				// return $resource('jsons/view-complaints.json', {}, {
				return $resource(host+'data/lastyeardata/', {}, {
					// query: {method:'GET', params:{}, isArray: false}
					query : {
						method : 'POST',
						params :req
					}
				});

			},
			getTopSales : function(req) {
				// return $resource('jsons/view-complaints.json', {}, {
				return $resource(host+'data/topsalesorder/', {}, {
					// query: {method:'GET', params:{}, isArray: false}
					query : {
						method : 'POST',
						params :req
					}
				});

			},
			getTopSalesMan : function(req) {
				// return $resource('jsons/view-complaints.json', {}, {
				return $resource(host+'data/topsalesman/', {}, {
					// query: {method:'GET', params:{}, isArray: false}
					query : {
						method : 'POST',
						params :req
					}
				});
			}
		}
	} ]);

})(angular.module('crossoverservice', [ 'ngResource' ]));