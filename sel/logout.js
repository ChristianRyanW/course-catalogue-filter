 function login() {
        var url = "http://144.167.219.251:8080/course_catalog_filter/rest/login"
        xmlhttp.open('POST',url,true);
		xmlhttp.setRequestHeader("Content-type", "application/json");
		xmlhttp.responseType = '';
	
		var parameters = {email: document.getElementById("email").value, pass: document.getElementById("pass").value};
		var myJSON = JSON.stringify(parameters);
		xmlhttp.send(myJSON);
		//var httpResponse = xmlhttp.response;
		//alert("http Response: " + httpResponse);
        xmlhttp.onreadystatechange = function() {  
		
               if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			   
				var httpResponse = JSON.parse(xmlhttp.response);
				console.log("Login Status: " + httpResponse.status);

                       if (httpResponse.status == "Success") {
                          console.log("logged in");
                           
                         location.href = "./catalog.html";
                           /*cookie code*/
                         httpResponse.getHeader("token");
                         
                           
                           
                       }
                       else {
                           console.log("Invalid Credentials " + "HTTP STATUS: " + xmlhttp.status + " Sent JSON: " + myJSON);
                           alert('Wrong Email or Password!');
                       }
                 }
                 else
                       console.log("Error: HTTP STATUS: " + xmlhttp.status + " Sent JSON " + myJSON);
        };
        
      /*
        if(xmlhttp.responseText == "true"){
            window.location.href = "./catalog.html";
        }
      */
        
        
        
    /*    
                 
 function saveCookie(value) {
    var today = new Date(); // date 
    var expire = new Date(); // expiration of the cookie

    var cookie_name = "user_form"; 
    var number_of_days = 1; // Number of days for the cookie to be valid

    expire.setTime( today.getTime() + 60 * 60 * 1000 * 24 * number_of_days ); // Current time + (60 sec * 60 min * 1000 milisecs * 24 hours * number_of_days)

    document.cookie = cookie_name + "=" + escape(value) + "; expires=" + expire.toGMTString();
}*/
}
    
   