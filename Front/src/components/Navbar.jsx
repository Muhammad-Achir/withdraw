import React from 'react'
import { Link } from 'react-router-dom'
import { useSelector } from "react-redux"

import "./Navbar.css"

function Navbar(props) {

    const user = useSelector(state => state.user)

    let isLoggedIn = props.isLoggedIn

    return (
        <div className="d-flex">
            {
                isLoggedIn ?
                    <div>
                        <p className='currenc'>
                            Wellcome {user.name} your balance: 
                            {user.balance.toLocaleString("id-ID", {style:"currency", currency:"IDR"})}
                        </p>

                        <p onClick={props.logout} className="nav-link currenc">Logout
                        </p>
                    </div> :
                    <Link to="/login" className="nav-link">Login</Link>
            }
        </div>
    )
}

export default Navbar