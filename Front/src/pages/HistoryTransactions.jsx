import './HistoryTransactions.css'

import ListTransaction from '../components/ListTransaction'

import Swal from 'sweetalert2'

import React, { useEffect, useState } from 'react'

function HistoryTransactions() {

    const [history, setHistory] = useState([])

    useEffect(() => {
        fetch('http://localhost:8080/transaction', {
            headers: {
                'Authorization': "Bearer " + localStorage.getItem('token')
            }
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error(Error)
                }
                return response.json()
            })
            .then(data => {
                setHistory(data)
            })
            .catch(err => {
                Swal.fire({
                    title: "Error",
                    text: "Connection refused",
                    icon: "error",
                    confirmButtonText: "OK"
                })
            })
    }, [])

    return (
        <div className="list">
            <table className="table table-dark table-striped">
                <thead>
                    <tr>
                        <th scope="col">id</th>
                        <th scope="col">Date</th>
                        <th scope="col">Type</th>
                        <th scope="col">Total</th>
                    </tr>
                </thead>
                <tbody>
                    {history.map(h => (
                        <ListTransaction key={history.id_transactions} history={h}></ListTransaction>
                    ))}
                </tbody>
            </table>
        </div>
    )
}

export default HistoryTransactions