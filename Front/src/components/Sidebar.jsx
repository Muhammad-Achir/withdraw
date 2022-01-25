import { Link } from 'react-router-dom'
import './Sidebar.css'

function Sidebar() {
    return (
        <div className="parent">
            <div className='sidebar'>
                <ul class="list-group">
                    <li >
                        <Link className='list-group-item' to='/'>
                            Home
                        </Link>
                    </li>
                    <li>
                        <Link className='list-group-item' to='/add-transaction'>
                            Add Transaction
                        </Link>
                    </li>
                    <li>
                        <Link className='list-group-item' to='/history-transactions'>
                            History Transactions
                        </Link>
                    </li>
                </ul>
            </div>
        </div>
    )
}

export default Sidebar