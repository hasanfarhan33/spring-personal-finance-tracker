import React from "react";

const NavbarComponent = () => {
   return (
    <header>
        <div className = "navbar bg-green-300 flex justify-between items-center">
            <div className = "piggyLogo">
                <img src=""></img>
            </div>
            <div className="title">
                <h1 className="text-center text-black font-extrabold text-2xl py-2">MY PIGGY BANK 💸</h1>
            </div>
            <div className="nav-links font-bold text-lg">
                <ul className="flex justify-between items-center">
                    <li className="Home hover:underline cursor-pointer px-2">Home</li>
                    <li className="About hover:underline cursor-pointer px-2">About</li>
                    <li className="Login hover:underline cursor-pointer px-2">Login</li>
                    <li className="Register hover:underline cursor-pointer px-2">Register</li>
                </ul>
            </div>
        </div>
    </header>
    
   );  
}; 

export default NavbarComponent; 