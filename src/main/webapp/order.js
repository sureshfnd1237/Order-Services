/**
 * 
 */
function Hello($scope, $http) {
    $http.get('http://localhost:8080/orderServices/customers/getCustomers/1').
        success(function(data) {
            $scope.customer = data;
        });
}