function mostrarOcultar(n,m){
if(document.getElementById(n).style.display == 'none'){
    document.getElementById(n).style.display = 'block';
}else{
    document.getElementById(n).style.display = 'none';
}    

}


function addExtra(idN,formExtra){
            // Number of inputs to create
            var number = document.getElementById(idN).value;
            // Container <div> where dynamic content will be placed
            var container = document.getElementById(formExtra);
            switch(formExtra){
                case "formGrado2Extra":
                    for (i=container.childElementCount;i<=number;i++){
                        var div = document.createElement("div");
                        var input1 = document.createElement("input");
                        var input2 = document.createElement("input");
                        var input3 = document.createElement("input");
                        var input4 = document.createElement("input");
                        var ayuda = document.createElement("P");
                        input1.type = "text";
                        input1.name = "a" + i;
                        input1.value = "0";
                        input1.size = "1";
                        input1.id= "a" + i;
                        input1.step="0.001";
                        input1.onchange=function(){ComprobarSolucionReal(number);};
                        input2.type = "text";
                        input2.name = "b" + i;
                        input2.value = "0";
                        input2.size = "1";
                        input2.id= "b" + i;
                        input2.step="0.001";
                        input2.onchange=function(){ComprobarSolucionReal(number);};
                        input3.type = "text";
                        input3.name = "c" + i;
                        input3.value = "0";
                        input3.size = "1";
                        input3.id= "c" + i;
                        input3.step="0.001";
                        input3.onchange=function(){ComprobarSolucionReal(number);};
                        ayuda.name = "EcGrado2Ayuda"+i;
                        ayuda.id= "EcGrado2Ayuda"+i;
                        
                        //input4.id="Fijar"
                        
                        div.appendChild(input1);div.appendChild(document.createTextNode("x^2+"));
                        div.appendChild(input2);div.appendChild(document.createTextNode("x+"));
                        div.appendChild(input3);div.appendChild(document.createTextNode("= 0"));
                        div.appendChild(ayuda);
                        container.appendChild(div);
                    }
                break;
                case "formPolinomiosExtra":
                    for (i=container.childElementCount;i<=number;i++){
                        var div = document.createElement("div");
                        var input1 = document.createElement("input");
                        input1.type = "text";
                        input1.name = "Polinomioexpr" + i;
                        input1.value = "0";
                        input1.id= "Polinomioexpr" + i;
                        
                     div.appendChild(document.createTextNode("Polinomio="));div.appendChild(input1);
                     container.appendChild(div);
                    }
                break;
                case "formLogProductoExtra":
                    for (i=container.childElementCount;i<=number;i++){
                        var div = document.createElement("div");
                        var input1 = document.createElement("input");
                        var input2 = document.createElement("input");
                        var input3 = document.createElement("input");
                        input1.type = "text";
                        input1.name = "logProductob" + i;
                        input1.value = "0";
                        input1.size = "1";
                        input1.id= "logProductob" + i;
                        input1.step="0.001";
                        input2.type = "text";
                        input2.name = "logProductox" + i;
                        input2.value = "0";
                        input2.size = "1";
                        input2.id= "logProductox" + i;
                        input2.step="0.001";
                        input3.type = "text";
                        input3.name = "logProductoy" + i;
                        input3.value = "0";
                        input3.size = "1";
                        input3.id= "logProductoy" + i;
                        input3.step="0.001";
                        div.appendChild(document.createTextNode("log"));div.appendChild(input1);div.appendChild(document.createTextNode("("));
                        div.appendChild(input2);div.appendChild(document.createTextNode("*"));
                        div.appendChild(input3);div.appendChild(document.createTextNode(")"));
                        container.appendChild(div);
                    }
                break;
            case "formLogRaizExtra":
                    for (i=container.childElementCount;i<=number;i++){
                        var div = document.createElement("div");
                        var input1 = document.createElement("input");
                        var input2 = document.createElement("input");
                        var input3 = document.createElement("input");
                        input1.type = "text";
                        input1.name = "logRaizb" + i;
                        input1.value = "0";
                        input1.size = "1";
                        input1.id= "logRaizb" + i;
                        input1.step="0.001";
                        input2.type = "text";
                        input2.name = "logRaizy" + i;
                        input2.value = "0";
                        input2.size = "1";
                        input2.id= "logRaizy" + i;
                        input2.step="0.001";
                        input3.type = "text";
                        input3.name = "logRaizx" + i;
                        input3.value = "0";
                        input3.size = "1";
                        input3.id= "logRaizx" + i;
                        input3.step="0.001";
                        div.appendChild(document.createTextNode("log"));div.appendChild(input1);div.appendChild(document.createTextNode("("));
                        div.appendChild(input2);div.appendChild(document.createTextNode("√"));
                        div.appendChild(input3);div.appendChild(document.createTextNode(")"));
                        container.appendChild(div);
                    }
                break;
            case "formLogPotenciaExtra":
                    for (i=container.childElementCount;i<=number;i++){
                        var div = document.createElement("div");
                        var input1 = document.createElement("input");
                        var input2 = document.createElement("input");
                        var input3 = document.createElement("input");
                        input1.type = "text";
                        input1.name = "logPotenciab" + i;
                        input1.value = "0";
                        input1.size = "1";
                        input1.id= "logPotenciab" + i;
                        input1.step="0.001";
                        input2.type = "text";
                        input2.name = "logPotenciax" + i;
                        input2.value = "0";
                        input2.size = "1";
                        input2.id= "logPotenciax" + i;
                        input2.step="0.001";
                        input3.type = "text";
                        input3.name = "logPotenciay" + i;
                        input3.value = "0";
                        input3.size = "1";
                        input3.id= "logPotenciay" + i;
                        input3.step="0.001";
                        div.appendChild(document.createTextNode("log"));div.appendChild(input1);div.appendChild(document.createTextNode("("));
                        div.appendChild(input2);div.appendChild(document.createTextNode("^"));
                        div.appendChild(input3);div.appendChild(document.createTextNode(")"));
                        container.appendChild(div);
                    }
                break;
             case "formLogCocienteExtra":
                    for (i=container.childElementCount;i<=number;i++){
                        var div = document.createElement("div");
                        var input1 = document.createElement("input");
                        var input2 = document.createElement("input");
                        var input3 = document.createElement("input");
                        input1.type = "text";
                        input1.name = "logCocienteb" + i;
                        input1.value = "0";
                        input1.size = "1";
                        input1.id= "logCocienteb" + i;
                        input1.step="0.001";
                        input2.type = "text";
                        input2.name = "logCocientex" + i;
                        input2.value = "0";
                        input2.size = "1";
                        input2.id= "logCocientex" + i;
                        input2.step="0.001";
                        input3.type = "text";
                        input3.name = "logCocientey" + i;
                        input3.value = "0";
                        input3.size = "1";
                        input3.id= "logCocientey" + i;
                        input3.step="0.001";
                        div.appendChild(document.createTextNode("log"));div.appendChild(input1);div.appendChild(document.createTextNode("("));
                        div.appendChild(input2);div.appendChild(document.createTextNode("/"));
                        div.appendChild(input3);div.appendChild(document.createTextNode(")"));
                        container.appendChild(div);
                        
                    }
                    case "formLogLibreExtra":
                    for (i=container.childElementCount;i<=number;i++){
                        var div = document.createElement("div");
                        var input1 = document.createElement("input");
                        var input2 = document.createElement("input");
                        var input3 = document.createElement("input");
                        input1.type = "text";
                        input1.name = "logLibreb" + i;
                        input1.value = "0";
                        input1.size = "1";
                        input1.id= "logLibreb" + i;
                        input1.step="0.001";
                        input2.type = "text";
                        input2.name = "logLibrex" + i;
                        input2.value = "0";
                        input2.size = "10";
                        input2.id= "logLibrex" + i;
                        input2.step="0.001";
                        
                        div.appendChild(document.createTextNode("log"));div.appendChild(input1);div.appendChild(document.createTextNode("("));
                        div.appendChild(input2);div.appendChild(document.createTextNode(")"));
                        container.appendChild(div);
                    }
                break;
                    case "formLogNeperianoExtra":
                    for (i=container.childElementCount;i<=number;i++){
                        var div = document.createElement("div");
                        var input2 = document.createElement("input");
                        input2.type = "text";
                        input2.name = "logNeperianox" + i;
                        input2.value = "0";
                        input2.size = "10";
                        input2.id= "logNeperianox" + i;
                        input2.step="0.001";
                        
                        div.appendChild(document.createTextNode("ln"));div.appendChild(document.createTextNode("("));
                        div.appendChild(input2);div.appendChild(document.createTextNode(")"));
                        container.appendChild(div);
                    }
                break;
                break;
             case "formLimitePolExtra":
                    AddLimite("Pol",container,number);
                break;
            case "formLimiteTriExtra":
                    AddLimite("Tri",container,number);
                break;   
            case "formLimiteCocExtra":
                    AddLimite("Coc",container,number);
                break;   
            case "formLimiteDifExtra":
                    AddLimite("Dif",container,number);
                break;   
            case "formLimiteExpLogExtra":
                    AddLimite("ExpLog",container,number);
                break;       
            case "formDerivadaExtraSim":
                AddDerivada("Sim",container,number);
                break; 
             case "formDerivadaExtraTri":
                AddDerivada("Tri",container,number);
                break; 
            case "formDerivadaExtraPot":
                AddDerivada("Pot",container,number);
                break; 
            case "formDerivadaExtraRaiz":
                AddDerivada("Raiz",container,number);
                break; 
            case "formDerivadaExtraExpLog":
                AddDerivada("ExpLog",container,number);
                break; 
            case "formDerivadaExtraComb":
                AddDerivada("Comb",container,number);
                break;     
            case "formIntegralIndefExtra":
                    for (i=container.childElementCount;i<=number;i++){
                        var div = document.createElement("div");
                        var input1 = document.createElement("input");
                        input1.type = "text";
                        input1.name = "IntegralIndefexpr" + i;
                        input1.value = "0";
                        input1.id= "IntegralIndefexpr" + i;
                        
                     div.appendChild(document.createTextNode("f(x)="));div.appendChild(input1);
                     container.appendChild(div);
                    }
                break;
            case "formIntegralDefExtra":
                    for (i=container.childElementCount;i<=number;i++){
                        var div = document.createElement("div");
                        var input1 = document.createElement("input");
                        var input2 = document.createElement("input");
                        var input3 = document.createElement("input");
                        input1.type = "text";
                        input1.name = "IntegralDefexpr" + i;
                        input1.value = "0";
                        input1.id= "IntegralDefexpr" + i;
                        
                        input2.type = "number";
                        input2.name = "IntegralDefn" + i;
                        input2.value = "0";
                        input2.size = "1";
                        input2.id= "IntegralDefn" + i;
                        
                        input3.type = "number";
                        input3.name = "IntegralDefm" + i;
                        input3.value = "0";
                        input3.size = "1";
                        input3.id= "IntegralDefm" + i;
                     
                     div.appendChild(document.createTextNode("f(x)="));div.appendChild(input1);div.appendChild(document.createElement("br"));
                     div.appendChild(document.createTextNode("n="));div.appendChild(input2);div.appendChild(document.createElement("br"));
                     div.appendChild(document.createTextNode("m="));div.appendChild(input3);
                     container.appendChild(div);
                    }
                break;
             case "formMatrizExtra":
                    for (i=container.childElementCount;i<=number;i++){
                        var div = document.createElement("div");
                        var divaux1 = document.createElement("div");
                        var divaux2 = document.createElement("div");
                        var divaux3 = document.createElement("div");
                        var input1 = document.createElement("input");
                        var input2 = document.createElement("input");
                        //var input3 = document.createElement("input");
                        //var input4 = document.createElement("input");
                        var input5 = document.createElement("select");
                        
                        divaux1.className="col-6";
                        divaux2.className="col-6";divaux2.id="MatrizDiv"+i;
                        divaux3.className="row pt-4";
                       
                        input1.type = "number";
                        input1.name = "Matriz1n" + i;
                        input1.value = "0";
                        input1.size = "1";
                        input1.id= "Matriz1n" + i;
                        input1.min=0;
                        input1.onchange=function(){CambiarMatriz(number);};
                        input2.type = "number";
                        input2.name = "Matriz1m" + i;
                        input2.value = "0";
                        input2.size = "1";
                        input2.id= "Matriz1m" + i;
                        input2.min=0;
                        input2.onchange=function(){CambiarMatriz(number);};
                      
                        input5.name = "MatrizOp" + i;
                        input5.id= "MatrizOp" + i;
                  
                        var option;
                        var inputdata = "*||/||+||-";
                        inputdata.split( '||' ).forEach(function( item ) {
                        option = document.createElement( 'option' );
                        option.value = option.textContent = item;

                        input5.appendChild( option );
                    });

                     divaux1.appendChild(document.createTextNode("Orden Matrices:"));divaux1.appendChild(input1);divaux1.appendChild(input2);
                     divaux1.appendChild(document.createElement("br"));
                     divaux1.appendChild(document.createTextNode("Operacion:"));divaux1.appendChild(input5);divaux1.appendChild(document.createElement("br"));

                     divaux3.appendChild(divaux1);divaux3.appendChild(divaux2);
                     container.appendChild(divaux3);
                    }
                break; 
                case "formMatrizExtraInvert":
                    for (i=container.childElementCount;i<=number;i++){
                        var div = document.createElement("div");
                        var divaux1 = document.createElement("div");
                        var divaux2 = document.createElement("div");
                        var divaux3 = document.createElement("div");
                        var input1 = document.createElement("input");
                        var input2 = document.createElement("input");
                        var input5 = document.createElement("select");
                        
                        divaux1.className="col-6";
                        divaux2.className="col-6";divaux2.id="MatrizInvertDiv"+i;
                        divaux3.className="row  pt-4";
                        
                        input1.type = "number";
                        input1.name = "MatrizInvert1n" + i;
                        input1.value = "0";
                        input1.size = "1";
                        input1.id= "MatrizInvert1n" + i;
                        input1.min=0;
                        input1.onchange=function(){CambiarMatrizInvert(number);};


                     divaux1.appendChild(document.createTextNode("Orden Matriz:"));divaux1.appendChild(input1);
                     divaux1.appendChild(document.createElement("br"));

                     divaux3.appendChild(divaux1);divaux3.appendChild(divaux2);
                     container.appendChild(divaux3);
                    }
                break;    
                case "formMatrizExtraMultM":
                     for (i=container.childElementCount;i<=number;i++){
                        var div = document.createElement("div");
                        var divaux1 = document.createElement("div");
                        var divaux2 = document.createElement("div");
                        var divaux3 = document.createElement("div");
                        var input1 = document.createElement("input");
                        var input2 = document.createElement("input");
                        var input5 = document.createElement("select");
                        
                        divaux1.className="col-6";
                        divaux2.className="col-6";divaux2.id="MatrizMultMDiv"+i;
                        divaux3.className="row  pt-4";
                        
                        input1.type = "number";
                        input1.name = "MatrizMultM1n" + i;
                        input1.value = "0";
                        input1.size = "1";
                        input1.id= "MatrizMultM1n" + i;
                        input1.min=0;
                        input1.onchange=function(){CambiarMatrizMultM(number);};


                     divaux1.appendChild(document.createTextNode("Orden Matrices:"));divaux1.appendChild(input1);
                     divaux1.appendChild(document.createElement("br"));

                     divaux3.appendChild(divaux1);divaux3.appendChild(divaux2);
                     container.appendChild(divaux3);
                    }
                    
                break; 
            }

            while (container.childElementCount>number) {
                container.removeChild(container.lastChild);
            }
        }

