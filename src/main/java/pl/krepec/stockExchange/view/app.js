document.getElementById('submit').addEventListener("click", readJSON);

// document.getElementById('Check').addEventListener("click", checkUserNameExist);
// document.getElementById('Login').addEventListener("click", logIn);
// document.getElementById('AddNewUser').addEventListener("click", addNewUser);
// document.getElementById('Buy').addEventListener("click", addHistory);
const xhr = new XMLHttpRequest();



function readJSON(){
    
    stockSymbol = document.getElementById("stockSymbol").value;

    xhr.open('GET', "https://cloud.iexapis.com/stable/tops?token=pk_a3e7dd6ef6be498583b1da342ebb6901&symbols="+stockSymbol, true);

    xhr.onload = function(){
        if(this.status === 200){
            console.log(this.responseText)
            const stockInfo = JSON.parse(this.responseText);
            const output1 = ` ${stockInfo[0].lastSalePrice}`;

            document.getElementById('outputLatestPrice').innerHTML = output1 + " zł"; 
        }
        else
           alert("Stock symbol doesn't exist")
    }
    xhr.send();

}

// function checkUserNameExist(){

// const xhr = new XMLHttpRequest();

// userName = document.getElementById("userName").value;

// xhr.open('GET', "http://localhost:8080/stockexchange/user/check?username="+userName ,true);



//   xhr.onload = function(){
//         if(this.status === 200){
//             console.log(this.responseText);
//             const result = JSON.parse(this.responseText);

//            if(result === true)
//            alert("User name exist")
//            else
//            alert("User name doesn't exist")

//         }
//     }
//     xhr.send();

// }

// function logIn(){
// const xhr = new XMLHttpRequest();
// userName = document.getElementById("userName").value;
// password = document.getElementById("password").value;

// xhr.open('GET', "http://localhost:8080/stockexchange/user/login?username="+userName+"&password="+password, true );
// xhr.onload = function(){
//  if(this.status === 200){
// console.log(this.responseText)
// const userInfo = JSON.parse(this.responseText)

// const outputId = ` ${userInfo.id}`;
// const outputName = ` ${userInfo.userName}`;
// const outputCash = ` ${userInfo.cash}`;

// document.getElementById('userId').innerHTML = outputId;
// document.getElementById('userCash').innerHTML = outputCash;
// document.getElementById('uName').innerHTML = outputName;

//      }
//     }
//     xhr.send();

// }

// function addNewUser(){
// const xhr = new XMLHttpRequest();
// name = document.getElementById("userName").value;
// pass = document.getElementById("password").value;

// xhr.open('POST', "http://localhost:8080/stockexchange/user/user", true );
// xhr.setRequestHeader("Content-Type", "application/json");
// xhr.onload = function(){
//   console.log(this.responseText);
//   console.log(name)
//   console.log(pass)
// }

// xhr.send(JSON.stringify({userName:name, password:pass}));
// }


// function addHistory(){
// const xhr = new XMLHttpRequest();
// const operationBuy = "Buy";
// symbol = document.getElementById("symbol").value;
// latestPrice = document.getElementById("outputLatestPrice").value;
// xhr.open('GET', "https://api.iextrading.com/1.0/stock/"+stockSymbol+"/quote" ,true);
// xhr.onload = function(){
//         console.log(this.responseText);
//         const stockInfo = JSON.parse(this.responseText);
//         const stockSymbol = ` ${stockInfo.symbol}`;
//         const latestPrice = ` ${stockInfo.latestPrice}`;
        
//         xhr.open('POST', "http://localhost:8080/stockexchange/history/history", true );
//         xhr.setRequestHeader("Content-Type", "application/json");
//         xhr.send(JSON.stringify({operation:operationBuy, stock_symbol:stockSymbol, stock_price:latestPrice}));
//     }

//     xhr.send()
// }