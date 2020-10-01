const url = "https://localhost:5000";

function login() {
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;
    let authentication = [username, password];
    const authorization  = axios.post( url + "/login", authentication )
        .then(authorization => {
            console.log(authorization);
            if(authorization.data === "valid"){
                localStorage.setItem("valid", "true");
                window.location.href="https://localhost:5000/mainpage.html";

            } else {
                localStorage.setItem("valid", "false");
                window.location.href="https://localhost:5000/";
            }
        })
}

function refreshLocalStore() {
    localStorage.setItem("valid", "false");
}

function isLogged() {
    if(localStorage.getItem("valid") === "false"){
        alert("Not logged in");
        window.location.href="https://localhost:5000/";
    }
}

function calcular() {
    const numero = document.getElementById("numero").value;
    let resp = axios.get("https://localhost:5000/calculate?number=" + numero)
        .then(resp => {
            console.log("El resultado es: "+ resp.data);
            document.getElementById("result").innerHTML = resp.data;
        })
}