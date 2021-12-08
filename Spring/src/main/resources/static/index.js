angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8080/students';

    //создаём функцию с именем fillTable
    $scope.fillTable = function () {
        $http({
            url: contextPath + '/api/v1/students/all',
            method: 'GET',
        }).then(function (response) {
                console.log(response);
                $scope.StudentsList = response.data;
            });
    };

    $scope.submitCreateNewStudent = function () {
        $http.post(contextPath + '/api/v1/students', $scope.newStudent)
            .then(function (response) {
                $scope.newStudent = null;
                $scope.fillTable();
            });
    };

    $scope.deleteStudentById = function (id) {
        $http.delete(contextPath + "/api/v1/students" + id)
            .then (function (response) {
                $scope.fillTable();
            });
    }

    $scope.fillTable();
});