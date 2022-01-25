import React, {useState, useEffect } from "react"
import { useHistory } from 'react-router-dom'
import { useDispatch } from "react-redux"

import { setUser } from "../store/action" 

import './Login.css'

function Login (props) {
    const history = useHistory()
    const dispatch = useDispatch ()

    const [ credentials, setCredentials ] = useState ({
        name: '',
        password: ''
    })

    function onChange (e) {
        setCredentials((oldValue) => {
            return { ...oldValue, [e.target.id]: e.target.value}
        })
    }

    function login (e) {
        e.preventDefault()

        fetch('http://localhost:8080/login', {
            method: 'POST',
            headers: {
                'content-type': 'application/json'
            },
            body: JSON.stringify(credentials)
        })
        .then (response => {
            return response.json()
        })
        .then (data => {
            // console.log(data)
            dispatch(setUser(data))
            localStorage.setItem ('token', data.token)
            props.setLogin ()           

            history.push ('/')
        })
        .catch (err => {
            console.log(err)
        })
    }

    return (
        <div>
            <form className="" onSubmit={login}>
            <h4 className="pt-4">Login</h4>
                <div className="">
                    <label for="" className="form-label">Name</label>
                    <input type="name" className="form-control" id="name" aria-describedby="emailHelp" onChange={onChange} value={credentials.name}></input>
                </div>
                <div className="">
                    <label for="exampleInputPassword1" className="form-label">Password</label>
                    <input type="password" onChange={onChange} value={credentials.password}className="form-control" id="password"></input>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    )
}

export default Login