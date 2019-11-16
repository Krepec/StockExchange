document.getElementById('submit').addEventListener("click", logIn)


function logIn(){
const xhr = new XMLHttpRequest();
    userName = document.getElementById('userName').value;
    password = document.getElementById('password').value;
    console.log(userName)
    console.log(password)

    xhr.open("GET", "http://localhost:8080/stockexchange/user/login?username="+userName+"&password="+password, true)


    xhr.onload = function(){
        if(this.status == 200){
        alert("Zalogowano pomyślnie")
            window.location.replace("index.html")
            const userInfo = JSON.parse(this.responseText)
            console.log(userInfo);

           const name = userInfo.userName
           const id = userInfo.id
           const cash = userInfo.cash

            console.log(id)
            console.log(name)
            console.log(cash)
            console.log(document.getElementById("name"))

            document.getElementById("name").innerHTML = name;
            document.getElementById("userId").innerHTML = id;
            document.getElementById("cash").innerHTML = cash;

        }
        else alert("Błędne hasło lub login")


    }


    xhr.send();
}

function userdata(){
const xhr = new XMLHttpRequest();

    xhr.open("GET", "http://localhost:8080/stockexchange/user/login?username="+userName+"&password="+password, true)


    xhr.onload = function(){
        if(this.status == 200){


            const userInfo = JSON.parse(this.responseText)
            console.log(userInfo);

           const name = userInfo.userName
           const id = userInfo.id
           const cash = userInfo.cash

            console.log(id)
            console.log(name)
            console.log(cash)
            console.log(document.getElementById("name"))


            document.getElementById("name").innerHTML = name;
            document.getElementById("userId").innerHTML = id;
            document.getElementById("cash").innerHTML = cash;



        }
        else alert("Błędne hasło lub login")


    }


    xhr.send();
}

// const outputId = ` ${userInfo.id}`;
// const outputName = ` ${userInfo.userName}`;
// const outputCash = ` ${userInfo.cash}`;

// document.getElementById('userId').innerHTML = outputId;
/*
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
*/
