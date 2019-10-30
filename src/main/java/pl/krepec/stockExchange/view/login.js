document.getElementById('Check').addEventListener("click", checkUserNameExist);
document.getElementById('Login').addEventListener("click", logIn);
document.getElementById('AddNewUser').addEventListener("click", addNewUser);

function checkUserNameExist(){

const xhr = new XMLHttpRequest();

userName = document.getElementById("userName").value;

xhr.open('GET', "http://localhost:8080/stockexchange/user/check?username="+userName ,true);



  xhr.onload = function(){
        if(this.status === 200){
            console.log(this.responseText);
            const result = JSON.parse(this.responseText);

           if(result === true)
           alert("User name exist")
           else
           alert("User name doesn't exist")

        }
    }
    xhr.send();

}

function logIn(){
const xhr = new XMLHttpRequest();
userName = document.getElementById("userName").value;
password = document.getElementById("password").value;

xhr.open('GET', "http://localhost:8080/stockexchange/user/login?username="+userName+"&password="+password, true );
xhr.onload = function(){
 if(this.status === 200){
console.log(this.responseText)


     }
    }
    xhr.send();

}

function addNewUser(){
const xhr = new XMLHttpRequest();
name = document.getElementById("userName").value;
pass = document.getElementById("password").value;

xhr.open('POST', "http://localhost:8080/stockexchange/user/user", true );
xhr.setRequestHeader("Content-Type", "application/json");
xhr.onload = function(){
  console.log(this.responseText);
  console.log(name)
  console.log(pass)
}

xhr.send(JSON.stringify({userName:name, password:pass}));
}
