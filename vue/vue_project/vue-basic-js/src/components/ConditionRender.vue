<template>
  <h1 v-if="isLogin">Welcome, {{ name }}</h1>
  <h1 v-else>Please Login</h1>
</template>

<script setup>
const isLogin = false;
const name = "ksm";
</script>
