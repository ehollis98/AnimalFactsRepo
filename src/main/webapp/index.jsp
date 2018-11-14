<html>

<head>
    <title>Animal API Form</title>
    <meta charset="UTF-8" />
    <script type="text/javascript" src="accessAnimalAPI.js"></script>
</head>

<body>

  <h2>Animal Facts API (Team Project)</h2>

  <form id="animalApiForm"
        onSubmit="return getAnimal();">

      <br />

      <!--Animal input-->
      <input type="text"
             name="animalFormEntry"
             id="animalFormEntry"
             maxlength="50"
             placeholder="animal" />

      <input type="submit"
             value="Submit" />
  </form>

  <div id="outputDiv" class="output">

  </div>


</body>

</html>