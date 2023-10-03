function ValidarForma(forma){
    var usuario = forma.usuario;
   
    if(usuario.value == "" ){
        alert("el campo usuario no puede estar vacio");
        usuario.focus();
        usuario.select();
        return false;
    }
    var contrasena = forma.contrasena;
    if(contrasena.value==""){
        alert("El campo de contraseña no puede estar vacio");
        contrasena.focus();
        contrasena.select();
        return false;
    }
    
    //formulario es valido
    alert("usuario correcto");
    return true;
}



