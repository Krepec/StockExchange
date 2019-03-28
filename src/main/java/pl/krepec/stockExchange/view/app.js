document.getElementById('Submit').addEventListener("click", readJSON);

function readJSON(e){
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