function AddLimite(tipo,container,number){
                        for (i=container.childElementCount;i<=number;i++){
                        var div = document.createElement("div");
                        var input1 = document.createElement("input");
                        var input2 = document.createElement("input");
                        input1.type = "text";
                        input1.name = "Limite"+tipo+"exp" + i;
                        input1.value = "0";
                        input1.id= "Limite"+tipo+"exp" + i;
                        
                        input2.type = "text";
                        input2.name = "Limite"+tipo+"val" + i;
                        input2.value = "0";
                        input2.class="w-1 p-0";
                        input2.pattern="(inf)|(minf)|([+]*[-]*[0-9]+)";
                        input2.title="Numero, 'inf' o 'minf'";
                        input2.size = "1";
                        input2.id= "Limite"+tipo+"val" + i;
                     
                     div.appendChild(document.createTextNode("lim"));div.appendChild(input1);div.appendChild(document.createElement("br"));
                     div.appendChild(document.createTextNode("x→"));div.appendChild(input2);
                     container.appendChild(div);
                     
                    }
}

function AddDerivada(tipo,container,number){
                        for (i=container.childElementCount;i<=number;i++){
                        var div = document.createElement("div");
                        var input1 = document.createElement("input");
                        var input2 = document.createElement("input");
                        input1.type = "text";
                        input1.name = "Derivadaexpr" +tipo+ i;
                        input1.value = "0";
                        input1.id= "Derivadaexpr" +tipo+ i;
                        
                        input2.type = "number";
                        input2.name = "Derivadan"+tipo + i;
                        input2.value = "1";
                        input2.min="1";
                        input2.size = "1";
                        input2.id= "Derivadan" +tipo + i;
                     
                     div.appendChild(document.createTextNode("f(x)="));div.appendChild(input1);div.appendChild(document.createElement("br"));
                     div.appendChild(document.createTextNode("n="));div.appendChild(input2);
                     container.appendChild(div);
                    }
}


function CambiarMatriz(num){
    //console.log("-----CambiarMatriz-----");
    
    if(num!=0){
        
        var divprincipal;
        var div1;var n1; var m1; var n2; var m2;
        var div2;var div3;var div4;var div5;
        var input1;
        for(x=0;x<num;x++){
          divprincipal = document.getElementById("MatrizDiv"+x);    //console.log("MatrizDiv:"+x);
          div3=document.createElement("div");
          div3.className="row";
          div4=document.createElement("div");
          div4.className="col";
          div5=document.createElement("div");
          div5.className="col";
          while (divprincipal.childElementCount!=0) {
                divprincipal.removeChild(divprincipal.lastChild);
          }   
          
          n1 = document.getElementById("Matriz1n"+x).value;   //console.log("Matriz1n:"+x);
          m1 = document.getElementById("Matriz1m"+x).value;   //console.log("Matriz1m:"+x);
          for(i=0;i<n1;i++){
            div1 = document.createElement("div");
              //if(i==0){div1.appendChild(document.createTextNode("M1:"));}
            div1.className="row";       //console.log("row:"+i);
            for(j=0;j<m1;j++){
                div2 = document.createElement("div");
               // div2.className="col";
                input1 = document.createElement("input");
                input1.name="MatrizInput[1]"+x+"N"+i+"M"+j;
                input1.id="MatrizInput[1]"+x+"N"+i+"M"+j;
                input1.size="1";
                input1.value="0";
                input1.type="number";
                input1.step="0.001";
                div2.appendChild(input1);
                div1.appendChild(div2);
            }
            div4.appendChild(div1);
            if(i==0){div3.appendChild(document.createTextNode("A="));}div3.appendChild(div4);
           // divprincipal.appendChild(div3);
          }
          //divprincipal.appendChild(div1);
          
          n2 = n1;//document.getElementById("Matriz2n"+x).value;   //console.log("Matriz1n:"+x);
          m2 =m1; //document.getElementById("Matriz2m"+x).value;   //console.log("Matriz1m:"+x);
          for(i=0;i<n2;i++){
            div1 = document.createElement("div");
           // if(i==0){div1.appendChild(document.createTextNode("M2:"));}
            div1.className="row";       //console.log("row:"+i);
            for(j=0;j<m2;j++){
                div2 = document.createElement("div");
                //div2.className="col";
                input1 = document.createElement("input");
                input1.name="MatrizInput[2]"+x+"N"+i+"M"+j;
                input1.id="MatrizInput[2]"+x+"N"+i+"M"+j;
                input1.size="1";
                input1.value="0";
                input1.type="number";
                input1.step="0.001";
                div2.appendChild(input1);
                div1.appendChild(div2);
            }
            div5.appendChild(div1);
            if(i==0){div3.appendChild(document.createTextNode("B="));}div3.appendChild(div5);
            
          }
          divprincipal.appendChild(div3);
          
        }
      
    }
       
}


function CambiarMatrizInvert(num){
    //console.log("-----CambiarMatriz-----");
    
    if(num!=0){
        
        var divprincipal;
        var div1;var n1; var m1; var n2; var m2;
        var div2;var div3;var div4;var div5;
        var input1;
        for(x=0;x<num;x++){
          divprincipal = document.getElementById("MatrizInvertDiv"+x);    //console.log("MatrizDiv:"+x);
          div3=document.createElement("div");
          div3.className="row";
          div4=document.createElement("div");
          div4.className="col";
          div5=document.createElement("div");
          div5.className="col";
          while (divprincipal.childElementCount!=0) {
                divprincipal.removeChild(divprincipal.lastChild);
          }   
          
          n1 = document.getElementById("MatrizInvert1n"+x).value;   //console.log("Matriz1n:"+x);
          m1 = document.getElementById("MatrizInvert1n"+x).value;   //console.log("Matriz1m:"+x);
          for(i=0;i<n1;i++){
            div1 = document.createElement("div");
              //if(i==0){div1.appendChild(document.createTextNode("M1:"));}
            div1.className="row";       //console.log("row:"+i);
            for(j=0;j<m1;j++){
                div2 = document.createElement("div");
               // div2.className="col";
                input1 = document.createElement("input");
                input1.name="MatrizInvertInput[1]"+x+"N"+i+"M"+j;
                input1.id="MatrizInvertInput[1]"+x+"N"+i+"M"+j;
                input1.size="1";
                input1.value="0";
                input1.type="number";
                input1.step="0.001";
                div2.appendChild(input1);
                div1.appendChild(div2);
            }
            div4.appendChild(div1);
            if(i==0){div3.appendChild(document.createTextNode("A="));}
            div3.appendChild(div4);
           // divprincipal.appendChild(div3);
          }
          
          divprincipal.appendChild(div3);
          
        }
      
    }
       
}


