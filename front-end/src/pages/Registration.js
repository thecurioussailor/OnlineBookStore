import { useState } from "react";
import axios from 'axios'
import './Registration.css'
 
function Registration()
{
   const [firstname, setFname] = useState("");
   const [lastname, setLname] = useState("");
   const [email, setEmail] = useState("");
   const [password, setPassword] = useState("");
   const [AddLine1, setAline1] = useState("");
   const [AddLine2, setAline2] = useState("");
   const [city, setCity] = useState("");
   const [state, setState] = useState("");
   const [postalcode, setPcode] = useState("");
   const [mobile, setPhone] = useState("");
 
   async function handleSubmit(event)
    {
        event.preventDefault();
    try
        {
         await axios.post("http://localhost:8080/api/customers",
        {

        firstName: firstname,
        lastName : lastname,
        email : email,
        password : password,
        addressLine1 : AddLine1,
        addressLine2 : AddLine2,
        city : city,
        state : state,
        postalCode : postalcode,
        phoneNumber : mobile,

        });
          alert("User Registation Successfully");
          setFname("");
          setLname("");
          setEmail("");
          setPassword("");
          setAline1("");
          setAline2("");
          setCity("");
          setState("");
          setPcode("");
          setPhone("");
        }
    catch(err)
        {
          alert("User Registation Failed");
        }
   }
    return (
        <div className="register-container">
    
            <form className="register-form" onSubmit={handleSubmit}>
            <br></br>      
            <h1>Register</h1>
            <p>Fill in the Information Below</p>
 

 
            <input type="text"
            name="firstname"
            placeholder="Firstname"
            onChange={(event) =>
                {
                    setFname(event.target.value);      
                }}
            />
 
            <input type="text"
            name="lastname"
            placeholder="lastname"
            onChange={(event) =>
                {
                    setLname(event.target.value);      
                }}          
            />

            <input type="text"
            name="email"
            placeholder="email"
            onChange={(event) =>
                {
                    setEmail(event.target.value);      
                }}          
            />

            <input type="text"
            name="password"
            placeholder="password"
            onChange={(event) =>
                {
                    setPassword(event.target.value);      
                }}          
            />

            <input type="text"
            name="addLine1"
            placeholder="addressLine1"
            onChange={(event) =>
                {
                    setAline1(event.target.value);      
                }}          
            />

            <input type="text"
            name="addLine2"
            placeholder="addressLine2"
            onChange={(event) =>
                {
                    setAline2(event.target.value);      
                }}          
            />
 
            
            <input type="text"
            name="city"
            placeholder="city"
            onChange={(event) =>
                {
                    setCity(event.target.value);      
                }}          
            />

            <input type="text"
            name="state"
            placeholder="state"
            onChange={(event) =>
                {
                    setState(event.target.value);      
                }}          
            />

            <input type="text"
            name="postalcode"
            placeholder="postalcode"
            onChange={(event) =>
                {
                    setPcode(event.target.value);      
                }}          
            />
         <input type="text"
            name="mobile"
            placeholder="phone"
            onChange={(event) =>
                {
                    setPhone(event.target.value);      
                }}          
            />
 
    
 
            <button type="submit">Register</button>
 
    
            </form>    
 
    
        </div>
    )
}
 
export default Registration;