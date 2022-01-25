function userReducer (state = { name: "test", balance: 0 }, action) {
    switch (action.type) {
        case "SET_USER":
            return {
                name: action.name,
                balance: action.balance
            }
            
        case "WITHDRAW":
            return { ...state, balance: state.balance - action.payload}

        case "DEPOSIT":
            return { ...state, balance: state.balance + action.payload}
    
        default:
            return state
    }
}

export default userReducer