function CambiarMatrizMultM(num){
    //console.log("-----CambiarMatriz-----");
    
    if(num!=0){
        
        var divprincipal;
        var div1;var n1; var m1; var n2; var m2;
        var div2;var div3;var div4;var div5;
        var input1;
        for(x=0;x<num;x++){
          divprincipal = document.getElementById("MatrizMultMDiv"+x);    //console.log("MatrizDiv:"+x);
          div3=document.createElement("div");
          div3.className="row";
          div4=document.createElement("div");
          div4.className="col";
          div5=document.createElement("div");
          div5.className="col";
          while (divprincipal.childElementCount!=0) {
                divprincipal.removeChild(divprincipal.lastChild);
          }   
          
          n1 = document.getElementById("MatrizMultM1n"+x).value;   //console.log("Matriz1n:"+x);
          m1 = document.getElementById("MatrizMultM1n"+x).value;   //console.log("Matriz1m:"+x);
          for(i=0;i<n1;i++){
            div1 = document.createElement("div");
              //if(i==0){div1.appendChild(document.createTextNode("M1:"));}
            div1.className="row";       //console.log("row:"+i);
            for(j=0;j<m1;j++){
                div2 = document.createElement("div");
               // div2.className="col";
                input1 = document.createElement("input");
                input1.name="MatrizMultMInput[1]"+x+"N"+i+"M"+j;
                input1.id="MatrizMultMInput[1]"+x+"N"+i+"M"+j;
                input1.size="1";
                input1.value="0";
                input1.type="number";
                input1.step="0.001";
                div2.appendChild(input1);
                div1.appendChild(div2);
            }
            div4.appendChild(div1);
            if(i==0){div3.appendChild(document.createTextNode("A="));}div3.appendChild(div4);
           // divprincipal.appendChild(div3);
          }
          
          
          n2 = n1;//document.getElementById("Matriz2n"+x).value;   //console.log("Matriz1n:"+x);
          m2 =m1; //document.getElementById("Matriz2m"+x).value;   //console.log("Matriz1m:"+x);
          for(i=0;i<n2;i++){
            div1 = document.createElement("div");
           // if(i==0){div1.appendChild(document.createTextNode("M2:"));}
            div1.className="row";       //console.log("row:"+i);
            for(j=0;j<m2;j++){
                div2 = document.createElement("div");
                //div2.className="col";
                input1 = document.createElement("input");
                input1.name="MatrizMultMInput[2]"+x+"N"+i+"M"+j;
                input1.id="MatrizMultMInput[2]"+x+"N"+i+"M"+j;
                input1.size="1";
                input1.value="0";
                input1.type="number";
                input1.step="0.001";
                div2.appendChild(input1);
                div1.appendChild(div2);
            }
            div5.appendChild(div1);
            if(i==0){div3.appendChild(document.createTextNode("B="));}div3.appendChild(div5);
            
          }

          
          divprincipal.appendChild(div3);
          
        }
      
    }
       
}

function MatrizAleatoriaMultM(idn){
   
    var num = document.getElementById(idn).value;
    if(num!=0){
   var n1; var m1; var n2; var m2;
        for(x=0;x<num;x++){
          n1 = document.getElementById("MatrizMultM1n"+x).value;   //console.log("Matriz1n:"+x);
          m1 = document.getElementById("MatrizMultM1n"+x).value;    //console.log("Matriz1m:"+x);
          for(i=0;i<n1;i++){
            for(j=0;j<m1;j++){
                    document.getElementById("MatrizMultMInput[1]"+x+"N"+i+"M"+j).value = aleatorio(document.getElementById("IntervaloMinimoMatrizMult").value,document.getElementById("IntervaloMaximoMatrizMult").value,document.getElementById("SelectMatrizMultMDecimales").value);
            }
          }
       
          n2 = n1;//document.getElementById("Matriz2n"+x).value;   //console.log("Matriz1n:"+x);
          m2 = m1;//document.getElementById("Matriz2m"+x).value;   //console.log("Matriz1m:"+x);
          for(i=0;i<n2;i++){
            for(j=0;j<m2;j++){
                    document.getElementById("MatrizMultMInput[2]"+x+"N"+i+"M"+j).value = aleatorio(document.getElementById("IntervaloMinimoMatrizMult").value,document.getElementById("IntervaloMaximoMatrizMult").value,document.getElementById("SelectMatrizMultMDecimales").value);
            }
          }
        
       
        }
      
    }
    
}

function MatrizAleatoriaInvert(idn){
   
    var num = document.getElementById(idn).value;
    if(num!=0){
   var n1; var m1; var n2; var m2;
        for(x=0;x<num;x++){
          n1 = document.getElementById("MatrizInvert1n"+x).value;   //console.log("Matriz1n:"+x);
          m1 = document.getElementById("MatrizInvert1n"+x).value;    //console.log("Matriz1m:"+x);
          for(i=0;i<n1;i++){
            for(j=0;j<m1;j++){
                    document.getElementById("MatrizInvertInput[1]"+x+"N"+i+"M"+j).value =aleatorio(document.getElementById("IntervaloMinimoMatrizInvert").value,document.getElementById("IntervaloMaximoMatrizInvert").value,document.getElementById("SelectMatrizInvertDecimales").value);
            }
          }
       
        }
      
    }
    
}



function MatrizAleatoria(idn){
 
    var num = document.getElementById(idn).value;
    if(num!=0){
   var n1; var m1; var n2; var m2;
        for(x=0;x<num;x++){
          n1 = document.getElementById("Matriz1n"+x).value;   //console.log("Matriz1n:"+x);
          m1 = document.getElementById("Matriz1m"+x).value;   //console.log("Matriz1m:"+x);
          for(i=0;i<n1;i++){
            for(j=0;j<m1;j++){
                    document.getElementById("MatrizInput[1]"+x+"N"+i+"M"+j).value = aleatorio(document.getElementById("IntervaloMinimoMatriz").value,document.getElementById("IntervaloMaximoMatriz").value,document.getElementById("SelectMatrizDecimales").value);
            }
          }
       
          n2 = n1;//document.getElementById("Matriz2n"+x).value;   //console.log("Matriz1n:"+x);
          m2 = m1;//document.getElementById("Matriz2m"+x).value;   //console.log("Matriz1m:"+x);
          for(i=0;i<n2;i++){
            for(j=0;j<m2;j++){
                    document.getElementById("MatrizInput[2]"+x+"N"+i+"M"+j).value = aleatorio(document.getElementById("IntervaloMinimoMatriz").value,document.getElementById("IntervaloMaximoMatriz").value,document.getElementById("SelectMatrizDecimales").value);
            }
          }
        
        }
      
    }
    
}




function aleatorio(minimo, maximo, decimales) {
    var precision = Math.pow(10, decimales);
    minimo = minimo*precision;
    maximo = maximo*precision;
    
    return Math.floor(Math.random()*(maximo-minimo+1) + minimo) / precision;
}

function generarMonomio(grado, decimales){
    if(grado=="1"){return "("+aleatorio(1, 20, decimales)+"*x)";}
    else{return "("+aleatorio(document.getElementById("IntervaloMinimoPolinomio").value, document.getElementById("IntervaloMaximoPolinomio").value, decimales)+"*x^"+grado+")";}
    
}

function RandomPolinomio(form){
    var container = document.getElementById(form);
    var listaNodosHijos = container.childNodes;
    for (i = 0; i <= container.childElementCount - 1; i++) {
        var listaNodosHijosAux = listaNodosHijos[i].childNodes;
        for (j = 0; j <= listaNodosHijosAux.length - 1; j++) {
                            var toret="";
            if (listaNodosHijosAux[j].nodeName == "INPUT") {
                for(var grado = 1; grado <= document.getElementById("GradoPolinomios").value; grado++){
                    if(grado==1){
                        if(document.getElementById("GradoPolinomios").value<3){toret+=""+aleatorio(document.getElementById("IntervaloMinimoPolinomio").value, document.getElementById("IntervaloMaximoPolinomio").value, document.getElementById("SelectPolinomiosDecimales").value)+"+";}
                        
                        toret+=generarMonomio(grado, document.getElementById("SelectPolinomiosDecimales").value);
                    }else{
                    var k= Math.floor((Math.random() * 2) + 1);
                    if(k==1){ toret+="+";}
                    if(k==2){ toret+="-";}
                    toret+=generarMonomio(grado, document.getElementById("SelectPolinomiosDecimales").value);
                    }
                    }
              document.getElementById(listaNodosHijosAux[j].id).value = toret;     
            }
            
        }
    }
}


