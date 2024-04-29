<template>
  <v-form v-model="valid">
    <v-container>
      <v-row>
        <v-col
          cols="12"
          md="4"
        >
          <v-text-field
            v-model="username"
            :counter="10"
            label=" name"
            hide-details
            required
          ></v-text-field>
        </v-col>

        <v-col
          cols="12"
          md="4"
        >
          <v-text-field
            v-model="password"
            :counter="10"
            label="password"
            hide-details
            required
          ></v-text-field>
        </v-col>
      </v-row>
    </v-container>
  </v-form>
  <button @click="login">登录</button>
</template>
<script>

import { ref } from 'vue';
import axios from 'axios';
export default {
  data: () => ({
    valid: false,
    username: '',
    password: '',

  }),
}

const login = async message => {

  try {
    // 假设后端登录接口是 /api/login
    const response = await axios.post('http://localhost:8080/user/login', {
      username: username.value,
      password: password.value,
    });

    // 如果登录成功，通常后端会返回一个token或其他成功信息
    if (response.data.msg ==="success") {
      // 在这里处理登录成功后的逻辑，比如保存token到localStorage等
      alert("code"+response.data.code+" msg:"+response.data.msg);
      console.log("登录成功",response.data)
      // 可以跳转到其他页面或显示登录成功的信息
    } else {
      alert("code"+response.data.code+" msg:"+response.data.msg);
      // 登录失败的处理逻辑
      console.log('登录失败', response.data);
      // 可以显示错误信息给用户
    }
  } catch (error) {
    // 请求错误处理
    console.error('登录请求发生错误', error);
    // 可以显示请求错误的信息给用户
  }
};

</script>
