function Mine() {}
Mine.submitActionWithForm = function(Form2, url, Form1) {
    //1
    var req = new Mine.myXMlHttpRequest();
    //2
    var myHandlerListening = Mine.getMyReadyStateHandler(req, Form2, Mine.myHandlerResponse);
    req.onreadystatechange = myHandlerListening;
    //open
    req.open("POST", url, true);
    req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    //4
    var str = Mine.getParameter2Str(Form1);
    //5
    req.send(str);
};

Mine.myXMlHttpRequest = function myXMlHttpRequest() {
    var xmlreq = false;
    if (window.XMLHttpRequest) {
        xmlreq = new XMLHttpRequest();
    }else if (window.ActiveXObject) {
        try{
            xmlreq = new ActiveXObject("Msxml2.XMLHTTP")
        }catch(e1){
            try{
                xmlreq = new ActiveXObject("Microsoft.XMLHTTP");
            }catch(e2){
                alert(e2);
            }
        }
    }
    return xmlreq;
}

Mine.myHandlerResponse = function myHandlerResponse(data, Form2) {
    var ele = document.getElementById(Form2);
    ele.innerHTML = data;
};

Mine.getMyReadyStateHandler = function (req, Form2, handlerResponse) {

    return function () {
        if(req.readyState == 4) {
            if(req.status == 200) {
                handlerResponse(req.responseText, Form2);
            }else {
                alert("Http error: " + req.status);
                return false;
            }
        }
    }

};

Mine.getParameter2Str = function getParameter2Str(Form1) {
    var strDiv = "";
    try{
        var objForm = document.getElementById(Form1);
        if (!objForm) {
            return strDiv;
        }
        for (var fld = 0;fld < objForm.length; fld++) {
            elt = objForm.elements[fld];
            sName = elt.name;
            sValue = elt.value;
            if(fld==objForm.elements.length-1)
                strDiv=strDiv + sName+"="+sValue+"";
            else
                strDiv=strDiv + sName+"="+sValue+"&";
        }
    }catch(ex){
        strDiv;
    }
    return strDiv;
}