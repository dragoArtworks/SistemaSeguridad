function ValidarForma(forma){
    var descripcion=forma.descripcion;
    if(descripcion.value ==""){
        alert("decripcion no puede estar vacio");
        descripcion.focus();
        descripcion.select();
        return false;
    }
    
    alert("alerta agregada con exito");
    return true;
    
}


