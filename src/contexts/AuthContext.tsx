import React, {useContext, useEffect, useState} from "react"
import auth from "../firebaseSetup";
import {
    onAuthStateChanged,
    createUserWithEmailAndPassword,
    signInWithEmailAndPassword,
    signOut,
    sendPasswordResetEmail,
    updateEmail as fUpdateEmail,
    updatePassword as fUpdatePassword,
    UserCredential,
    User
} from 'firebase/auth';

interface Props {
    children: JSX.Element | JSX.Element[],
}

interface IAuthContext {
    currentUser: User | null,
    login: (email: string, password: string) => Promise<UserCredential>,
    signup: (email: string, password: string) => Promise<UserCredential>,
    logout: () => Promise<void>,
    resetPassword: (email: string) => Promise<void>,
    updateEmail: (email: string) => Promise<void>,
    updatePassword: (password: string) => Promise<void>
}

const AuthContext = React.createContext<IAuthContext | null>(null);

export function useAuth() {
    return useContext(AuthContext);
}

export const AuthProvider: React.FC<Props> = ({children}) => {
    const [currentUser, setCurrentUser] = useState<User | null>(null);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        //validate on first render if the user is already authenticated
        const unsuscribe = onAuthStateChanged(auth, (firebaseUser: User | null) => {
                setCurrentUser(firebaseUser);
                setLoading(false);
            }
        )
        return unsuscribe;
    }, []);

    function signup(email: string, password: string): Promise<UserCredential> {
        return createUserWithEmailAndPassword(auth, email, password);
    }

    function login(email: string, password: string): Promise<UserCredential> {
        return signInWithEmailAndPassword(auth, email, password);
    }

    function logout(): Promise<void> {
        return signOut(auth);
    }

    function resetPassword(email: string): Promise<void> {
        return sendPasswordResetEmail(auth, email);
    }

    function updateEmail(email: string): Promise<void> {
        return fUpdateEmail(currentUser!, email);
    }

    function updatePassword(password: string): Promise<void> {
        return fUpdatePassword(currentUser!, password);
    }

    const value = {
        currentUser,
        login,
        signup,
        logout,
        resetPassword,
        updateEmail,
        updatePassword
    };


    return (
        <>
            <AuthContext.Provider value={value}>
                {!loading && children}
            </AuthContext.Provider>
        </>
    )
}