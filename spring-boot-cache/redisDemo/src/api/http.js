import axios from 'axios'

const service = axios.create({
    baseURL:'http://localhost:8080',
    timeout:5000
})

//添加请求拦截器
service.interceptors.request.use(
    (config) =>{
        return config
    },
    function (error){
        return Promise.reject(error)
    }
)
service.interceptors.response.use(
    (response)=>{
        if(response.status !== 200){
            return Promise.reject(new Error(response.statusText || 'Error'))
        }
        return response.data
    },
    (error)=>{
        return Promise.reject(error)
    }
)

export default service