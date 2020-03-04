Global.controller("CargoController", function($scope, $http) {
    $scope.cargo = "";
    $scope.c = {};
    $scope.cargos = [];

    listarCargo();

    $scope.modalEdit = c => {
        console.log(c);
        $scope.c = c;
        $("#edit").modal("show");
    }

    $scope.delete = c => {
        $http({
            url: api + `/cargo/${c.id}`,
            method: "DELETE"
        }).then(sc => sc.data).then(sc => {
            console.log(sc);
            listarCargo();
        })
    }

    $scope.editar = () => {
        console.log($scope.p);
        $http({
            url: api + "/cargo",
            method: 'PUT',
            data: $scope.c
        }).then(sc => sc.data).then(sc => {
            console.log(sc);
            $scope.c = {};
            listarCargo();
            $("#edit").modal("hide");
        })
    }

    $scope.crear = () => {
        console.log($scope.cargo);
        $http({
            url: api + "/cargo",
            method: 'POST',
            data: {
                cargo: $scope.cargo
            }
        }).then(sc => sc.data).then(sc => {
            console.log(sc);
            $scope.cargo = "";
            listarCargo();
        })
    }

    function listarCargo() {
        $http({
            url: api + `/cargo`,
            method: "GET"
        }).then(sc => sc.data).then(sc => {
            $scope.cargos = sc;
        })
    }
});