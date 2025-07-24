<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Currency Converter</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 500px;
            margin: 50px auto;
            padding: 20px;
            background-color: #f0f0f0;
        }
        .container {
            background: white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
        }
        h2 {
            text-align: center;
            color: #333;
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            font-weight: bold;
        }
        select, input, button {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            font-size: 14px;
        }
        button {
            background-color: #007bff;
            color: white;
            border: none;
        }
        .result {
            margin-top: 20px;
            padding: 10px;
            background-color: #e9f7ef;
            border-left: 5px solid green;
        }
        .error {
            background-color: #f8d7da;
            border-left: 5px solid red;
            color: #721c24;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Currency Converter</h2>
    <form action="Convert" method="post">
        <div class="form-group">
            <label for="fromCurrency">From Currency:</label>
            <select name="fromCurrency" id="fromCurrency" required>
                <option value="USD">USD</option>
                <option value="INR">INR</option>
                <option value="EUR">EUR</option>
                <option value="GBP">GBP</option>
            </select>
        </div>

        <div class="form-group">
            <label for="amount">Amount:</label>
            <input type="number" step="0.01" min="0" name="amount" required>
        </div>

        <div class="form-group">
            <label for="toCurrency">To Currency:</label>
            <select name="toCurrency" id="toCurrency" required>
                <option value="USD">USD</option>
                <option value="INR">INR</option>
                <option value="EUR">EUR</option>
                <option value="GBP">GBP</option>
            </select>
        </div>

        <button type="submit">Convert</button>
    </form>

    <% if (request.getAttribute("result") != null) { %>
        <div class="result">
            <%= request.getAttribute("result") %>
        </div>
    <% } %>

    <% if (request.getAttribute("error") != null) { %>
        <div class="result error">
            <%= request.getAttribute("error") %>
        </div>
    <% } %>
</div>
</body>
</html>
