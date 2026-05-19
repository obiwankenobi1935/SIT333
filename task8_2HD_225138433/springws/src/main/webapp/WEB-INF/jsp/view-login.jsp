<html>
<head>
<style>
  body { font-family: Arial, sans-serif; background: #f0f2f5; display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0; }
  .card { background: white; padding: 40px; border-radius: 10px; box-shadow: 0 2px 10px rgba(0,0,0,0.1); width: 320px; }
  h2 { color: #2c3e50; margin-bottom: 20px; }
  label { font-size: 14px; color: #555; }
  input[type=text], input[type=password], input[type=date] { width: 100%; padding: 8px; margin: 6px 0 16px 0; border: 1px solid #ccc; border-radius: 4px; box-sizing: border-box; }
  input[type=submit] { width: 100%; padding: 10px; background: #3498db; color: white; border: none; border-radius: 4px; cursor: pointer; font-size: 15px; }
  input[type=submit]:hover { background: #2980b9; }
  .error { color: red; font-size: 13px; margin-bottom: 10px; }
</style>
</head>
<body>
  <div class="card">
    <h2>Login</h2>
    <div class="error">${message}</div>
    <form action="/login" method="post">
      <label>Username:</label>
      <input type="text" id="username" name="username">
      <label>Password:</label>
      <input type="password" id="passwd" name="passwd">
      <label>Date of Birth:</label>
      <input type="date" id="dob" name="dob">
      <input type="submit" value="Login">
    </form>
  </div>
</body>
</html>