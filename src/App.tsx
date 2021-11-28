//Core
import React from 'react';
import {
    BrowserRouter,
    Routes,
    Route
} from "react-router-dom";
import {AuthProvider} from "./contexts/AuthContext";
//Styles - Bootstrap components
import "./App.scss";
import {Container} from "react-bootstrap";
//Components - pages - layouts
import RequireAuth from "./components/RequireAuth/RequireAuth";
import {Header} from "./layouts/Header/Header";
import {Login} from "./pages/Login/Login";
import {SignUp} from "./pages/SignUp/SignUp";
import PensumMap from "./pages/PensumMap/PensumMap";
import AboutUs from "./pages/AboutUs/AboutUs";
import Home from "./pages/Home/Home";

function App() {
    return (
        <BrowserRouter>
            <AuthProvider>
                <Header/>
                <Container>
                    <Routes>
                        <Route
                            path="/"
                            element={
                                <RequireAuth>
                                    <PensumMap/>
                                </RequireAuth>
                            }
                        />
                        <Route path="/home" element={<Home/>}/>
                        <Route path="/aboutUs" element={<AboutUs/>}/>
                        <Route path="/login" element={<Login/>}/>
                        <Route path="/signUp" element={<SignUp/>}/>
                    </Routes>
                </Container>
            </AuthProvider>
        </BrowserRouter>
    );
}

export default App;
