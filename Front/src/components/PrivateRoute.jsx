import { Redirect, Route } from "react-router-dom";

function PrivateRoute (props) {
    return (
        <Route
            path={props.path}

            render={({ location }) => {
                const isLoggedIn = localStorage.getItem ('token')

                if (isLoggedIn) {
                    return props.children
                } else {
                    return (
                        <Redirect 
                            to={{ pathname: '/login',
                            state: { from: location }
                        }}
                        >
                        </Redirect>
                    )
                }
            }}
        >
        </Route>
    )
}

export default PrivateRoute