import React, {useState} from "react";
import {Outlet, Link, useNavigate} from "react-router-dom";
import {Alert, Button, Container, Nav, Navbar} from "react-bootstrap";
import "./Header.scss";
import {useAuth} from "../../contexts/AuthContext";


export const Header: React.FC = () => {
    const auth = useAuth();
    const navigate = useNavigate();
    const [error, setError] = useState("");


    const logOut = async () => {
        try {
            setError("");
            await auth?.logout();
            navigate("/home");
        } catch {
            setError("Failed login out");
        }

    };

    return (
        <header className={"Header"}>
            <Navbar bg="light" expand="lg">
                <Container>
                    <Link to="/"> <Navbar.Brand>PensumMap</Navbar.Brand> </Link>
                    <Navbar.Toggle aria-controls="basic-navbar-nav"/>
                    <Navbar.Collapse id="basic-navbar-nav">
                        <Nav className=" w-100">
                            <Link className={"nav-link"} to="/home">Home</Link>
                            <Link className={"nav-link"} to="/aboutUs">About us</Link>
                            <div className={"ms-auto"}>
                                <Link className={"btn btn-primary me-2"} to="/signUp">Sign
                                    Up</Link>
                                {auth?.currentUser ?
                                    <Button className={"btn-danger"} onClick={logOut}
                                    >Exit</Button>
                                    : <Link className={"btn btn-primary"}
                                            to="/login">login</Link>
                                }
                            </div>
                        </Nav>
                    </Navbar.Collapse>
                </Container>
            </Navbar>
            {error && <Alert variant="danger">{error}</Alert>}
            <Outlet/>
        </header>

    );
}

