import React, {useState} from "react";
import { useNavigate, Link } from "react-router-dom";
import AuthService from "../services/auth.service";

const RegisterComponent = () => {
    const [firstName, setFirstName] = useState("");
    const [lastName, setLastName] = useState("");
    const [username, setUsername] = useState(""); 
    const [email, setEmail] = useState(""); 
    const [password, setPassword] = useState("");
    const [successful, setSuccessful] = useState(false);
    const [message, setMessage] = useState("");
    const navigate = useNavigate();

    const handleRegister = async (e) => {
        e.preventDefault(); 
        try {
            const response = await AuthService.register({firstName, lastName, username, email, password});
            setMessage(response.data.message);
            if (response.data == "User registered successfully!") {
                setSuccessful(true); 
                navigate("/login"); 
            }
        } catch (error) {
            const resMessage = (error.response && error.response.data && error.response.data.message) || error.message || error.toString(); 
            setMessage(resMessage);
            setSuccessful(false);
        }
    };

    // TODO: FINISH THE REGISTRATION FORM
    return (
        <div className="registration-page">
            <div className="grid grid-cols-5 gap-3">
            <div className="registration-form col-span-4">
                {/* TODO: ADD THE REGISTRATION FORM HERE */}
            </div>
            <div className="piggy-logo col-span-1">
                {/* TODO: ADD THE PIGGY LOGO HERE */}
            </div>
        </div>
        </div>
    ); 

}; 

export default RegisterComponent; 