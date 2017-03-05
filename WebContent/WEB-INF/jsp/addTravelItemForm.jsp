<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
  <head>
    <title>Travel</title>
  </head>
  <body>
    <h1>add</h1>

    <form method="POST">
      travel_id: <input type="text" name="travel_id" /><br/>
      description: <input type="text" name="description" /><br/>
      image: <input type="text" name="image" /><br/>
      <input type="submit" value="add" />
    </form>
  </body>
</html>
