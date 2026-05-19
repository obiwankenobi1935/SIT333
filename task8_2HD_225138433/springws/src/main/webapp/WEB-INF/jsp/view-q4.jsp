<html>
<head>
<style>
  body { font-family: Arial, sans-serif; background: #f0f2f5; display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0; }
  .card { background: white; padding: 40px; border-radius: 10px; box-shadow: 0 2px 10px rgba(0,0,0,0.1); width: 320px; }
  h2 { color: #2c3e50; } .badge { background: #1abc9c; color: white; padding: 3px 10px; border-radius: 20px; font-size: 13px; }
  label { font-size: 14px; color: #555; }
  input[type=text] { width: 100%; padding: 8px; margin: 6px 0 16px 0; border: 1px solid #ccc; border-radius: 4px; box-sizing: border-box; }
  input[type=submit] { width: 100%; padding: 10px; background: #2ecc71; color: white; border: none; border-radius: 4px; cursor: pointer; font-size: 15px; }
  input[type=submit]:hover { background: #27ae60; }
  .error { color: red; font-size: 13px; margin-bottom: 10px; }
  .hint { font-size: 12px; color: #888; margin-bottom: 16px; }
</style>
</head>
<body>
  <div class="card">
    <h2>Q4 <span class="badge">Date Utility</span></h2>
    <div class="error">${message}</div>
    <form action="/q4" method="post">
      <label>Start Date (yyyy-mm-dd):</label>
      <input type="text" id="startDate" name="startDate" placeholder="e.g. 2024-01-01">
      <label>Number of Days to Add:</label>
      <input type="text" id="days" name="days" placeholder="e.g. 45">
      <label>Result Date (yyyy-mm-dd):</label>
      <input type="text" id="result" name="result" placeholder="e.g. 2024-02-15">
      <input type="submit" value="Submit">
    </form>
  </div>
</body>
</html>