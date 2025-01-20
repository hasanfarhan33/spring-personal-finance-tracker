import React from "react";
import { useEffect } from "react";
import { Link } from "react-router-dom";

const AboutComponent = () => {

    useEffect(() => {
        document.title = "My Piggy Bank | About"; 
        return () => {
            document.title = "My Piggy Bank"; 
        };
    }, []);

    // TODO: STYLE THIS LATER
    return (
        <div className="about-page m-5 min-h-screen">
            <div className="about-content flex justify-center items-center flex-col">
                <h1 className="text-center font-bold text-2xl underline py-2">About</h1>
                <div className="about-text">
                    <p>My Piggy Bank is a web app that allows you to manage your finances. The app is developed using Java Spring Boot, PostgreSQL, and React.<br></br>
                    Check out the repository <Link to="https://github.com/hasanfarhan33/spring-personal-finance-tracker" target="_blank" rel="noopener noreferrer" className="font-bold text-blue-500 hover:underline transition duration-200">here</Link>.</p>
                </div>
            </div>
        </div>
    ); 
};

export default AboutComponent; 