function RandomEcLog(form) {
    var container = document.getElementById(form);
    var listaNodosHijos = container.childNodes;
    var selectDecim;var ValMinLog;var ValMaxLog;
    for (i = 0; i <= container.childElementCount - 1; i++) {
        var listaNodosHijosAux = listaNodosHijos[i].childNodes;
        for (j = 0; j <= listaNodosHijosAux.length - 1; j++) {
            if (listaNodosHijosAux[j].nodeName == "INPUT") {
                if (form == "formGrado2Extra") { 
                        document.getElementById(listaNodosHijosAux[j].id).value = aleatorio(document.getElementById("IntervaloMinimoEcGrado2").value,document.getElementById("IntervaloMaximoEcGrado2").value,document.getElementById("SelectEcGrado2Decimales").value);
                } else {
                    
                    switch(form){
                        case "formLogProductoExtra": selectDecim="SelectLogProdDecimales";ValMinLog="IntervaloMinimoLogProd";ValMaxLog="IntervaloMaximoLogProd";break;
                        case "formLogRaizExtra": selectDecim="SelectLogRaizDecimales";ValMinLog="IntervaloMinimoLogRaiz";ValMaxLog="IntervaloMaximoLogRaiz";break;
                        case "formLogPotenciaExtra": selectDecim="SelectLogPotDecimales";ValMinLog="IntervaloMinimoLogPot";ValMaxLog="IntervaloMaximoLogPot";break;
                        case "formLogCocienteExtra": selectDecim="SelectLogCocDecimales";ValMinLog="IntervaloMinimoLogCoc";ValMaxLog="IntervaloMaximoLogCoc";break;
                        case "formLogLibreExtra": selectDecim="SelectLogLibreDecimales";break;
                        case "formLogNeperianoExtra": selectDecim="SelectLogNeperianoDecimales";break;
                     }
                     
                     if(form=="formLogNeperianoExtra"){
                          var x = Math.floor((Math.random() * 5) + 1);
                             if(x==1){
                                document.getElementById(listaNodosHijosAux[j].id).value="%e";
                            }
                            if(x==2){
                                  var a = aleatorio(document.getElementById("IntervaloMinimoLogNeperiano").value,document.getElementById("IntervaloMaximoLogNeperiano").value,document.getElementById(selectDecim).value);
                                  document.getElementById(listaNodosHijosAux[j].id).value="%e*"+a+"";
                            }
                            if(x==3){
                                  var a = aleatorio(document.getElementById("IntervaloMinimoLogNeperiano").value,document.getElementById("IntervaloMaximoLogNeperiano").value,document.getElementById(selectDecim).value);
                                  document.getElementById(listaNodosHijosAux[j].id).value="%e-"+a+"";
                            }
                            if(x==4){
                                  var a = aleatorio(document.getElementById("IntervaloMinimoLogNeperiano").value,document.getElementById("IntervaloMaximoLogNeperiano").value,document.getElementById(selectDecim).value);
                                  document.getElementById(listaNodosHijosAux[j].id).value="%e+"+a+"";
                            }
                            if(x==5){
                                  var a = aleatorio(document.getElementById("IntervaloMinimoLogNeperiano").value,document.getElementById("IntervaloMaximoLogNeperiano").value,document.getElementById(selectDecim).value);
                                  var b = aleatorio(document.getElementById("IntervaloMinimoLogNeperiano").value,document.getElementById("IntervaloMaximoLogNeperiano").value,document.getElementById(selectDecim).value);
                                  document.getElementById(listaNodosHijosAux[j].id).value="(%e+"+a+")*(x/"+b+")";
                            }
                         
                     }else{
                     if(form=="formLogLibreExtra" ){
                        if (listaNodosHijosAux[j].id.indexOf("x") !== -1) {
                            console.log(listaNodosHijosAux[j].id);
                            //aleatorio(2,15,document.getElementById(selectDecim).value);
                             var x = Math.floor((Math.random() * 6) + 1);
                             if(x==1){
                                var a = aleatorio(document.getElementById("IntervaloMinimoLogLibre").value,document.getElementById("IntervaloMaximoLogLibre").value,document.getElementById(selectDecim).value);
                                var b = aleatorio(document.getElementById("IntervaloMinimoLogLibre").value,document.getElementById("IntervaloMaximoLogLibre").value,document.getElementById(selectDecim).value);
                                var c = aleatorio(document.getElementById("IntervaloMinimoLogLibre").value,document.getElementById("IntervaloMaximoLogLibre").value,document.getElementById(selectDecim).value);
                                document.getElementById(listaNodosHijosAux[j].id).value=""+c+"*x"+"+"+a+"*x^2+"+b+"";
                            }
                            if(x==2){
                                  var a = aleatorio(document.getElementById("IntervaloMinimoLogLibre").value,document.getElementById("IntervaloMaximoLogLibre").value,document.getElementById(selectDecim).value);
                                  var b = aleatorio(document.getElementById("IntervaloMinimoLogLibre").value,document.getElementById("IntervaloMaximoLogLibre").value,document.getElementById(selectDecim).value);
                                  var c = aleatorio(document.getElementById("IntervaloMinimoLogLibre").value,document.getElementById("IntervaloMaximoLogLibre").value,document.getElementById(selectDecim).value);
                                  var d = aleatorio(document.getElementById("IntervaloMinimoLogLibre").value,document.getElementById("IntervaloMaximoLogLibre").value,document.getElementById(selectDecim).value);
                                  document.getElementById(listaNodosHijosAux[j].id).value=""+c+"*x"+"+"+a+"*x^2-"+d+"*x^3+"+b+"";
                            }
                            if(x==3){
                            var a = aleatorio(document.getElementById("IntervaloMinimoLogLibre").value,document.getElementById("IntervaloMaximoLogLibre").value,document.getElementById(selectDecim).value);
                            var b = aleatorio(document.getElementById("IntervaloMinimoLogLibre").value,document.getElementById("IntervaloMaximoLogLibre").value,document.getElementById(selectDecim).value);
                            var c = aleatorio(document.getElementById("IntervaloMinimoLogLibre").value,document.getElementById("IntervaloMaximoLogLibre").value,document.getElementById(selectDecim).value);
                            document.getElementById(listaNodosHijosAux[j].id).value="(sin("+b+"*x)+tan("+a+"*x))/(x+"+c+")";
                            }
                            if(x==4){
                                var b = aleatorio(document.getElementById("IntervaloMinimoLogLibre").value,document.getElementById("IntervaloMaximoLogLibre").value,document.getElementById(selectDecim).value);
                                var c = aleatorio(document.getElementById("IntervaloMinimoLogLibre").value,document.getElementById("IntervaloMaximoLogLibre").value,document.getElementById(selectDecim).value);
                                var d = aleatorio(document.getElementById("IntervaloMinimoLogLibre").value,document.getElementById("IntervaloMaximoLogLibre").value,document.getElementById(selectDecim).value);
                                var e = aleatorio(document.getElementById("IntervaloMinimoLogLibre").value,document.getElementById("IntervaloMaximoLogLibre").value,document.getElementById(selectDecim).value);
                                document.getElementById(listaNodosHijosAux[j].id).value="("+c+"*x+"+b+")/("+e+"*x+"+d+")";
                            }
                            if(x==5){
                                var b = aleatorio(document.getElementById("IntervaloMinimoLogLibre").value,document.getElementById("IntervaloMaximoLogLibre").value,document.getElementById(selectDecim).value);
                                var d = aleatorio(document.getElementById("IntervaloMinimoLogLibre").value,document.getElementById("IntervaloMaximoLogLibre").value,document.getElementById(selectDecim).value);
                                var e = aleatorio(document.getElementById("IntervaloMinimoLogLibre").value,document.getElementById("IntervaloMaximoLogLibre").value,document.getElementById(selectDecim).value);
                                var a = aleatorio(document.getElementById("IntervaloMinimoLogLibre").value,document.getElementById("IntervaloMaximoLogLibre").value,document.getElementById(selectDecim).value);
                                var c = aleatorio(document.getElementById("IntervaloMinimoLogLibre").value,document.getElementById("IntervaloMaximoLogLibre").value,document.getElementById(selectDecim).value);
                                var f = aleatorio(document.getElementById("IntervaloMinimoLogLibre").value,document.getElementById("IntervaloMaximoLogLibre").value,document.getElementById(selectDecim).value);
                                document.getElementById(listaNodosHijosAux[j].id).value="(("+b+")/(x^"+e+"+"+d+"))-(("+a+")/(x^"+f+"+"+c+"))";
                            }
                            if(x==6){
                                var a = aleatorio(document.getElementById("IntervaloMinimoLogLibre").value,document.getElementById("IntervaloMaximoLogLibre").value,document.getElementById(selectDecim).value);
                                document.getElementById(listaNodosHijosAux[j].id).value=""+a+"^x";
                            }
                        } else {
                            document.getElementById(listaNodosHijosAux[j].id).value = Math.floor((Math.random() * 15) + 2);
                        }
                    }else{
                        if (listaNodosHijosAux[j].id.indexOf("b") !== -1) {
                            //console.log(listaNodosHijosAux[j].id);
                            document.getElementById(listaNodosHijosAux[j].id).value = Math.floor((Math.random() * 15) + 2);
                        } else {
                            document.getElementById(listaNodosHijosAux[j].id).value = aleatorio(2,15,document.getElementById(selectDecim).value);
                        }
                    }
                     }
                     

                }
            }
        }
    }ComprobarSolucionReal2();
}





