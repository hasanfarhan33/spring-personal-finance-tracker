import React, {useEffect, useState} from "react";
import { useNavigate, Link } from "react-router-dom";
import piggycoin from "../images/piggycoin.png";
// import AuthService from "../services/auth.service";

const LoginComponent = () => {
    const [username, setUsername] = useState(""); 
    const [password, setPassword] = useState(""); 
    const [message, setMessage] = useState("");
    const navigate = useNavigate();

    // const handleLogin = async (e) => {
    //     e.preventDefault(); 
    //     try {
    //         const response = await AuthService.login({username, password});
    //         if (response.data == "Login successful!") {
    //             navigate("/dashboard");
    //         } else {
    //             setMessage("Invalid username or password"); 
    //         }
    //     } catch (error) {
    //         const resMessage = (error.response && error.response.data && error.response.data.message) || error.message || error.toString(); 
    //         setMessage(resMessage);
    //     }
    // }; 

    // To remove scrolling when the home page is rendered
    useEffect(() => {
        document.body.style.overflow = "hidden"; 
        document.title = "My Piggy Bank | Login";
        return () => {
            document.body.style.overflow = "auto"; 
        }
    }, [])

    const handleLogin = () => {
        console.log("Username: ", username);
        console.log("Password: ", password);
    }

    return (
        <div className="login-page m-5 min-h-screen">
            <div className="grid grid-cols-4 gap-3">
                <div className="login-form col-span-2 flex justify-center items-center flex-col h-96">
                    <h1 className="text-center font-bold text-2xl underline  py-2">Login</h1>
                    <div className="form-container flex justify-center items-center flex-col">
                        <form onSubmit={handleLogin}>
                            <div className="username-group flex justify-around items-center">
                                <label className="font-bold text-lg pr-2" htmlFor="username">Username</label>
                                <input className="pl-2 border-b-2 border-transparent focus:border-b-green-300 outline-none transition duration-200" type="text" id="username" name="username" value={username} onChange={(e) => setUsername(e.target.value)} required />
                            </div>
                            <div className="password-group flex justify-around items-center">
                                <label className="font-bold text-lg pr-2" htmlFor="password">Password</label>
                                <input className="pl-2 border-b-2 border-transparent focus:border-b-green-300 outline-none transition duration-200" type="password" id="password" name="password" value={password} onChange={(e) => setPassword(e.target.value)} required />
                            </div>
                            <div className="submit-button flex justify-center items-center">
                                <button className="login-button bg-green-300 py-2 px-4 my-2 rounded-full font-bold text-lg hover:shadow-md show-black transition duration-200" type="submit">Login</button>
                            </div>
                        </form>
                    </div>
                    <div className="not-registered-message">
                        <p>Not registered yet? <Link to="/register" className="register-now-text font-bold text-blue-500 hover:underline transition duration-200">REGISTER NOW!</Link> 💵</p>
                    </div>
                </div>
                <div className = "piggy-logo col-span-2 flex justify-center flex-col h-96">
                    <img src={piggycoin} className="h-64 object-contain" alt="piggy with coin"></img>
                    
                </div>
            </div>
        </div>
    ); 
};


export default LoginComponent;