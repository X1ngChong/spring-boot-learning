import http from '../api/http'
export function login(loginUserDto){
        return http.post('/user/login',loginUserDto)
}

export function getCode(phone){
    return http.post('/sms/send'+"/"+phone)
}