function RandomLimite(form){
    var container = document.getElementById(form);
    var listaNodosHijos= container.childNodes;
    var contador;
    for(i=0;i<=container.childElementCount-1;i++){
        var listaNodosHijosAux=listaNodosHijos[i].childNodes;
        contador=0;
        for(j=0;j<=listaNodosHijosAux.length-1;j++){
        if(listaNodosHijosAux[j].nodeName=="INPUT"){
            contador=contador+1;
            if(contador==2){
               var x = Math.floor((Math.random() * 5) + 1);
               if(x==1){document.getElementById(listaNodosHijosAux[j].id).value="inf";}
               if(x==2){document.getElementById(listaNodosHijosAux[j].id).value="minf";}
               if(x==3){document.getElementById(listaNodosHijosAux[j].id).value=0;}
               if(x==4){document.getElementById(listaNodosHijosAux[j].id).value=1;}
               if(x==5){document.getElementById(listaNodosHijosAux[j].id).value=-1;}  
                contador=0;
            }else{
                
                switch(form){
                     case "formLimitePolExtra":
                   var x = Math.floor((Math.random() * 6) + 1);
                if(x==1){
                    var b = aleatorio(document.getElementById("IntervaloMinimoLimitePol").value,document.getElementById("IntervaloMaximoLimitePol").value,document.getElementById("SelectLimitePolDecimales").value);
                    var c = aleatorio(document.getElementById("IntervaloMinimoLimitePol").value,document.getElementById("IntervaloMaximoLimitePol").value,document.getElementById("SelectLimitePolDecimales").value);
                    document.getElementById(listaNodosHijosAux[j].id).value=""+c+"*x+"+b+"";
                }
                if(x==2){
                    var a = aleatorio(document.getElementById("IntervaloMinimoLimitePol").value,document.getElementById("IntervaloMaximoLimitePol").value,document.getElementById("SelectLimitePolDecimales").value);
                    var b = aleatorio(document.getElementById("IntervaloMinimoLimitePol").value,document.getElementById("IntervaloMaximoLimitePol").value,document.getElementById("SelectLimitePolDecimales").value);
                    var c = aleatorio(document.getElementById("IntervaloMinimoLimitePol").value,document.getElementById("IntervaloMaximoLimitePol").value,document.getElementById("SelectLimitePolDecimales").value);
                    document.getElementById(listaNodosHijosAux[j].id).value=""+c+"*x"+"+"+a+"*x^2+"+b+"";
                }
                 if(x==3){
                    var a = aleatorio(document.getElementById("IntervaloMinimoLimitePol").value,document.getElementById("IntervaloMaximoLimitePol").value,document.getElementById("SelectLimitePolDecimales").value);
                    var b = aleatorio(document.getElementById("IntervaloMinimoLimitePol").value,document.getElementById("IntervaloMaximoLimitePol").value,document.getElementById("SelectLimitePolDecimales").value);
                    var c = aleatorio(document.getElementById("IntervaloMinimoLimitePol").value,document.getElementById("IntervaloMaximoLimitePol").value,document.getElementById("SelectLimitePolDecimales").value);
                    var d = aleatorio(document.getElementById("IntervaloMinimoLimitePol").value,document.getElementById("IntervaloMaximoLimitePol").value,document.getElementById("SelectLimitePolDecimales").value);
                    document.getElementById(listaNodosHijosAux[j].id).value=""+c+"*x"+"+"+a+"*x^2+"+d+"*x^3+"+b+"";
                }
                if(x==4){
                    var a = aleatorio(document.getElementById("IntervaloMinimoLimitePol").value,document.getElementById("IntervaloMaximoLimitePol").value,document.getElementById("SelectLimitePolDecimales").value);
                    var b = aleatorio(document.getElementById("IntervaloMinimoLimitePol").value,document.getElementById("IntervaloMaximoLimitePol").value,document.getElementById("SelectLimitePolDecimales").value);
                    var c = aleatorio(document.getElementById("IntervaloMinimoLimitePol").value,document.getElementById("IntervaloMaximoLimitePol").value,document.getElementById("SelectLimitePolDecimales").value);
                    var d = aleatorio(document.getElementById("IntervaloMinimoLimitePol").value,document.getElementById("IntervaloMaximoLimitePol").value,document.getElementById("SelectLimitePolDecimales").value);
                    var e = aleatorio(document.getElementById("IntervaloMinimoLimitePol").value,document.getElementById("IntervaloMaximoLimitePol").value,document.getElementById("SelectLimitePolDecimales").value);
                    document.getElementById(listaNodosHijosAux[j].id).value=""+c+"*x"+"+"+a+"*x^2+"+d+"*x^3+"+e+"*x^4+"+b+"";
                }
                 if(x==5){
                    var a = aleatorio(document.getElementById("IntervaloMinimoLimitePol").value,document.getElementById("IntervaloMaximoLimitePol").value,document.getElementById("SelectLimitePolDecimales").value);
                    var b = aleatorio(document.getElementById("IntervaloMinimoLimitePol").value,document.getElementById("IntervaloMaximoLimitePol").value,document.getElementById("SelectLimitePolDecimales").value);
                    var c = aleatorio(document.getElementById("IntervaloMinimoLimitePol").value,document.getElementById("IntervaloMaximoLimitePol").value,document.getElementById("SelectLimitePolDecimales").value);
                    var d = aleatorio(document.getElementById("IntervaloMinimoLimitePol").value,document.getElementById("IntervaloMaximoLimitePol").value,document.getElementById("SelectLimitePolDecimales").value);
                    var e = aleatorio(document.getElementById("IntervaloMinimoLimitePol").value,document.getElementById("IntervaloMaximoLimitePol").value,document.getElementById("SelectLimitePolDecimales").value);
                    document.getElementById(listaNodosHijosAux[j].id).value=""+c+"*x"+"-"+a+"*x^2+"+d+"*x^3+"+e+"*x^4+"+b+"";
                }
                 if(x==6){
                    var a = aleatorio(document.getElementById("IntervaloMinimoLimitePol").value,document.getElementById("IntervaloMaximoLimitePol").value,document.getElementById("SelectLimitePolDecimales").value);
                    var b = aleatorio(document.getElementById("IntervaloMinimoLimitePol").value,document.getElementById("IntervaloMaximoLimitePol").value,document.getElementById("SelectLimitePolDecimales").value);
                    var c = aleatorio(document.getElementById("IntervaloMinimoLimitePol").value,document.getElementById("IntervaloMaximoLimitePol").value,document.getElementById("SelectLimitePolDecimales").value);
                    var d = aleatorio(document.getElementById("IntervaloMinimoLimitePol").value,document.getElementById("IntervaloMaximoLimitePol").value,document.getElementById("SelectLimitePolDecimales").value);
                    document.getElementById(listaNodosHijosAux[j].id).value=""+c+"*x"+"+"+a+"*x^2-"+d+"*x^3+"+b+"";
                }
                        break;
                    case "formLimiteTriExtra":
                            var x = Math.floor((Math.random() * 15) + 1);
                        if(x==1){
                            var a = aleatorio(document.getElementById("IntervaloMinimoLimiteTri").value,document.getElementById("IntervaloMaximoLimiteTri").value,document.getElementById("SelectLimiteTriDecimales").value);
                            document.getElementById(listaNodosHijosAux[j].id).value="(sin(x)+"+a+")/cos(x)";
                        }
                        if(x==2){
                            document.getElementById(listaNodosHijosAux[j].id).value="(sin(x)+tan(x))/x";
                        }
                        if(x==3){
                            var a = aleatorio(document.getElementById("IntervaloMinimoLimiteTri").value,document.getElementById("IntervaloMaximoLimiteTri").value,document.getElementById("SelectLimiteTriDecimales").value);
                            var b = aleatorio(document.getElementById("IntervaloMinimoLimiteTri").value,document.getElementById("IntervaloMaximoLimiteTri").value,document.getElementById("SelectLimiteTriDecimales").value);
                            document.getElementById(listaNodosHijosAux[j].id).value="tan("+a+"*x)/("+b+"*x)";
                        }
                        if(x==4){
                            var a = aleatorio(document.getElementById("IntervaloMinimoLimiteTri").value,document.getElementById("IntervaloMaximoLimiteTri").value,document.getElementById("SelectLimiteTriDecimales").value);
                            var b = aleatorio(document.getElementById("IntervaloMinimoLimiteTri").value,document.getElementById("IntervaloMaximoLimiteTri").value,document.getElementById("SelectLimiteTriDecimales").value);
                            document.getElementById(listaNodosHijosAux[j].id).value="sin("+a+"*x)*cos("+b+"*x)";
                        }
                        if(x==5){
                            document.getElementById(listaNodosHijosAux[j].id).value="(sin(x))/(1-cos(x))";
                        }
                        if(x==6){
                             var a = aleatorio(document.getElementById("IntervaloMinimoLimiteTri").value,document.getElementById("IntervaloMaximoLimiteTri").value,document.getElementById("SelectLimiteTriDecimales").value);
                            var b = aleatorio(document.getElementById("IntervaloMinimoLimiteTri").value,document.getElementById("IntervaloMaximoLimiteTri").value,document.getElementById("SelectLimiteTriDecimales").value);
                            var c = aleatorio(document.getElementById("IntervaloMinimoLimiteTri").value,document.getElementById("IntervaloMaximoLimiteTri").value,document.getElementById("SelectLimiteTriDecimales").value);
                            document.getElementById(listaNodosHijosAux[j].id).value="(sin("+b+"*x)+tan("+a+"*x))/(x+"+c+")";
                        }
                         if(x==7){document.getElementById(listaNodosHijosAux[j].id).value="asin(x)";}
                         if(x==8){document.getElementById(listaNodosHijosAux[j].id).value="acos(x)";}
                         if(x==9){document.getElementById(listaNodosHijosAux[j].id).value="atan(x)";}
                         if(x==10){document.getElementById(listaNodosHijosAux[j].id).value="sin(x)";}
                         if(x==11){document.getElementById(listaNodosHijosAux[j].id).value="cos(x)";}
                         if(x==12){document.getElementById(listaNodosHijosAux[j].id).value="tan(x)";}
                         if(x==13){document.getElementById(listaNodosHijosAux[j].id).value="cot(x)";}
                         if(x==14){document.getElementById(listaNodosHijosAux[j].id).value="sec(x)";}
                         if(x==15){document.getElementById(listaNodosHijosAux[j].id).value="csc(x)";}
                        break;   
                    case "formLimiteCocExtra":
                             var x = Math.floor((Math.random() * 5) + 1);
                if(x==1){
                    var b = aleatorio(document.getElementById("IntervaloMinimoLimiteCoc").value,document.getElementById("IntervaloMaximoLimiteCoc").value,document.getElementById("SelectLimiteCocDecimales").value);
                    var c = aleatorio(document.getElementById("IntervaloMinimoLimiteCoc").value,document.getElementById("IntervaloMaximoLimiteCoc").value,document.getElementById("SelectLimiteCocDecimales").value);
                    var d = aleatorio(document.getElementById("IntervaloMinimoLimiteCoc").value,document.getElementById("IntervaloMaximoLimiteCoc").value,document.getElementById("SelectLimiteCocDecimales").value);
                    var e = aleatorio(document.getElementById("IntervaloMinimoLimiteCoc").value,document.getElementById("IntervaloMaximoLimiteCoc").value,document.getElementById("SelectLimiteCocDecimales").value);
                    document.getElementById(listaNodosHijosAux[j].id).value="("+c+"*x+"+b+")/("+e+"*x+"+d+")";
                }
                if(x==2){
                    var a = aleatorio(document.getElementById("IntervaloMinimoLimiteCoc").value,document.getElementById("IntervaloMaximoLimiteCoc").value,document.getElementById("SelectLimiteCocDecimales").value);
                    var b = aleatorio(document.getElementById("IntervaloMinimoLimiteCoc").value,document.getElementById("IntervaloMaximoLimiteCoc").value,document.getElementById("SelectLimiteCocDecimales").value);
                    var c = aleatorio(document.getElementById("IntervaloMinimoLimiteCoc").value,document.getElementById("IntervaloMaximoLimiteCoc").value,document.getElementById("SelectLimiteCocDecimales").value);
                    var d = aleatorio(document.getElementById("IntervaloMinimoLimiteCoc").value,document.getElementById("IntervaloMaximoLimiteCoc").value,document.getElementById("SelectLimiteCocDecimales").value);
                    var e = aleatorio(document.getElementById("IntervaloMinimoLimiteCoc").value,document.getElementById("IntervaloMaximoLimiteCoc").value,document.getElementById("SelectLimiteCocDecimales").value);
                    var f = aleatorio(document.getElementById("IntervaloMinimoLimiteCoc").value,document.getElementById("IntervaloMaximoLimiteCoc").value,document.getElementById("SelectLimiteCocDecimales").value);
                    document.getElementById(listaNodosHijosAux[j].id).value="("+c+"*x"+"+"+a+"*x^2+"+b+")/("+e+"*x"+"+"+d+"*x^2+"+f+")";
                }
                 if(x==3){
                    var a = aleatorio(document.getElementById("IntervaloMinimoLimiteCoc").value,document.getElementById("IntervaloMaximoLimiteCoc").value,document.getElementById("SelectLimiteCocDecimales").value);
                    var b = aleatorio(document.getElementById("IntervaloMinimoLimiteCoc").value,document.getElementById("IntervaloMaximoLimiteCoc").value,document.getElementById("SelectLimiteCocDecimales").value);
                    var c = aleatorio(document.getElementById("IntervaloMinimoLimiteCoc").value,document.getElementById("IntervaloMaximoLimiteCoc").value,document.getElementById("SelectLimiteCocDecimales").value);
                    var d = aleatorio(document.getElementById("IntervaloMinimoLimiteCoc").value,document.getElementById("IntervaloMaximoLimiteCoc").value,document.getElementById("SelectLimiteCocDecimales").value);
                    var e = aleatorio(document.getElementById("IntervaloMinimoLimiteCoc").value,document.getElementById("IntervaloMaximoLimiteCoc").value,document.getElementById("SelectLimiteCocDecimales").value);
                    var f = aleatorio(document.getElementById("IntervaloMinimoLimiteCoc").value,document.getElementById("IntervaloMaximoLimiteCoc").value,document.getElementById("SelectLimiteCocDecimales").value);
                    var g = aleatorio(document.getElementById("IntervaloMinimoLimiteCoc").value,document.getElementById("IntervaloMaximoLimiteCoc").value,document.getElementById("SelectLimiteCocDecimales").value);
                    var h = aleatorio(document.getElementById("IntervaloMinimoLimiteCoc").value,document.getElementById("IntervaloMaximoLimiteCoc").value,document.getElementById("SelectLimiteCocDecimales").value);
                    document.getElementById(listaNodosHijosAux[j].id).value="("+c+"*x"+"+"+a+"*x^2+"+d+"*x^3+"+b+")/("+g+"*x"+"+"+e+"*x^2+"+h+"*x^3+"+f+")";
                }
                if(x==4){
                   var b = aleatorio(document.getElementById("IntervaloMinimoLimiteCoc").value,document.getElementById("IntervaloMaximoLimiteCoc").value,document.getElementById("SelectLimiteCocDecimales").value);
                    var c = aleatorio(document.getElementById("IntervaloMinimoLimiteCoc").value,document.getElementById("IntervaloMaximoLimiteCoc").value,document.getElementById("SelectLimiteCocDecimales").value);
                    var d = aleatorio(document.getElementById("IntervaloMinimoLimiteCoc").value,document.getElementById("IntervaloMaximoLimiteCoc").value,document.getElementById("SelectLimiteCocDecimales").value);
                    var e = aleatorio(document.getElementById("IntervaloMinimoLimiteCoc").value,document.getElementById("IntervaloMaximoLimiteCoc").value,document.getElementById("SelectLimiteCocDecimales").value);
                    document.getElementById(listaNodosHijosAux[j].id).value="(x^"+c+"+"+b+")/(x^"+e+"+"+d+")";
                }
                if(x==5){
                   var b = aleatorio(document.getElementById("IntervaloMinimoLimiteCoc").value,document.getElementById("IntervaloMaximoLimiteCoc").value,document.getElementById("SelectLimiteCocDecimales").value);
                    var c = aleatorio(document.getElementById("IntervaloMinimoLimiteCoc").value,document.getElementById("IntervaloMaximoLimiteCoc").value,document.getElementById("SelectLimiteCocDecimales").value);
                    var d = aleatorio(document.getElementById("IntervaloMinimoLimiteCoc").value,document.getElementById("IntervaloMaximoLimiteCoc").value,document.getElementById("SelectLimiteCocDecimales").value);
                    var e = aleatorio(document.getElementById("IntervaloMinimoLimiteCoc").value,document.getElementById("IntervaloMaximoLimiteCoc").value,document.getElementById("SelectLimiteCocDecimales").value);
                    document.getElementById(listaNodosHijosAux[j].id).value="("+b+")/(x^"+e+"+"+d+")";
                }

                        break;   
                    case "formLimiteDifExtra":
                           var x = Math.floor((Math.random() * 4) + 1);
                if(x==1){
                    var a = aleatorio(document.getElementById("IntervaloMinimoLimiteDife").value,document.getElementById("IntervaloMaximoLimiteDife").value,document.getElementById("SelectLimiteDifeDecimales").value);
                    var b =  aleatorio(document.getElementById("IntervaloMinimoLimiteDife").value,document.getElementById("IntervaloMaximoLimiteDife").value,document.getElementById("SelectLimiteDifeDecimales").value);
                    var c =  aleatorio(document.getElementById("IntervaloMinimoLimiteDife").value,document.getElementById("IntervaloMaximoLimiteDife").value,document.getElementById("SelectLimiteDifeDecimales").value);
                    var d = aleatorio(document.getElementById("IntervaloMinimoLimiteDife").value,document.getElementById("IntervaloMaximoLimiteDife").value,document.getElementById("SelectLimiteDifeDecimales").value);
                    var e =  aleatorio(document.getElementById("IntervaloMinimoLimiteDife").value,document.getElementById("IntervaloMaximoLimiteDife").value,document.getElementById("SelectLimiteDifeDecimales").value);
                    var f = aleatorio(document.getElementById("IntervaloMinimoLimiteDife").value,document.getElementById("IntervaloMaximoLimiteDife").value,document.getElementById("SelectLimiteDifeDecimales").value);
                    var g =  aleatorio(document.getElementById("IntervaloMinimoLimiteDife").value,document.getElementById("IntervaloMaximoLimiteDife").value,document.getElementById("SelectLimiteDifeDecimales").value);
                    var h = aleatorio(document.getElementById("IntervaloMinimoLimiteDife").value,document.getElementById("IntervaloMaximoLimiteDife").value,document.getElementById("SelectLimiteDifeDecimales").value);
                    document.getElementById(listaNodosHijosAux[j].id).value="(("+b+"*x+"+a+")/("+d+"*x+"+c+"))-(("+f+"*x+"+e+")/("+h+"*x+"+g+"))";
                }
                if(x==2){
                   var b =  aleatorio(document.getElementById("IntervaloMinimoLimiteDife").value,document.getElementById("IntervaloMaximoLimiteDife").value,document.getElementById("SelectLimiteDifeDecimales").value);
                    var c = aleatorio(document.getElementById("IntervaloMinimoLimiteDife").value,document.getElementById("IntervaloMaximoLimiteDife").value,document.getElementById("SelectLimiteDifeDecimales").value);
                    var d =  aleatorio(document.getElementById("IntervaloMinimoLimiteDife").value,document.getElementById("IntervaloMaximoLimiteDife").value,document.getElementById("SelectLimiteDifeDecimales").value);
                    var e = aleatorio(document.getElementById("IntervaloMinimoLimiteDife").value,document.getElementById("IntervaloMaximoLimiteDife").value,document.getElementById("SelectLimiteDifeDecimales").value);
                    var a =  aleatorio(document.getElementById("IntervaloMinimoLimiteDife").value,document.getElementById("IntervaloMaximoLimiteDife").value,document.getElementById("SelectLimiteDifeDecimales").value);
                    var f = aleatorio(document.getElementById("IntervaloMinimoLimiteDife").value,document.getElementById("IntervaloMaximoLimiteDife").value,document.getElementById("SelectLimiteDifeDecimales").value);
                    var g =  aleatorio(document.getElementById("IntervaloMinimoLimiteDife").value,document.getElementById("IntervaloMaximoLimiteDife").value,document.getElementById("SelectLimiteDifeDecimales").value);
                    var h = aleatorio(document.getElementById("IntervaloMinimoLimiteDife").value,document.getElementById("IntervaloMaximoLimiteDife").value,document.getElementById("SelectLimiteDifeDecimales").value);
                    document.getElementById(listaNodosHijosAux[j].id).value="((x^"+c+"+"+b+")/(x^"+e+"+"+d+"))-((x^"+f+"+"+a+")/(x^"+h+"+"+g+"))";
                }
                if(x==3){
                   var b =  aleatorio(document.getElementById("IntervaloMinimoLimiteDife").value,document.getElementById("IntervaloMaximoLimiteDife").value,document.getElementById("SelectLimiteDifeDecimales").value);
                    var d =  aleatorio(document.getElementById("IntervaloMinimoLimiteDife").value,document.getElementById("IntervaloMaximoLimiteDife").value,document.getElementById("SelectLimiteDifeDecimales").value);
                    var e = aleatorio(document.getElementById("IntervaloMinimoLimiteDife").value,document.getElementById("IntervaloMaximoLimiteDife").value,document.getElementById("SelectLimiteDifeDecimales").value);
                     var a =  aleatorio(document.getElementById("IntervaloMinimoLimiteDife").value,document.getElementById("IntervaloMaximoLimiteDife").value,document.getElementById("SelectLimiteDifeDecimales").value);
                    var c =  aleatorio(document.getElementById("IntervaloMinimoLimiteDife").value,document.getElementById("IntervaloMaximoLimiteDife").value,document.getElementById("SelectLimiteDifeDecimales").value);
                    var f =aleatorio(document.getElementById("IntervaloMinimoLimiteDife").value,document.getElementById("IntervaloMaximoLimiteDife").value,document.getElementById("SelectLimiteDifeDecimales").value);
                    document.getElementById(listaNodosHijosAux[j].id).value="(("+b+")/(x^"+e+"+"+d+"))-(("+a+")/(x^"+f+"+"+c+"))";
                }   
                if(x==4){
                   var b =  aleatorio(document.getElementById("IntervaloMinimoLimiteDife").value,document.getElementById("IntervaloMaximoLimiteDife").value,document.getElementById("SelectLimiteDifeDecimales").value);
                    var d =  aleatorio(document.getElementById("IntervaloMinimoLimiteDife").value,document.getElementById("IntervaloMaximoLimiteDife").value,document.getElementById("SelectLimiteDifeDecimales").value);
                    var e = aleatorio(document.getElementById("IntervaloMinimoLimiteDife").value,document.getElementById("IntervaloMaximoLimiteDife").value,document.getElementById("SelectLimiteDifeDecimales").value);
                     var a =  aleatorio(document.getElementById("IntervaloMinimoLimiteDife").value,document.getElementById("IntervaloMaximoLimiteDife").value,document.getElementById("SelectLimiteDifeDecimales").value);
                    var f = aleatorio(document.getElementById("IntervaloMinimoLimiteDife").value,document.getElementById("IntervaloMaximoLimiteDife").value,document.getElementById("SelectLimiteDifeDecimales").value);
                    var g =  aleatorio(document.getElementById("IntervaloMinimoLimiteDife").value,document.getElementById("IntervaloMaximoLimiteDife").value,document.getElementById("SelectLimiteDifeDecimales").value);
                    var h = aleatorio(document.getElementById("IntervaloMinimoLimiteDife").value,document.getElementById("IntervaloMaximoLimiteDife").value,document.getElementById("SelectLimiteDifeDecimales").value);
                    document.getElementById(listaNodosHijosAux[j].id).value="(("+b+")/(x^"+e+"+"+d+"))-((x^"+f+"+"+a+")/(x^"+h+"+"+g+"))";
                }   
                        break;   
                    case "formLimiteExpLogExtra":
                            var x = Math.floor((Math.random() * 5) + 1);
                            if(x==1){
                                var a = aleatorio(document.getElementById("IntervaloMinimoLimiteExpLog").value,document.getElementById("IntervaloMaximoLimiteExpLog").value,document.getElementById("SelectLimiteExpLogDecimales").value);
                                document.getElementById(listaNodosHijosAux[j].id).value=""+a+"^x";
                            }
                             if(x==2){
                                var a = aleatorio(document.getElementById("IntervaloMinimoLimiteExpLog").value,document.getElementById("IntervaloMaximoLimiteExpLog").value,document.getElementById("SelectLimiteExpLogDecimales").value);
                                document.getElementById(listaNodosHijosAux[j].id).value=""+a+"^-x";
                            }
                            if(x==3){
                                var a = aleatorio(document.getElementById("IntervaloMinimoLimiteExpLog").value,document.getElementById("IntervaloMaximoLimiteExpLog").value,document.getElementById("SelectLimiteExpLogDecimales").value);
                                var b = aleatorio(document.getElementById("IntervaloMinimoLimiteExpLog").value,document.getElementById("IntervaloMaximoLimiteExpLog").value,document.getElementById("SelectLimiteExpLogDecimales").value);
                                document.getElementById(listaNodosHijosAux[j].id).value="("+a+"^x)/("+b+"^x)";
                            }
                            if(x==4){
                                var a = aleatorio(document.getElementById("IntervaloMinimoLimiteExpLog").value,document.getElementById("IntervaloMaximoLimiteExpLog").value,document.getElementById("SelectLimiteExpLogDecimales").value);
                                 document.getElementById(listaNodosHijosAux[j].id).value="-"+a+"^x";
                            }
                             if(x==5){
                                var a = aleatorio(document.getElementById("IntervaloMinimoLimiteExpLog").value,document.getElementById("IntervaloMaximoLimiteExpLog").value,document.getElementById("SelectLimiteExpLogDecimales").value);
                                 document.getElementById(listaNodosHijosAux[j].id).value="log(x)*"+a+"";
                            }
                           
                        break;       
                    
                }
                
              
            }
     }
    }
    }
}

