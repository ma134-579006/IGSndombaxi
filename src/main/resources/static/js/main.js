function GerarMatricular(){
    var txt = "IGS";
    var aleatorio = Math.floor(Math.random() * 1500);
    document.getElementById('matricula').value = (txt + aleatorio);

}