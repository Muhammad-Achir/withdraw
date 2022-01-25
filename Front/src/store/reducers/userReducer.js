function userReducer (state = {}, action) {
    switch (action.type) {
        case "SET_USER":
            return action.payload
            
        case "WITHDRAW":
            return { ...state, balance: action.payload}

        case "DEPOSIT":
            return { ...state, balance: action.payload}
    
        default:
            return state
    }
}

export default userReducer