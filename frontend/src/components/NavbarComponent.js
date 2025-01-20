import React from "react";

// Importing images 
import piggybank from "../images/piggybank.png"; 

// TODO: Add routing to the Home and About pages
const NavbarComponent = () => {
   return (
    <header>
        <div className = "navbar bg-green-300 flex justify-between items-center">
            <div className = "piggyLogo px-2">
                <img src={piggybank} height={50} width={50} alt="piggyLogo"></img>
            </div>
            <div className="title">
                <h1 className="text-center text-black font-extrabold text-3xl py-2">MY PIGGY BANK 💸</h1>
            </div>
            <div className="nav-links font-bold text-lg px-2">
                <ul className="flex justify-between items-center">
                    <li className="Home hover:underline cursor-pointer px-2">Home</li>
                    <li className="About hover:underline cursor-pointer px-2">About</li>
                </ul>
            </div>
        </div>
    </header>
    
   );  
}; 

export default NavbarComponent; 