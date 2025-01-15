import React, {useState} from "react";
import { useNavigate, Link } from "react-router-dom";
import AuthService from "../services/auth.service";

const LoginComponent = () => {
    const [username, setUsername] = useState(""); 
    const [password, setPassword] = useState(""); 
    const [message, setMessage] = useState("");
    const navigate = useNavigate();

    const handleLogin = async (e) => {
        e.preventDefault(); 
        try {
            const response = await AuthService.login({username, password});
            if (response.data == "Login successful!") {
                navigate("/dashboard");
            } else {
                setMessage("Invalid username or password"); 
            }
        } catch (error) {
            const resMessage = (error.response && error.response.data && error.response.data.message) || error.message || error.toString(); 
            setMessage(resMessage);
        }
    }; 

    return (
        <div className="login-page">
            <div className="grid grid-cols-5 gap-3">
                <div className="login-form col-span-4">
                    {/* TODO: ADD THE LOGIN FORM */}
                    <div className="not-registered-message">
                        <p>Not registered yet? <Link to="/register">REGISTER NOW!</Link></p>
                    </div>
                </div>
                <div className = "piggy-logo col-span-1">
                    {/* TODO: ADD THE PIGGY LOGO */}
                </div>
            </div>
        </div>
    ); 
};


export default LoginComponent;