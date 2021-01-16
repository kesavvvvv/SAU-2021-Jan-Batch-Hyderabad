function helloworld() {
    alert("Hello World");
}

function redirect() {
    alert("Thanks for visiting my page! Redirecting...");
    window.location.href = "https://www.github.com/kesavvvvv";
}

function operate() {
    document.getElementById('result').value = parseInt(document.getElementById("num1").value) + parseInt(document.getElementById("num2").value);
}