function RandomDerivada(form){
    var container = document.getElementById(form);
    var listaNodosHijos= container.childNodes;
     var contador;
    for(i=0;i<=container.childElementCount-1;i++){
        var listaNodosHijosAux=listaNodosHijos[i].childNodes;
        contador=0;
        for(j=0;j<=listaNodosHijosAux.length-1;j++){
            if(listaNodosHijosAux[j].nodeName=="INPUT"){
                            contador=contador+1;
            if(contador==2){
               var x = Math.floor((Math.random() * 5) + 1); 
                contador=0;
            }else{
                
                switch(form){
                    case "formDerivadaExtraSim":
                        var y = Math.floor((Math.random() * 4) + 1);
                        var a = aleatorio(document.getElementById("IntervaloMinimoDerivadaSim").value,document.getElementById("IntervaloMaximoDerivadaSim").value,document.getElementById("SelectDerivadaSimDecimales").value);
                        var b = aleatorio(document.getElementById("IntervaloMinimoDerivadaSim").value,document.getElementById("IntervaloMaximoDerivadaSim").value,document.getElementById("SelectDerivadaSimDecimales").value);
                        if(y==1){document.getElementById(listaNodosHijosAux[j].id).value="x";}
                        if(y==2){document.getElementById(listaNodosHijosAux[j].id).value=""+a+"";}
                        if(y==3){document.getElementById(listaNodosHijosAux[j].id).value=""+a+"*x";;}
                        if(y==4){document.getElementById(listaNodosHijosAux[j].id).value=""+a+"*x-"+b+"";}
                        break;
                    case "formDerivadaExtraTri":
                        var y = Math.floor((Math.random() * 9) + 1);
                        if(y==1){document.getElementById(listaNodosHijosAux[j].id).value="asin(x)";}
                        if(y==2){document.getElementById(listaNodosHijosAux[j].id).value="acos(x)";}
                        if(y==3){document.getElementById(listaNodosHijosAux[j].id).value="atan(x)";}
                        if(y==4){document.getElementById(listaNodosHijosAux[j].id).value="sin(x)";}
                        if(y==5){document.getElementById(listaNodosHijosAux[j].id).value="cos(x)";}
                        if(y==6){document.getElementById(listaNodosHijosAux[j].id).value="tan(x)";}
                        if(y==7){document.getElementById(listaNodosHijosAux[j].id).value="cot(x)";}
                        if(y==8){document.getElementById(listaNodosHijosAux[j].id).value="sec(x)";}
                        if(y==9){document.getElementById(listaNodosHijosAux[j].id).value="csc(x)";}
                        break;
                    case "formDerivadaExtraPot":
                         var y = Math.floor((Math.random() * 3) + 1);
                    var a =aleatorio(document.getElementById("IntervaloMinimoDerivadaPot").value,document.getElementById("IntervaloMaximoDerivadaPot").value,document.getElementById("SelectDerivadaPotDecimales").value);
                    var b = aleatorio(document.getElementById("IntervaloMinimoDerivadaPot").value,document.getElementById("IntervaloMaximoDerivadaPot").value,document.getElementById("SelectDerivadaPotDecimales").value);
                    var c = aleatorio(document.getElementById("IntervaloMinimoDerivadaPot").value,document.getElementById("IntervaloMaximoDerivadaPot").value,document.getElementById("SelectDerivadaPotDecimales").value);
                    var d = aleatorio(document.getElementById("IntervaloMinimoDerivadaPot").value,document.getElementById("IntervaloMaximoDerivadaPot").value,document.getElementById("SelectDerivadaPotDecimales").value);
                     if(y==1){document.getElementById(listaNodosHijosAux[j].id).value=""+b+"*x^"+a+"";}
                     if(y==2){document.getElementById(listaNodosHijosAux[j].id).value="1/x^"+a+"";}
                     if(y==3){document.getElementById(listaNodosHijosAux[j].id).value="("+b+"*x^"+a+"+"+d+")^"+c+"";}
                        break;
                    case "formDerivadaExtraRaiz":
                        var y = Math.floor((Math.random() * 3) + 1);
                        var a = aleatorio(document.getElementById("IntervaloMinimoDerivadaRaiz").value,document.getElementById("IntervaloMaximoDerivadaRaiz").value,document.getElementById("SelectDerivadaRaizDecimales").value);
                        var c = aleatorio(document.getElementById("IntervaloMinimoDerivadaRaiz").value,document.getElementById("IntervaloMaximoDerivadaRaiz").value,document.getElementById("SelectDerivadaRaizDecimales").value);
                        var b = aleatorio(document.getElementById("IntervaloMinimoDerivadaRaiz").value,document.getElementById("IntervaloMaximoDerivadaRaiz").value,document.getElementById("SelectDerivadaRaizDecimales").value);
                        if(y==1){document.getElementById(listaNodosHijosAux[j].id).value="sqrt(x)+"+a+"";}
                        if(y==2){document.getElementById(listaNodosHijosAux[j].id).value="sqrt(x^"+b+")";}
                        if(y==3){document.getElementById(listaNodosHijosAux[j].id).value="("+a+"*x)/"+c+"*(sqrt(x))";}
                        break;
                    case "formDerivadaExtraExpLog":
                        var y = Math.floor((Math.random() * 4) + 1);
                        var a = aleatorio(document.getElementById("IntervaloMinimoDerivadaExpLog").value,document.getElementById("IntervaloMaximoDerivadaExpLog").value,document.getElementById("SelectDerivadaExpLogDecimales").value);
                     if(y==1){document.getElementById(listaNodosHijosAux[j].id).value=""+a+"^x";}
                     if(y==2){document.getElementById(listaNodosHijosAux[j].id).value="%e^(x+"+a+")";}
                     if(y==3){a = aleatorio(document.getElementById("IntervaloMinimoDerivadaExpLog").value,document.getElementById("IntervaloMaximoDerivadaExpLog").value,document.getElementById("SelectDerivadaExpLogDecimales").value);document.getElementById(listaNodosHijosAux[j].id).value=""+a+"+log(x)";  }
                     if(y==4){ var b = aleatorio(document.getElementById("IntervaloMinimoDerivadaExpLog").value,document.getElementById("IntervaloMaximoDerivadaExpLog").value,document.getElementById("SelectDerivadaExpLogDecimales").value);document.getElementById(listaNodosHijosAux[j].id).value=""+a+"^(x+"+b+")";}   
                        break;
                  case "formDerivadaExtraComb":
                        let arrayTipos = [];
                        
                        if(document.getElementById("checkboxDerivadaSim").checked){arrayTipos.push("Sim");}
                        if(document.getElementById("checkboxDerivadaTri").checked){arrayTipos.push("Tri");}
                        if(document.getElementById("checkboxDerivadaPot").checked){arrayTipos.push("Pot");}
                        if(document.getElementById("checkboxDerivadaRaiz").checked){arrayTipos.push("Raiz");}
                        if(document.getElementById("checkboxDerivadaExpLog").checked){arrayTipos.push("ExpLog");}
                        let tipo1=arrayTipos[Math.floor((Math.random() * arrayTipos.length))];
                        let tipo2=arrayTipos[Math.floor((Math.random() * arrayTipos.length))];
                        
                            if(arrayTipos.length==0){
                                var tipo1F="0";
                                var tipo2F="0";
                            }else{
                            var tipo1F= ElegirTipoF(tipo1,"SelectDerivadaCombDecimales",document.getElementById("IntervaloMinimoDerivadaComb").value,document.getElementById("IntervaloMaximoDerivadaComb").value);
                            var tipo2F= ElegirTipoF(tipo2,"SelectDerivadaCombDecimales",document.getElementById("IntervaloMinimoDerivadaComb").value,document.getElementById("IntervaloMaximoDerivadaComb").value);
                            }

                        let arrayOperaciones = [];
                        if(document.getElementById("checkboxDerivadaOpMult").checked){arrayOperaciones.push("*");}
                        if(document.getElementById("checkboxDerivadaOpDiv").checked){arrayOperaciones.push("/");}
                        if(document.getElementById("checkboxDerivadaOpSum").checked){arrayOperaciones.push("+");}
                        let tipoOperacion1=arrayOperaciones[Math.floor((Math.random() * arrayOperaciones.length))];
                        
                    if(arrayOperaciones.length==0 || arrayTipos.length==0){
                        let tipoOperacion1="";
                        document.getElementById(listaNodosHijosAux[j].id).value=""+tipo1F+"";
                    }else{
                        let tipoOperacion1=arrayOperaciones[Math.floor((Math.random() * arrayOperaciones.length))];
                        document.getElementById(listaNodosHijosAux[j].id).value="("+tipo1F+")"+tipoOperacion1+"("+tipo2F+")";
                    }
                        
                        break;      
                }
                

            }
     }
    }
    }
}

