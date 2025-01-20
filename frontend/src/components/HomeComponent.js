import React, { useEffect } from "react";
import piggycoin from "../images/piggycoin.png";

const HomeComponent = () => {

    // To remove scrolling when the home page is rendered
    useEffect(() => {
        document.body.style.overflow = "hidden"; 
        document.title = "My Piggy Bank | Home";
        return () => {
            document.body.style.overflow = "auto"; 
        }
    }, [])

    return (
        <div className="home-page m-5 flex justify-center items-center flex-col min-h-screen"> 
            
            <div className="piggy-logo flex justify-center flex-col pb-20">
                <img src={piggycoin} className="h-64 object-contain" alt="piggy with coin"></img>
            </div>

            <div className="intro-div pb-20">
                <h1 className="title-message text-3xl font-black text-center">Welcome to MY PIGGY BANK</h1>
                <p className="subtitle-message text-xl font-black text-center"> The best way to manage your finances!</p>
            </div>
            
            <div className="buttons-div flex justify-between items-center w-1/4">
                <button className="login-button bg-green-300 py-2 px-4 my-2 rounded-full font-bold text-lg hover:shadow-md show-black transition duration-200">
                    <a href="/login">Login</a>
                </button>
                <button className="register-button bg-green-300 py-2 px-4 my-2 rounded-full font-bold text-lg hover:shadow-md show-black transition duration-200">
                    <a href="/register">Register</a>
                </button>
            </div>
        </div>
    ); 
}

export default HomeComponent; 