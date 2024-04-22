import { ref } from 'vue'
import { defineStore } from 'pinia'
import {useRouter} from 'vue-router'
import {login,getCode} from "@/api/user.js";

export const useUserStore = defineStore('user',()=>{
    const user = ref(
        localStorage.getItem('user') != null ? JSON.parse(localStorage.getItem('user')) :null
    )

    const  router = useRouter()

    function userLogin(val){
        login(val).then((res) => {
            if (res.code === 200){
                console.log(res.data)
                user.value = res.data
                localStorage.setItem('user',JSON.stringify(res.data))
                router.push('/')
            }else {
                console.log(res.data)
                alert(res.msg)
            }
        })
    }

    function userGetCode(phone){
        getCode(phone).then(res =>{
           alert("发送成功")
        } )
    }

    return {user,userLogin,userGetCode}
})