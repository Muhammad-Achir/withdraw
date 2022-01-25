import React from 'react'
import { Link } from 'react-router-dom'
import { useSelector } from "react-redux"

function Navbar(props) {

    const user = useSelector(state => state.user)

    let isLoggedIn = props.isLoggedIn

    return (
        <div className="d-flex">
            {
                isLoggedIn ?
                    <div>
                        <span className=''>
                            Wellcome {user.name} your balance:
                            {user.balance}
                        </span>

                        <span onClick={props.logout} className="nav-link">Logout
                        </span>
                    </div> :
                    <Link to="/login" className="nav-link">Login</Link>
            }
        </div>
    )
}

export default Navbar