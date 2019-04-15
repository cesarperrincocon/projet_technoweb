var Script = function () {


    var doughnutData = [
        {
            value: 30,
            color: "#1abc9c"
        },
        {
            value: 50,
            color: "#2ecc71"
        },
        {
            value: 100,
            color: "#3498db"
        },
        {
            value: 40,
            color: "#9b59b6"
        },
        {
            value: 120,
            color: "#34495e"
        }

    ];

    new Chart(document.getElementById("doughnut1").getContext("2d")).Doughnut(doughnutData);
    new Chart(document.getElementById("doughnut2").getContext("2d")).Doughnut(doughnutData);
    new Chart(document.getElementById("doughnut3").getContext("2d")).Doughnut(doughnutData);
}();