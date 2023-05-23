import { ID_SIGNINDIV } from '../constants/constants'
import { useEffect } from 'react';
import jwtDecode, { JwtPayload } from 'jwt-decode';


export interface UserProfile {
    name: string
    email: string
    imageUrl: string
}

interface GoogleJWTPayload extends JwtPayload {
    name: string
    email: string
    picture: string
}

const Login = () => {

    const googleButtonConfiguration: google.accounts.id.GsiButtonConfiguration = {
        type: 'standard',
        theme: "outline",
        size: "large",
        locale: "es"
    };

    const onSuccess = (res: google.accounts.id.CredentialResponse) => {
        console.log("Response", res);
        const decoded = jwtDecode<GoogleJWTPayload>(res.credential as string);
        console.log("DecodedJWT ID token:", decoded);
    } 

    let didInit = false;
    const init = () => {
        google.accounts.id.initialize({
            client_id: import.meta.env.VITE_OAUTH_GOOGLE_CLIENT_ID as string,
            callback: onSuccess
        });
        console.log(import.meta.env.VITE_OAUTH_GOOGLE_CLIENT_ID);
        didInit = true;
    }

    const renderAndPrompt = () => {
        google.accounts.id.renderButton(
            document.getElementById(ID_SIGNINDIV) as HTMLElement,
            googleButtonConfiguration
        );
        google.accounts.id.prompt();
    }

    useEffect(() => {
        /* 
            React.StrictMode renders components twice
            (on dev but not production) in order to
            detect any problems with your code and
            warn you about them (which can be quite useful).
         */
        if(!didInit) {
            init();
            renderAndPrompt();
        }

    }, [])

    return(<div id={ID_SIGNINDIV} className='googleOauthLogin'></div>)
}

export default Login 