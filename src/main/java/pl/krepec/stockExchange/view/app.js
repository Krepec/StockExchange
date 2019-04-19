document.getElementById('Submit').addEventListener("click", readJSON);
document.getElementById('Check').addEventListener("click", checkUserNameExist);


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
            console.log(this.responseText)
            const result = JSON.parse(this.responseText)
            const equal = result == "true"
            console.log(typeof result)
            console.log(typeof equal)
            if(result)
            alert("User name exist, choose another one")
            else
            alert("User name don't exist")

        }
    }
    xhr.send();

}



