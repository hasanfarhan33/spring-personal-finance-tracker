import React, {useState} from "react";
import { useNavigate, Link } from "react-router-dom";
// import AuthService from "../services/auth.service";
import piggycoin from "../images/piggycoin.png";
import { useEffect } from "react";

const RegisterComponent = () => {
    const [firstName, setFirstName] = useState("");
    const [lastName, setLastName] = useState("");
    const [username, setUsername] = useState(""); 
    const [email, setEmail] = useState(""); 
    const [password, setPassword] = useState("");
    const [successful, setSuccessful] = useState(false);
    const [message, setMessage] = useState("");
    const navigate = useNavigate();

    // const handleRegister = async (e) => {
    //     e.preventDefault(); 
    //     try {
    //         const response = await AuthService.register({firstName, lastName, username, email, password});
    //         setMessage(response.data.message);
    //         if (response.data == "User registered successfully!") {
    //             setSuccessful(true); 
    //             navigate("/login"); 
    //         }
    //     } catch (error) {
    //         const resMessage = (error.response && error.response.data && error.response.data.message) || error.message || error.toString(); 
    //         setMessage(resMessage);
    //         setSuccessful(false);
    //     }
    // };

    // To remove scrolling when the home page is rendered
    useEffect(() => {
        document.body.style.overflow = "hidden"; 
        document.title = "My Piggy Bank | Register";
        return () => {
            document.body.style.overflow = "auto"; 
        }
    }, [])

    // TODO: IMPLEMENT THIS FUNCTION
    const handleRegister = () => {
        console.log("First Name: ", firstName);
        console.log("Last Name: ", lastName);
        console.log("Username: ", username);
        console.log("Email: ", email);
        console.log("Password: ", password);
    }

    // TODO: ALIGN THINGS PROPERLY
    return (
        <div className="register-page m-5 min-h-screen">
            <div className="grid grid-cols-4 gap-3">
                <div className="register-form col-span-2 flex justify-center items-center flex-col h-96">
                    <h1 className="text-center font-bold text-2xl underline  py-2">Register</h1>
                    <div className="form-container flex justify-center items-center flex-col">
                        <form onSubmit={handleRegister}>
                            <div className="firstname-group flex justify-around items-center">
                                <label className="font-bold text-lg pr-2" htmlFor="firstname">First Name</label>
                                <input className="pl-2 border-b-2 border-transparent focus:border-b-green-300 outline-none transition duration-200" type="text" id="firstname" name="firstname" value={firstName} onChange={(e) => setFirstName(e.target.value)} required />
                            </div>
                            <div className="lastname-group flex justify-around items-center">
                                <label className="font-bold text-lg pr-2" htmlFor="lastname">Last Name</label>
                                <input className="pl-2 border-b-2 border-transparent focus:border-b-green-300 outline-none transition duration-200" type="text" id="lastname" name="lastname" value={lastName} onChange={(e) => setLastName(e.target.value)} required />
                            </div>
                            <div className="username-group flex justify-around items-center">
                                <label className="font-bold text-lg pr-2" htmlFor="username">Username</label>
                                <input className="pl-2 border-b-2 border-transparent focus:border-b-green-300 outline-none transition duration-200" type="text" id="username" name="username" value={username} onChange={(e) => setUsername(e.target.value)} required />
                            </div>
                            <div className="email-group flex justify-around items-center">
                                <label className="font-bold text-lg pr-2" htmlFor="email">Email</label>
                                <input className="pl-2 border-b-2 border-transparent focus:border-b-green-300 outline-none transition duration-200" type="email" id="email" name="email" value={email} onChange={(e) => setEmail(e.target.value)} required />
                            </div>
                            <div className="password-group flex justify-around items-center">
                                <label className="font-bold text-lg pr-2" htmlFor="password">Password</label>
                                <input className="pl-2 border-b-2 border-transparent focus:border-b-green-300 outline-none transition duration-200" type="password" id="password" name="password" value={password} onChange={(e) => setPassword(e.target.value)} required />
                            </div>
                            <div className="password-again-group flex justify-around items-center">
                                <label className="font-bold text-lg pr-2" htmlFor="password-again">Confirm Password</label>
                                <input className="pl-2 border-b-2 border-transparent focus:border-b-green-300 outline-none transition duration-200" type="password" id="password-again" name="password-again" required />
                            </div>
                            <div className="submit-button flex justify-center items-center">
                                <button className="login-button bg-green-300 py-2 px-4 my-2 rounded-full font-bold text-lg hover:shadow-md show-black transition duration-200" type="submit">Register</button>
                            </div>
                        </form>
                    </div>
                </div>
                <div className = "piggy-logo col-span-2 flex justify-center flex-col h-96">
                    <img src={piggycoin} className="h-64 object-contain" alt="piggy with coin"></img>
                    
                </div>
            </div>
        </div>
    ); 

}; 

export default RegisterComponent; 