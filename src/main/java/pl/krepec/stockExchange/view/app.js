document.getElementById('Submit').addEventListener("click", readJSON);
document.getElementById('Check').addEventListener("click", checkUserNameExist);
document.getElementById('Login').addEventListener("click", logIn);
document.getElementById('AddNewUser').addEventListener("click", addNewUser);


function readJSON(){
    const xhr = new XMLHttpRequest();

    stockSymbol = document.getElementById("stockSymbol").value;

    xhr.open('GET', "https://api.iextrading.com/1.0/stock/"+stockSymbol+"/quote" ,true);

    xhr.onload = function(){
        if(this.status === 200){
            console.log(this.responseText)
            const stockInfo = JSON.parse(this.responseText);
            const output = ` ${stockInfo.symbol}`;
            const output1 = ` ${stockInfo.latestPrice}`;

            document.getElementById('symbol').innerHTML = output;
            document.getElementById('outputLatestPrice').innerHTML = output1;

        }
        else
           alert("Stock symbol doesn't exist")
    }
    xhr.send();

}

function checkUserNameExist(){

const xhr = new XMLHttpRequest();

userName = document.getElementById("userName").value;

xhr.open('GET', "http://localhost:8080/stockexchange/user/check?username="+userName ,true);

xhr.setRequestHeader('Access-Control-Allow-Origin','http://localhost:8080/');
xhr.setRequestHeader('Content-type','application/json');
xhr.setRequestHeader('Access-Control-Allow-Methods','GET');

  xhr.onload = function(){
        if(this.status === 200){
            console.log(this.responseText);
            const userInfo = JSON.parse(this.responseText);


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
const userInfo = JSON.parse(this.responseText)

const outputId = ` ${userInfo.id}`;
const outputName = ` ${userInfo.userName}`;
const outputCash = ` ${userInfo.cash}`;

document.getElementById('userId').innerHTML = outputId;
document.getElementById('userCash').innerHTML = outputCash;
document.getElementById('uName').innerHTML = outputName;

     }
    }
    xhr.send();

}

function addNewUser(){
const xhr = new XMLHttpRequest();
Name = document.getElementById("userName").value;
pass = document.getElementById("password").value;

xhr.open('POST', "http://localhost:8080/stockexchange/user/register", true );
xhr.setRequestHeader("Content-Type", "application/json");
xhr.onload = function(){
  console.log(this.responseText);
}

xhr.send(JSON.stringify({userName:Name, password:pass}));
}

