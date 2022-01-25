import './AddTransactions.css'

import { useState } from "react"
import { useHistory } from "react-router-dom"

function AddTransactions() {
    const history = useHistory()

    const [transactions, setTransactions] = useState({
        "id_user_detail": 0,
        "transaction_date": new Date(),
        "type_of_transaction": "deposit",
        "total": 0
    })

    function onChange(e) {
        setTransactions((oldValue) => {
            return { ...oldValue, [e.target.id]: e.target.value }
        })
    }

    function add(e) {
        console.log(transactions)
        e.preventDefault()

        fetch("http://localhost:8080/transaction", {
            method: "POST",
            headers: {
                "Authorization": "Bearer " + localStorage.getItem('token'),
                "Content-type":"application/json"
            },
            body: JSON.stringify(transactions)
        })
            .then(response => {
                return response.json()
            })
            .then(data => {
                console.log(data)
                history.push("/history-transactions")
            })
            .catch(err => {
                console.log(err)
            })
    }

    return (
        <div>
            <form className="" onSubmit={add}>
                <h2>Please Fill all</h2>
                <div className="col-12 mt-4">
                    <label className="form-label">Total</label>
                    <input type="number" className="form-control" id="total" onChange={onChange} value={transactions.total} />
                </div>
                <div className="col-md-6 mt-4">
                    <label className="form-label">Date</label>
                    <input type="DateTime-local" id="transaction_date" className="form-control" onChange={onChange} value={transactions.transaction_date} />
                </div>
                <div className="col-md-4 mt-4">
                    <label className="form-label">Type Transactions</label>
                    <select id="type_of_transaction" onChange={onChange} value={transactions.type_of_transaction} className="form-select">
                        <option value="deposit">Deposit</option>
                        <option value="withdraw">Withdraw</option>
                    </select>
                </div>
                <div className="col-12">
                    <button type="submit" className="btn btn-primary">Proccess</button>
                </div>
            </form>
        </div>
    )
}

export default AddTransactions