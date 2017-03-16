<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
  <head>
    <title>Travel</title>
  </head>
  <body>
    <h1>add</h1>

    <form method="POST">
   	id: <input type="text" name="id" /><br/>
      user_id: <input type="text" name="userId" /><br/>
      title: <input type="text" name="title" /><br/>
      time: <input type="text" name="time" /><br/>
      <input type="submit" value="update" />
    </form>
  </body>
</html>
