<%@include file="head.jsp"%>
<html>

<head>
    <title>Animal Facts</title>
    <meta charset="UTF-8" />
</head>

<body>

<div class="page-header" style="text-align:center;">
    <h1>Animal Facts API</h1>
</div>

<div class="container">
    <h2>Method URLs</h2>
    Base: <a href="http://18.219.184.166:8080/animalFacts">http://18.219.184.166:8080/animalFacts</a>
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
            <td>Returns all animals as a drop down list.</td>
        </tr>
        <tr>
            <td>Get Random Animal</td>
            <td><a href="/animalFacts/animals/random">http://18.219.184.166:8080/animalFacts/animals/random</a></td>
            <td>Returns a random animal as JSON.</td>
        </tr>
        <tr class="active">
            <td>Get Random Animal</td>
            <td><a href="/animalFacts/animals/random/xml">http://18.219.184.166:8080/animalFacts/animals/random/xml</a></td>
            <td>Returns a random animal as XML.</td>
        </tr>
        <tr>
            <td>Get Random Fact</td>
            <td><a href="/animalFacts/animals/fact/random">http://18.219.184.166:8080/animalFacts/animals/fact/random</a></td>
            <td>Returns a random fact as JSON.</td>
        </tr>
        <tr >
            <td>Get Random Fact</td>
            <td><a href="/animalFacts/animals/fact/random/xml">http://18.219.184.166:8080/animalFacts/animals/fact/random/xml</a></td>
            <td>Returns a random fact as XML.</td>
        </tr>
        <tr class="active">
            <td>Get All Facts</td>
            <td><a href="/animalFacts/animals/fact/all">http://18.219.184.166:8080/animalFacts/animals/fact/all</a></td>
            <td>Returns all facts as JSON.</td>
        </tr>
        <tr class="active">
            <td>Get All Facts</td>
            <td><a href="/animalFacts/animals/fact/all/xml">http://18.219.184.166:8080/animalFacts/animals/fact/all/xml</a></td>
            <td>Returns all facts as XML.</td>
        </tr>
        <tr>
            <td>Get Facts by Animal ID</td>
            <td><a href="/animalFacts/animals/100">http://18.219.184.166:8080/animalFacts/animals/{animalID}</a></td>
            <td>Accepts a parameter of animal id, and returns all facts for animal as JSON.</td>
        </tr>
        <tr>
            <td>Get Facts by Animal ID</td>
            <td><a href="/animalFacts/animals/100/xml">http://18.219.184.166:8080/animalFacts/animals/{animalID}/xml</a></td>
            <td>Accepts a parameter of animal id, and returns all facts for animal as XML.</td>
        </tr>
        </tbody>
    </table>
</div>

<div class="container">
    <h2>Use the API</h2>
    <table class="table">
        <tbody>
        <!--Get Random Animal(Dropdown)-->
        <tr>
            <td>
                <form action="searchAnimal">
                  <button type="submit" name="submit" value="getRandomAnimalDropdown" class="btn btn-info" autofocus>Get</button>
                </form>
            </td>
            <td>Get Random Animal(Dropdown)</td>
        </tr>
        <tr>
            <td class="text-secondary">
                <div>
                  ${randomAnimalDropdown}
                </div>
            </td>
        </tr>
        <!--Get Random Animal(Dropdown)-->
        <tr>
            <td>
                <form action="searchAnimal">
                    <button type="submit" name="submit" value="getRandomAnimalJSON" class="btn btn-info" autofocus>Get</button>
                </form>
            </td>
            <td>Get Random Animal(JSON)</td>
        </tr>
        <tr>
            <td class="text-secondary">
                <div>
                    ${randomAnimalJSON}
                </div>
            </td>
        </tr>
        <!--Get Random Animal(Dropdown)-->
        <tr>
            <td>
                <form action="searchAnimal">
                    <button type="submit" name="submit" value="getRandomAnimalXML" class="btn btn-info" autofocus>Get</button>
                </form>
            </td>
            <td>Get Random Animal(XML)</td>
        </tr>
        <tr>
            <td class="text-secondary">
                <div style="overflow: auto;  width: 40em;">
                    ${randomAnimalXML}
                </div>
            </td>
        </tr>
        <!--Get Random Animal Fact (JSON)-->
        <tr>
            <td>
                <form action="searchAnimal">
                    <button type="submit" name="submit" value="getRandomAnimalFactJSON" class="btn btn-info" autofocus>Get</button>
                </form>
            </td>
            <td>Get Random Animal Fact (JSON)</td>
        </tr>
        <tr>
            <td class="text-secondary">
                <div>
                    ${randomAnimalFactJSON}
                </div>
            </td>
        </tr>
        <!--Get Random Animal Fact (XML)-->
        <tr>
            <td>
                <form action="searchAnimal">
                    <button type="submit" name="submit" value="getRandomAnimalFactXML" class="btn btn-info" autofocus>Get</button>
                </form>
            </td>
            <td>Get Random Animal Fact (XML)</td>
        </tr>
        <tr>
            <td class="text-secondary">
                <div style="overflow: auto;  width: 40em;">
                    ${randomAnimalFactXML}
                </div>
            </td>
        </tr>
        <!--Get All Animal Facts (JSON)-->
        <tr>
            <td>
                <form action="searchAnimal">
                    <button type="submit" name="submit" value="getAllAnimalFactsJSON" class="btn btn-info" autofocus>Get</button>
                </form>
            </td>
            <td>Get All Animal Facts (JSON)</td>
        </tr>
        <tr>
            <td class="text-secondary">
                <div>
                    ${allAnimalFactsJSON}
                </div>
            </td>
        </tr>
        <!--Get All Animal Facts (XML)-->
        <tr>
            <td>
                <form action="searchAnimal">
                    <button type="submit" name="submit" value="getAllAnimalFactsXML" class="btn btn-info" autofocus>Get</button>
                </form>
            </td>
            <td>Get All Animal Facts (XML)</td>
        </tr>
        <tr>
            <td class="text-secondary">
                <div style="overflow: auto;  width: 40em;">
                    ${allAnimalFactsXML}
                </div>
            </td>
        </tr>
        <!--Get Animal Facts By Id (JSON)-->
        <tr>
            <td>
                <form action="searchAnimal">
                    <input type="number"
                           min="1"
                           name="animalSearchId01"
                           id="animalSearchId01"
                           placeholder="1" />
                    <button type="submit" name="submit" value="getAnimalFactsByIdJSON" class="btn btn-info" autofocus>Get</button>
                </form>
            </td>
            <td>Get Animal Fact By Id (JSON)</td>
        </tr>
        <tr>
            <td class="text-secondary">
                <div >
                    ${animalFactsByIdJSON}
                </div>
            </td>
        </tr>
        <!--Get Animal Facts By Id (XML)-->
        <tr>
            <td>
                <form action="searchAnimal">
                    <input type="number"
                           min="1"
                           name="animalSearchId02"
                           id="animalSearchId02"
                           placeholder="1" />
                    <button type="submit" name="submit" value="getAnimalFactsByIdXML" class="btn btn-info" autofocus>Get</button>
                </form>
            </td>
            <td>Get Animal Fact By Id (XML)</td>
        </tr>
        <tr>
            <td class="text-secondary">
                <div style="overflow: auto;  width: 40em;">
                    ${animalFactsByIdXML}
                </div>
            </td>
        </tr>
        </tbody>
    </table>
</div>


</body>



</html>