<html>
<head>
<style>
  body { font-family: Arial, sans-serif; background: #f0f2f5; display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0; }
  .card { background: white; padding: 40px; border-radius: 10px; box-shadow: 0 2px 10px rgba(0,0,0,0.1); width: 320px; }
  h2 { color: #2c3e50; } .badge { background: #e74c3c; color: white; padding: 3px 10px; border-radius: 20px; font-size: 13px; }
  label { font-size: 14px; color: #555; }
  input[type=text] { width: 100%; padding: 8px; margin: 6px 0 16px 0; border: 1px solid #ccc; border-radius: 4px; box-sizing: border-box; }
  input[type=submit] { width: 100%; padding: 10px; background: #2ecc71; color: white; border: none; border-radius: 4px; cursor: pointer; font-size: 15px; }
  input[type=submit]:hover { background: #27ae60; }
  .error { color: red; font-size: 13px; margin-bottom: 10px; }
  .formula { background: #f8f9fa; border-left: 3px solid #e74c3c; padding: 8px 12px; margin-bottom: 16px; font-size: 13px; color: #555; border-radius: 4px; }
</style>
</head>
<body>
  <div class="card">
    <h2>Q6 <span class="badge">Science</span></h2>
    <div class="error">${message}</div>
    <div class="formula">Newton's 2nd Law: <strong>F = m × a</strong></div>
    <form action="/q6" method="post">
      <label>Mass (kg):</label>
      <input type="text" id="mass" name="mass" placeholder="e.g. 4">
      <label>Acceleration (m/s²):</label>
      <input type="text" id="acceleration" name="acceleration" placeholder="e.g. 5">
      <label>Force (N):</label>
      <input type="text" id="result" name="result" placeholder="e.g. 20.0">
      <input type="submit" value="Submit">
    </form>
  </div>
</body>
</html>