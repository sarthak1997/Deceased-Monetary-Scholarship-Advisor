<%-- 
    Document   : UserMenu
    Created on : 16 Aug, 2017, 4:42:22 PM
    Author     : Rohit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User-Menu</title>
    
   
<style>
/* The Modal (background) */
.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    padding-top: 100px; /* Location of the box */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
    background-color: #fefefe;
    margin: auto;
    padding: 20px;
    border: 1px solid #888;
    width: 50%;
    
}

/* The Close Button */
.close {
    color: #aaaaaa;
    float: right;
    font-size: 28px;
    font-weight: bold;
}

.close:hover,
.close:focus {
    color: #000;
    text-decoration: none;
    cursor: pointer;
}


.modal1 {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    padding-top: 100px; /* Location of the box */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content1 {
    background-color: #fefefe;
    margin: auto;
    padding: 20px;
    border: 1px solid #888;
    width: 50%;
    
}

/* The Close Button */
.close1 {
    color: #aaaaaa;
    float: right;
    font-size: 28px;
    font-weight: bold;
}

.close1:hover,
.close1:focus {
    color: #000;
    text-decoration: none;
    cursor: pointer;
}

</style>

<style>
    
    .modal3 {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    padding-top: 100px; /* Location of the box */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content3 {
    background-color: #fefefe;
    margin: auto;
    padding: 20px;
    border: 1px solid #888;
    width: 50%;
    
}

/* The Close Button */
.close3 {
    color: #aaaaaa;
    float: right;
    font-size: 28px;
    font-weight: bold;
}

.close3:hover,
.close3:focus {
    color: #000;
    text-decoration: none;
    cursor: pointer;
}

</style>
</head>
<body>

<h2>MENU</h2>

<!-- Trigger/Open The Modal -->
<button id="scholarBtn">Scholarship</button>

<!-- The Modal -->
<div id="scholarModal" class="modal1">

<!--   Modal content -->
  <div class="modal-content1">
    <span class="close1">&times;</span>
    <form action="ScholarChoice" method="post">
        <h2>Choose your role:</h2><br>
        <input type="radio" name="choose" value="provider"> Provider
        <input type="radio" name="choose" value="scholar"> Scholar
        &nbsp; &nbsp; &nbsp;
        <input type="submit" value="Proceed">
    </form>
  </div>

</div>
<br> <br>
<!-- Trigger/Open The Modal -->
<button id="bankingBtn">Banking</button>

<!-- The Modal -->
<div id="bankingModal" class="modal">

  <!-- Modal content -->
  <div class="modal-content">
    <span class="close">&times;</span>
    <h2>Choose your role:</h2><br>
    <form action="BankingChoice" method="post">
        <input type="radio" name="choose" value="customer"> Customer
        <input type="radio" name="choose" value="policyagent"> Policy Agent
        <input type="radio" name="choose" value="orghead"> Organization Head
        &nbsp; &nbsp; &nbsp;
        <input type="submit" value="Proceed">
    </form>
  </div>

</div>
<br>
<br>
<button onclick="family()">Family</button>

<br><br>
<!-- Trigger/Open The Modal -->
<button id="registerBtn">Register</button>

<!-- The Modal -->
<div id="registerModal" class="modal3">

<!--   Modal content -->
  <div class="modal-content3">
    <span class="close3">&times;</span>
    <form action="RegisterChoice" method="post">
        <h2>Register As:</h2><br>
        <input type="radio" name="choose" value="Employee">Employee 
        <input type="radio" name="choose" value="Organization"> Organization
        &nbsp; &nbsp; &nbsp;
        <input type="submit" value="Proceed">
    </form>
  </div>

</div>
<br> <br>

<script>
// Get the modal
var modal = document.getElementById('bankingModal');

// Get the button that opens the modal
var btn = document.getElementById("bankingBtn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal 
btn.onclick = function() {
    modal.style.display = "block";
};

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";
};

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target=== modal) {
        modal.style.display = "none";
    }
};


//
var modal1 = document.getElementById('scholarModal');

// Get the button that opens the modal
var btn1 = document.getElementById("scholarBtn");

// Get the <span> element that closes the modal
var span1 = document.getElementsByClassName("close1")[0];

// When the user clicks the button, open the modal 
btn1.onclick = function() {
    modal1.style.display = "block";
};

// When the user clicks on <span> (x), close the modal
span1.onclick = function() {
    modal1.style.display = "none";
};

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target === modal1) {
        modal1.style.display = "none";
    }
};

//
var modal3 = document.getElementById('registerModal');

// Get the button that opens the modal
var btn3 = document.getElementById("registerBtn");

// Get the <span> element that closes the modal
var span3 = document.getElementsByClassName("close3")[0];

// When the user clicks the button, open the modal 
btn3.onclick = function() {
    modal3.style.display = "block";
};

// When the user clicks on <span> (x), close the modal
span3.onclick = function() {
    modal3.style.display = "none";
};

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target === modal1) {
        modal1.style.display = "none";
    }
};

function family()
{
window.location="FetchFamily";
}
</script>
    </body>
</html>
