import React, { useEffect, useState } from "react";
import logo from "./logo.svg";
import "./App.css";

type Greeting = {
  id: number;
  name: string;
};


function App() {
    return (
      <div className="App">
        <header className="App-header">                    
<h1>Shipment Details Page</h1>
<div>Your Reciepts</div>
        <ListOfReciepts/>
        <BackToMainButton/> 
         
        </header>
      </div>
    );
  }

  


function BackToMainButton() {
  return (
    <a href="http://localhost:3002" target="_blank" rel="noopener noreferrer">
      <hr/>
      <button> Back to Main Page </button>
    </a>
  );
}

function ListOfReciepts() {
  
  const [data, setData] = useState([]);

  fetch('/read/all')
  .then(response => response.json())
  .then(data => {
    setData(data);
  })
  .catch(error => {
    //
  });
  
  return (   
    <div>
      <hr/>
      <h3>Receipt 1</h3>
      <p>
        {data}
      </p>
      <p> 
        First Name <br/>
        Last Name <br/>
        Street <br/>
        Number <br/>
        Province <br/>
        Country <br/>
        Postal Code <br/>
        Total Paid <br/>
        Item ID <br/>
      </p> 
        <h5>Shipping Details</h5>        
        This Item will be shipped in XXX days   
    </div> 
  );
}

export default App;
