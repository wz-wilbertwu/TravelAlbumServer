<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
  <head>
    <title>Travel</title>
  </head>
  <body>
    <h1>add</h1>

    <form method="POST">
      user_id: <input type="text" name="userId" /><br/>
      title: <input type="text" name="title" /><br/>
      <input type="submit" value="add" />
    </form>
  </body>
</html>