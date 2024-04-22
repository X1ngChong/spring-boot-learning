<script setup>
import {useUserStore} from '../stores/user.js'
import {ref} from "vue";
const useStore = useUserStore()

const loginUserDto = ref({
  phone:'15805133083',
  code: ''
})
const countdownTime = ref(60) // 倒计时初始值
const isCountingDown = ref(false) // 是否正在倒计时
let countdownInterval = null // 倒计时计时器

function startCountdown() {
  if (isCountingDown.value) return
  isCountingDown.value = true
  countdownTime.value = 60

  countdownInterval = setInterval(() => {
    if (countdownTime.value > 0) {
      countdownTime.value--
    } else {
      stopCountdown()
    }
  }, 1000)

  // 在这里调用获取验证码的方法
  useStore.userGetCode(loginUserDto.value.phone)
}

function stopCountdown() {
  clearInterval(countdownInterval)
  isCountingDown.value = false
  countdownTime.value = 60
}
</script>
<template>
  <div class="container2">
    <div class="form">
    <h2>用户登录</h2>
      <input type="text" class="input1" placeholder="请输入手机号" v-model="loginUserDto.phone"/><br>
      <input type="text" placeholder="请输入验证码" v-model="loginUserDto.code"/>
      <button v-if="!isCountingDown" class="button2"@click="startCountdown()">获取验证码</button>
      <button v-else class="button2">{{countdownTime }}秒后重试</button>
      <button @click="useStore.userLogin(loginUserDto)">登录</button>
    </div>
  </div>
</template>

<style scoped>
.container2{
  background-image: linear-gradient(to right,#97d2f4,#c8e5f5,#f8f8f8);
  height: 100vh;
  display: flex;
  justify-self: center;
  align-items: center;
}
.form {
  background-color: #fff;width: 600px;
  height: 350px;
  border-radius: 8px;padding: 10px;
  box-shadow: 12px 12px 16px#999;
  text-align: center;
  margin: 10px auto;
}
.form h2{
  color:#333;
  margin: 10px auto;
  letter-spacing: 10px;}

.form input {
  width: 400px;
  outline: none;
border: 1px solid #ccc;
  border-radius: 8px;
margin:20px auto;
  padding: 10px 5px;
}
.form .input1{
margin-right: 100px;
}


.form button {
  width: 400px;
  margin: 20px auto;
  padding: 10px 5px;
  outline: none;
  border: none;
  background-color: #4eaadf;
  color: white;
  border-radius: 8px;
  cursor: pointer;
}

.form .button2 {
  width: 100px;
  margin: 20px auto;
  padding: 10px 5px;
  outline: none;
  border: none;
  background-color: #4eaadf;
  color: white;
  border-radius: 8px;
  cursor: pointer;
}
</style>
