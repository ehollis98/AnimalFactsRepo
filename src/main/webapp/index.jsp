<%@include file="head.jsp"%>
<html>

<head>
    <title>Animal Facts</title>
    <meta charset="UTF-8" />
</head>

<body>

<div class="page-header">
    <h1>Animal Facts API</h1>
</div>

<a href="http://18.219.184.166:8080/animalFacts/random">working cloud randomfact</a>
<br>
<a href="http://localhost:8080/animalFacts/animals/fact/random">working local randomfact</a>


<br />

<div class="container">
    <h2>Method URLs</h2>
    Base:<a href="http://18.219.184.166:8080/animalFacts">http://18.219.184.166:8080/animalFacts</a>
    <table class="table">
        <thead>
        <tr>
            <th>Method</th>
            <th>Endpoint</th>
            <th>Information</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>Get Random Animal</td>
            <td><a href="/animalFacts/animals/dropdown">http://18.219.184.166:8080/animalFacts/animals/dropdown  </a></td>
            <td>Returns a random animal as a JSON object.</td>
        </tr>
        <tr>
            <td>Get Random Animal</td>
            <td><a href="/animalFacts/animals/random">http://18.219.184.166:8080/animalFacts/animals/random</a></td>
            <td>Returns a random animal as a JSON object.</td>
        </tr>
        <tr class="active">
            <td>Get Random Animal</td>
            <td><a href="/animalFacts/animals/random/xml">http://18.219.184.166:8080/animalFacts/animals/random/xml</a></td>
            <td>Returns a random animal as a XML object.</td>
        </tr>
        <tr>
            <td>Get Random Fact</td>
            <td><a href="/animalFacts/animals/fact/random">http://18.219.184.166:8080/animalFacts/animals/fact/random</a></td>
            <td>Returns a random fact.</td>
        </tr>
        <tr >
            <td>Get Random Fact</td>
            <td><a href="/animalFacts/animals/fact/random/xml">http://18.219.184.166:8080/animalFacts/animals/fact/random/xml</a></td>
            <td>Returns a random fact.</td>
        </tr>
        <tr class="active">
            <td>Get All Facts</td>
            <td><a href="/animalFacts/animals/fact/all">http://18.219.184.166:8080/animalFacts/animals/fact/all</a></td>
            <td>Returns all facts.</td>
        </tr>
        <tr class="active">
            <td>Get All Facts</td>
            <td><a href="/animalFacts/animals/fact/all/xml">http://18.219.184.166:8080/animalFacts/animals/fact/all/xml</a></td>
            <td>Returns all facts.</td>
        </tr>
        <tr>
            <td>Get Facts by Animal ID</td>
            <td><a href="/animalFacts/animals/100">http://18.219.184.166:8080/animalFacts/animals/{animalID}</a></td>
            <td>Accepts a parameter of animal id, and returns all facts for animal.</td>
        </tr>
        <tr>
            <td>Get Facts by Animal ID</td>
            <td><a href="/animalFacts/animals/100/xml">http://18.219.184.166:8080/animalFacts/animals/{animalID}/xml</a></td>
            <td>Accepts a parameter of animal id, and returns all facts for animal.</td>
        </tr>
        </tbody>
    </table>
</div>

<form action="searchAnimal">
    <button type="submit" name="submit" value="searchAllAnimals" class="btn btn-info">View all animals</button>
    <div>
        ${allAnimals}
    </div>
</form>

<form action="searchAnimal">
    <!--Animal ID input-->
    <div class="form-group">
        <input type="number"
               name="animalSearchId"
               id="animalSearchId"
               placeholder="1" />
    </div>
    <button type="submit" name="submit" value="searchByAnimalId" class="btn btn-primary">Search Animal</button>
    <div class="output">
        ${randomAnimal}
    </div>
</form>

<form action="searchAnimal">
    <button type="submit" name="submit" value="searchRandomAnimal" class="btn btn-info">View Random Animal</button>
    <div class="output">
        ${searchedAnimalById}
    </div>
</form>


</body>



</html>