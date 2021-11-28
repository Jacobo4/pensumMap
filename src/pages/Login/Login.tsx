//Core
import React, {FormEvent, useState} from "react";
import {useNavigate} from "react-router-dom";
import {useAuth} from "../../contexts/AuthContext";
//Styles - Bootstrap components
import {Alert, Button, Form} from "react-bootstrap";
import "./Login.scss";

export const Login: React.FC = () => {
    const [validated, setValidated] = useState(false);
    const [error, setError] = useState("");
    // const [loading, setLoading] = useState(false);

    const navigate = useNavigate();
    const auth = useAuth();

   const handleSubmit = async (event: FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        //Mark a form as having been validated. Setting it to true will toggle any validation styles on the forms elements.
        setValidated(true);

        const form = event.target as typeof event.target & {
            email: { value: string },
            password: { value: string },
        };


        try {
            setError("");
            // setLoading(true);
            await auth?.login(form.email.value, form.password.value);
            navigate("/");
        } catch {
            setError("Failed to create an account");
        }

        // setLoading(false)
    };


    return (
        <>
            {error && <Alert variant="danger">{error}</Alert>}
            <h1 className={"text-center"}>Login</h1>
            <Form className={"LoginForm"} noValidate validated={validated} onSubmit={handleSubmit}>
                <Form.Group controlId="email">
                    <Form.Label>Email</Form.Label>
                    <Form.Control
                        required
                        type="email"
                    />
                    <Form.Control.Feedback>Looks good!</Form.Control.Feedback>
                </Form.Group>
                <Form.Group controlId="password">
                    <Form.Label>Password</Form.Label>
                    <Form.Control
                        required
                        type="password"
                    />
                    <Form.Control.Feedback>Looks good!</Form.Control.Feedback>
                </Form.Group>
                <Button className={"mt-2"} type="submit">Login</Button>
            </Form>
        </>
    );
}

