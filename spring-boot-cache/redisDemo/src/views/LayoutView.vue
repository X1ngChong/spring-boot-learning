<template>
  <nav>
  <RouterLink to="/home">首页</RouterLink>
  </nav>
  <RouterView class="container"/>
</template>

<style>
 nav{
   width: 100%;
   height: 70px;
   line-height: 60px;
   font-size:16px ;
   text-align: center;
   background-color: #97d2f4;
 }
.container{
  width: 70%;
  margin: 10px auto;
  background-color: #c8e5f5;
  min-height: 80vh;
  padding: 20px;
  box-sizing: border-box;
}
</style>

