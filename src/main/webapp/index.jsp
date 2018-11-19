<html>

<head>
    <title>Animal Facts</title>
    <meta charset="UTF-8" />
</head>

<body>

  <h2>Animal Facts API (Team Project)</h2>

</body>

<a href="http://18.219.184.166:8080/animalFacts/random">working cloud randomfact</a>
<br>
<a href="http://localhost:8080/animalFact/animals/fact/random">working local randomfact</a>
<br>
<p>/animalFact/animals/fact/random</p>
<br>
<p>/animalFact/animals/fact/all</p>
<br>
<p>/animalFact/animals/fact/{animalID}</p>
<br>
<p>/animalFact/animals/dropdown</p>


<br />
<form id="animalApiForm"
      action="searchAnimal">
    <!--Animal ID input-->
    <input type="number"
           name="animalSearchId"
           id="animalSearchId"
           placeholder="1" />
    <button type="submit" name="submit" value="searchByAnimal" class="btn btn-primary">Search Animal</button>
    <button type="submit" name="submit" value="searchAllAnimals" class="btn btn-info">View all animals</button>
    <button type="submit" name="submit" value="requestJSONData" class="btn btn-info">GetJSON</button>
</form>
</body>

    <div id ="testOutputDiv" class="output">
        ${jsonData}
    </div>

</body>
</html>