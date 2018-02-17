<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 16.02.2018
  Time: 22:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Add new user</title>
    </head>
    <body>

        <div>
            <h1>Test System</h1>
        </div>


        <div>
            <%
                if (request.getAttribute("lastName") != null) {
                    out.println("<p>User '" + request.getAttribute("lastName") + "' added!</p>");
                }
            %>

            <div>
                <h2>Add user</h2>
            </div>

            <div>
                <form method="post">
                    <label>FirstName:
                        <input type="text" name="firstName"><br />
                    </label>

                    <label>LastName:
                        <input type="text" name="lastName"><br />
                    </label>

                    <label>Login:
                        <input type="text" name="login"><br />
                    </label>

                    <label>Password:
                        <input type="password" name="pass"><br />
                    </label>
                    <button type="submit">Submit</button>
                </form>
            </div>
        </div>
        <div>
            <button onclick="location.href='/'">Back to main</button>
        </div>

    </body>
</html>
