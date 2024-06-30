<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Dashboard</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<style>
  body {
    font-family: Arial, sans-serif;
    background-color: #f0f0f0;
    margin: 0;
    padding: 0;
  }
  
  .container {
    width: 80%;
    margin: 20px auto;
    background-color: #fff;
    padding: 20px;
    box-shadow: 0 0 10px rgba(0,0,0,0.1);
    border-radius: 8px;
  }
  
  table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
  }
  
  th, td {
    padding: 12px;
    text-align: center;
    border-bottom: 1px solid #ddd;
    transition: all 0.3s ease;
    font-weight: bold;
    color: #333;
  }
  
  th {
    background-color: #333;
    color: #fff;
  }
  
  tr:nth-child(even) {
    background-color: #f2f2f2;
  }
  
  tr:hover {
    background-color: gold;
    transform: scale(1.05);
    box-shadow: 0 0 15px rgba(0,0,0,0.2);
  }

  .home-button {
    padding: 10px;
    background-color: #28a745;
    color: white;
    text-align: center;
    border-radius: 4px;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin-bottom: 20px;
  }

  .home-button i {
    margin-right: 8px;
  }

  .home-button:hover {
    background-color: #218838;
  }

  .search-input {
    margin-bottom: 10px;
    position: relative;
  }
  
  .search-input input {
    width: 25%;
    padding: 10px 40px 10px 20px;
    border-radius: 4px;
    border: 1px solid #ddd;
    box-shadow: 0 0 5px rgba(0,0,0,0.1);
    font-size: 16px;
    transition: all 0.3s ease;
  }
  
  .search-input input:focus {
    outline: none;
    border-color: #333;
    box-shadow: 0 0 10px rgba(0,0,0,0.2);
  }
  
  .search-input .fa-search {
   position: absolute;
    top: 50%;
    right: 15px;
    transform: translateY(-50%);
    color: #060606;
    font-size: 18px;
    position: relative;
    right: 45px;
    top: 20px;
    background: #fff700;
    padding: 10px;
  }
</style>
</head>
<body>
<div class="container">
  <a href="index.html" class="home-button"><i class="fas fa-home"></i>Home</a>
  <h2 style="text-align: center;">Product Dashboard</h2>
  <div class="search-input">
    <input type="text" id="searchInputName" placeholder="Search by Name...">
    <i class="fas fa-search"></i>
  </div>
  <div class="search-input">
    <input type="text" id="searchInputID" placeholder="Search by ID...">
    <i class="fas fa-search"></i>
  </div>
  
  <table id="dataTable">
    <thead>
      <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>PRODUCT_ID</th>
        <th>PRICE</th>
        <th>STOCK</th>
        <th>TYPE1</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${uk}" var="e">
        <tr>
          <td>${e.ID}</td>
          <td>${e.NAME}</td>
          <td>${e.PRODUCT_ID}</td>
          <td>${e.PRICE}</td>
          <td>${e.STOCK}</td>
          <td>${e.TYPE1}</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
<script type="text/javascript">
  const searchInputName = document.getElementById('searchInputName');
  const searchInputID = document.getElementById('searchInputID');
  const dataTable = document.getElementById('dataTable');
  const rows = dataTable.getElementsByTagName('tr');

  searchInputName.addEventListener('input', function() {
    const query = searchInputName.value.toLowerCase();

    for (let i = 1; i < rows.length; i++) {
      const row = rows[i];
      let found = false;

      for (let j = 1; j < row.cells.length; j++) {
        const cell = row.cells[j];
        if (cell.textContent.toLowerCase().includes(query)) {
          found = true;
          break;
        }
      }

      if (found) {
        row.style.display = '';
      } else {
        row.style.display = 'none';
      }
    }
  });

  searchInputID.addEventListener('input', function() {
    const query = searchInputID.value.toLowerCase();

    for (let i = 1; i < rows.length; i++) {
      const row = rows[i];
      const cell = row.cells[0];

      if (cell.textContent.toLowerCase().includes(query)) {
        row.style.display = '';
      } else {
        row.style.display = 'none';
      }
    }
  });
</script>
</body>
</html>
