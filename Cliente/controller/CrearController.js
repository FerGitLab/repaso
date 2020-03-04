Global.controller("CrearController", function($scope, $http) {
    $scope.persona = {};
    $scope.cargos = [];

    $http({
        url: api + `/cargo`,
        method: "GET"
    }).then(sc => sc.data).then(sc => {
        $scope.cargos = sc;
    })

    $scope.crear = () => {
        console.log($scope.persona);
        $http({
            url: api,
            method: 'POST',
            data: $scope.persona
        }).then(sc => sc.data).then(sc => {
            console.log(sc);
            $scope.persona = {};
        })
    }
});