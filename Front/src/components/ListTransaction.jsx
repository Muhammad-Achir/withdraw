function ListTransaction(props) {
    const history = props.history
    return (
        <tr>
            <th scope="row">{history.id_transactions}</th>
            <td>{history.transaction_date}</td>
            <td>{history.type_of_transaction}</td>
            <td>{history.total}</td>
        </tr>
    )
}

export default ListTransaction