//Core
import React, {FormEvent, useState} from "react";
import { Link, useNavigate } from "react-router-dom";
import {useAuth} from "../../contexts/AuthContext";
//Styles - Bootstrap components
import {Alert, Button, Form} from "react-bootstrap";
import "./SignUp.scss";

export function SignUp() {
    const [validated, setValidated] = useState(false);
    const [error, setError] = useState("");
    const [loading, setLoading] = useState(false);

    const navigate = useNavigate();
    const auth = useAuth();

    //
    const handleSubmit = async (event: FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        //Mark a form as having been validated. Setting it to true will toggle any validation styles on the forms elements.
        setValidated(true);

        const form = event.target as typeof event.target & {
            email: { value: string },
            password: { value: string },
            confirmPassword: { value: string }
        };

        if (form.password.value !== form.confirmPassword.value) {
            setError("Passwords do not match");
            return;
        }

        try {
            setError("");
            setLoading(true);
            await auth?.signup(form.email.value, form.password.value);
            navigate("/");
        } catch {
            setError("Failed to create an account");
        }

        setLoading(false)
    };


    return (
        <>
            {error && <Alert variant="danger">{error}</Alert>}
            <h1 className={"text-center"}>Sign Up</h1>
            <Form className={"SignUpForm"} noValidate validated={validated} onSubmit={handleSubmit}>
                <Form.Group controlId="email">
                    <Form.Label>Email</Form.Label>
                    <Form.Control
                        required
                        type="email"
                        placeholder="example@gmail.com"
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
                <Form.Group controlId="confirmPassword">
                    <Form.Label>Confirm password</Form.Label>
                    <Form.Control
                        required
                        type="password"
                    />
                    <Form.Control.Feedback>Looks good!</Form.Control.Feedback>
                </Form.Group>
                <Button className={"mt-2"} type="submit">Sign Up</Button>
            </Form>
        </>
    );
}

