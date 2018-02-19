<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 16.02.2018
  Time: 22:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>

<body>
<div>
    <h1>Test System</h1>
</div>

<div>
    <div>
        <div>
            <h2>Delete user</h2>
        </div>

        <div>
            <form method="post">
                <label>User ID:
                    <input type="text" name="userId"><br />
                </label>
                <button type="submit">Delete</button>
            </form>

            <%
                if (request.getAttribute("deletedUserId") != null) {
                    out.println("<p>User '" + request.getAttribute("deletedUserId") + "' deleted!</p>");
                }
            %>
        </div>
    </div>
        <div>
            <h2>Users</h2>
        </div>
        <%
            List<String> names = (List<String>) request.getAttribute("userNames");

            if (names != null && !names.isEmpty()) {
                out.println("<ui>");
                for (String s : names) {
                    out.println("<li>" + s + "</li>");
                }
                out.println("</ui>");
            } else out.println("<p>There are no users yet!</p>");
        %>
    </div>
</div>

<div>
    <button onclick="location.href='/'">Back to main</button>
</div>
</body>
</html>