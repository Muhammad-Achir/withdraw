import constant from "../constant";

export function setUser (payload) {
    return { type: constant.SET_USER, payload}
}
export function setWithdraw (payload) {
    return { type: constant.WITHDRAW, payload }
}
export function setDeposit (payload) {
    return { type: constant.DEPOSIT, payload }
}
