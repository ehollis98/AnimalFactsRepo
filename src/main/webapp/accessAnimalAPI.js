//Global variables begin here
//===============================
var animalFactsApiUrl = "http://18.219.184.166:8080/animalFacts/random";
var animalJSONObject;
var animalName;
var animalFact;
//===============================
//Global variables end here


/*
    This is the JavaScript code for
        Animal Facts API
    File: index.jsp
*/

/**The purpose of this function is to: create an AJAX request and open the API through a GET. */
function makeAJAXRequest(url, callback) {

    //creation of XMLHttpRequest object here
    var xhr = new XMLHttpRequest();

    //make ajax request to a server url
    xhr.open("GET", url);

    xhr.onreadystatechange = function() {
        if(xhr.readyState == 4 &&
            xhr.status == 200) {
            //callback is called once this request is completed
            callback(xhr);
        }
    }

    xhr.send(null);

}

/**The purpose of this function is to: retrieve the animal JSON data and set it to the global variable. */
function retrieveAnimalInformation() {

    //create an instance of an XMLHttpRequest object through function call
    makeAJAXRequest(animalFactsApiUrl, function(xhr) {

        //store the request's received raw text as a variable
        var XMLHttpRequestString = xhr.responseText;

        //convert the raw text into a JSON object and store as a variable
        var JSONObject = JSON.parse(XMLHttpRequestString);

        //animalName = JSONObject.animal.name;
        //animalFact = JSONObject.animal.fact;

        animalJSONObject = JSONObject;

    });

}



/**The purpose of this function is to: display the animal JSON onto the web page. */
function displayRetrievedAnimal() {

    var outputElement = document.getElementById("outputDiv");

    var animalHeading = outputElement.appendChild(document.createElement("h1"));

    var animalJSONTextNode = document.createTextNode(animalJSONObject);

    animalHeading.appendChild(animalJSONTextNode);

}



/**The purpose of this function is to: act as the mainline function, and make the
 necessary function calls in order to retrieve the respective animal information. */
function getAnimal() {

    retrieveAnimalInformation();

    displayRetrievedAnimal();

    //Stop the web page from refreshing
    return false;
}