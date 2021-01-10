function manipulate(){
    document.getElementById("name").value="welcome to accolite";
}

function displayVal(){
    document.getElementById("rangeVal").innerHTML=document.getElementById("rangeBar").value;
}

function saveuser(){
    alert('User Saved');
}

function saveform(){

    localStorage.setItem('firstname', document.getElementById('fn').value);

    alert('User Saved Successfully');
}

function displayName(){
    document.getElementById("fn").value = localStorage.getItem('firstname');


}

function loginActivity(){
    localStorage.setItem('username', document.getElementById('username').value);

    if(document.getElementById('password').value.localeCompare("admin") == 0)
    {
        alert("User Login Successful");

    }
    else{
        alert("Wrong Password!");
    }
}

var c = document.getElementById('line');
var ctx = c.getContext("2d");
ctx.moveTo(0, 0);
ctx.lineTo(300, 300);
ctx.stroke();