<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Signup</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(to right, #43e97b, #38f9d7);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .card {
            background: white;
            padding: 30px;
            border-radius: 10px;
            width: 350px;
            box-shadow: 0 0 15px rgba(0,0,0,0.2);
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        input {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
            border-radius: 6px;
            border: 1px solid #ccc;
        }

        button {
            width: 100%;
            padding: 10px;
            background: #43e97b;
            border: none;
            color: white;
            font-weight: bold;
            border-radius: 6px;
            cursor: pointer;
            margin-top: 10px;
        }

        button:hover {
            background: #2ecc71;
        }

        .error {
            color: red;
            text-align: center;
            margin-top: 10px;
        }

        .link {
            text-align: center;
            margin-top: 15px;
        }

        .link a {
            text-decoration: none;
            color: #2ecc71;
            font-weight: bold;
        }
    </style>

</head>
<body>

<div class="card">
    <h2>Create Account</h2>

    <form method="post" action="../UserController">
        <input type="hidden" name="action" value="signup"/>

        <input type="text" name="name" placeholder="Full Name" required/>
        <input type="email" name="email" placeholder="Email" required/>
        <input type="password" name="password" placeholder="Password" required/>

        <button type="submit">Signup</button>
    </form>

    <div class="error">
        <%= request.getParameter("message") != null ? request.getParameter("message") : "" %>
    </div>

    <div class="link">
        <a href="login.jsp">Already have an account?</a>
    </div>
</div>

</body>
</html>