function ElegirTipoF(t,decimales,min,max){
    switch(t){
        case "Sim": 
                        var y = Math.floor((Math.random() * 4) + 1);
                        var a = aleatorio(min,max,document.getElementById(decimales).value);
                        var b = aleatorio(min,max,document.getElementById(decimales).value);
                        if(y==1){return "x";}
                        if(y==2){return ""+a+"";}
                        if(y==3){return ""+a+"*x";;}
                        if(y==4){return ""+a+"*x-"+b+"";}
                        break;
            
        case "Tri":     var y = Math.floor((Math.random() * 9) + 1);
                        if(y==1){return "asin(x)";}
                        if(y==2){return "acos(x)";}
                        if(y==3){return "atan(x)";}
                        if(y==4){return "sin(x)";}
                        if(y==5){return "cos(x)";}
                        if(y==6){return "tan(x)";}
                        if(y==7){return "cot(x)";}
                        if(y==8){return "sec(x)";}
                        if(y==9){return "csc(x)";}
                        break;
        case "Pot":     var y = Math.floor((Math.random() * 3) + 1);
                        var a = aleatorio(min,max,document.getElementById(decimales).value);
                        var b = aleatorio(min,max,document.getElementById(decimales).value);
                        var c = aleatorio(min,max,document.getElementById(decimales).value);
                        var d = aleatorio(min,max,document.getElementById(decimales).value);
                         if(y==1){return ""+b+"*x^"+a+"";}
                         if(y==2){return "1/x^"+a+"";}
                         if(y==3){return "("+b+"*x^"+a+"+"+d+")^"+c+"";}
                             break;
        case "Raiz":    var y = Math.floor((Math.random() * 3) + 1);
                        var a = aleatorio(min,max,document.getElementById(decimales).value);
                        var c = aleatorio(min,max,document.getElementById(decimales).value);
                        var b = aleatorio(min,max,document.getElementById(decimales).value);
                        if(y==1){return "sqrt(x)+"+a+"";}
                        if(y==2){return "sqrt(x^"+b+")";}
                        if(y==3){return "("+a+"*x)/"+c+"*(sqrt(x))";}
            break;
        case "ExpLog":  var y = Math.floor((Math.random() * 4) + 1);
                        var a = aleatorio(min,max,document.getElementById(decimales).value);
                        if(y==1){return ""+a+"^x";}
                        if(y==2){return "%e^(x+"+a+")";}
                        if(y==3){a = aleatorio(min,max,document.getElementById(decimales).value);return ""+a+"+log(x)";  }
                        if(y==4){ var b = aleatorio(min,max,document.getElementById(decimales).value);return ""+a+"^(x+"+b+")";}   
            break;
    }
    
}


function RandomIntegralIndef(form){
 
    var container = document.getElementById(form);
    var listaNodosHijos= container.childNodes;
   
    for(i=0;i<=container.childElementCount-1;i++){
        var listaNodosHijosAux=listaNodosHijos[i].childNodes;
        for(j=0;j<=listaNodosHijosAux.length-1;j++){
        if(listaNodosHijosAux[j].nodeName=="INPUT"){
            let arrayTipos = [];
            if(document.getElementById("checkboxIntegralIndefSim").checked){arrayTipos.push("Sim");}
            if(document.getElementById("checkboxIntegralIndefTri").checked){arrayTipos.push("Tri");}
            if(document.getElementById("checkboxIntegralIndefPot").checked){arrayTipos.push("Pot");}
            if(document.getElementById("checkboxIntegralIndefRaiz").checked){arrayTipos.push("Raiz");}
            if(document.getElementById("checkboxIntegralIndefExpLog").checked){arrayTipos.push("ExpLog");}
            let tipo1=arrayTipos[Math.floor((Math.random() * arrayTipos.length))];
            let tipo2=arrayTipos[Math.floor((Math.random() * arrayTipos.length))];

            if(arrayTipos.length==0){
                var tipo1F="0";
                var tipo2F="0";
            }else{
            var tipo1F= ElegirTipoF(tipo1,"SelectIntegralIndefCombDecimales",document.getElementById("IntervaloMinimoIntegralIndefComb").value,document.getElementById("IntervaloMaximoIntegralIndefComb").value);
            var tipo2F= ElegirTipoF(tipo2,"SelectIntegralIndefCombDecimales",document.getElementById("IntervaloMinimoIntegralIndefComb").value,document.getElementById("IntervaloMaximoIntegralIndefComb").value);
            }
            let arrayOperaciones = [];
            if(document.getElementById("checkboxIntegralIndefOpMult").checked){arrayOperaciones.push("*");}
            if(document.getElementById("checkboxIntegralIndefOpDiv").checked){arrayOperaciones.push("/");}
            if(document.getElementById("checkboxIntegralIndefOpSum").checked){arrayOperaciones.push("+");}
            if(arrayOperaciones.length==0 || arrayTipos.length==0){
                var tipoOperacion1="";
                document.getElementById(listaNodosHijosAux[j].id).value=""+tipo1F+"";
            }else{
                var tipoOperacion1=arrayOperaciones[Math.floor((Math.random() * arrayOperaciones.length))];
                document.getElementById(listaNodosHijosAux[j].id).value="("+tipo1F+")"+tipoOperacion1+"("+tipo2F+")";
            }
       
    
     }
    }
    }
}

function RandomIntegralDef(form){
    var container = document.getElementById(form);
    var listaNodosHijos= container.childNodes;
     var contador;
     var aux1;
     var aux2;
    for(i=0;i<=container.childElementCount-1;i++){
        var listaNodosHijosAux=listaNodosHijos[i].childNodes;
        contador=0;
        for(j=0;j<=listaNodosHijosAux.length-1;j++){
            if(listaNodosHijosAux[j].nodeName=="INPUT"){
                            contador=contador+1;
            if(contador==2){
             aux1= document.getElementById(listaNodosHijosAux[j].id)
             //contador=0;
            }
            if(contador==3){
             aux2= document.getElementById(listaNodosHijosAux[j].id)
                contador=0;
            }
            if(contador==1){

             let arrayTipos = [];
            if(document.getElementById("checkboxIntegralDefSim").checked){arrayTipos.push("Sim");}
            if(document.getElementById("checkboxIntegralDefTri").checked){arrayTipos.push("Tri");}
            if(document.getElementById("checkboxIntegralDefPot").checked){arrayTipos.push("Pot");}
            if(document.getElementById("checkboxIntegralDefRaiz").checked){arrayTipos.push("Raiz");}
            if(document.getElementById("checkboxIntegralDefExpLog").checked){arrayTipos.push("ExpLog");}
            let tipo1=arrayTipos[Math.floor((Math.random() * arrayTipos.length))];
            let tipo2=arrayTipos[Math.floor((Math.random() * arrayTipos.length))];

            if(arrayTipos.length==0){
                var tipo1F="0";
                var tipo2F="0";
            }else{
            var tipo1F= ElegirTipoF(tipo1,"SelectIntegralDefCombDecimales",document.getElementById("IntervaloMinimoIntegralDefComb").value,document.getElementById("IntervaloMaximoIntegralDefComb").value);
            var tipo2F= ElegirTipoF(tipo2,"SelectIntegralDefCombDecimales",document.getElementById("IntervaloMinimoIntegralDefComb").value,document.getElementById("IntervaloMaximoIntegralDefComb").value);
            }
            let arrayOperaciones = [];
            if(document.getElementById("checkboxIntegralDefOpMult").checked){arrayOperaciones.push("*");}
            if(document.getElementById("checkboxIntegralDefOpDiv").checked){arrayOperaciones.push("/");}
            if(document.getElementById("checkboxIntegralDefOpSum").checked){arrayOperaciones.push("+");}
            if(arrayOperaciones.length==0 || arrayTipos.length==0){
                var tipoOperacion1="";
                document.getElementById(listaNodosHijosAux[j].id).value=""+tipo1F+"";
            }else{
                var tipoOperacion1=arrayOperaciones[Math.floor((Math.random() * arrayOperaciones.length))];
                document.getElementById(listaNodosHijosAux[j].id).value="("+tipo1F+")"+tipoOperacion1+"("+tipo2F+")";
            }
                
                
                }
     }
    }
    var num1 = Math.floor((Math.random() * 9) + 1);
    var num2 = Math.floor((Math.random() * 9) + 1);
    var negat1 = Math.floor((Math.random() * 2) + 1);
    var negat2 = Math.floor((Math.random() * 2) + 1);
    if(negat1==1){num1=num1*(-1)}
    if(negat2==1){num2=num2*(-1)}
    if(num1==num2){
        num2=num2+3;
    }
    if(num1>num2){
        var aux=num2;
        num2=num1;
        num1=aux;
    }
    aux1.value=""+num1;
    aux2.value=""+num2;
    }
}

function ComprobarSolucionReal2() {ComprobarSolucionReal(document.getElementById("NumEcGrado2").value);}

function ComprobarSolucionReal(num) {
     var a,b,c,text;           
            if(num!=0){
         for(i=0;i<=num-1;i++){
              a= document.getElementById("a"+i).value;
              b= document.getElementById("b"+i).value;
              c= document.getElementById("c"+i).value;

           if (isNaN(a) || isNaN(b) || isNaN(c)) {
    text = "Deben ser numeros";
    document.getElementById("EcGrado2Ayuda"+i).style.display = 'block';
    //document.getElementById("FormEcGrado2submit").disabled = true;
  } else {
      
    if(document.getElementById("FormEcGrado2checkbox").checked){
         var d = b*b - 4*a*c;
        if(d>=0){
            text = "";
            document.getElementById("EcGrado2Ayuda"+i).style.display = 'none';
            //document.getElementById("FormEcGrado2submit").disabled = false;//tiene solucion real
        }else{
            text = "Debe tener solucion real";
            document.getElementById("EcGrado2Ayuda"+i).style.display = 'block';
            //document.getElementById("FormEcGrado2submit").disabled = true;//NO tiene solucion real
        } 
    }else{
        text = "";
        document.getElementById("EcGrado2Ayuda"+i).style.display = 'none';
      //  document.getElementById("FormEcGrado2submit").disabled = false;
    }       
  }
  document.getElementById("EcGrado2Ayuda"+i).innerHTML = text;
          
         }
        }
        
       
}
