<template>
  <div>
    <h2>User Info</h2>
    <p>name: {{ member.name }}</p>
    <p>age: {{ member.age }}</p>
    <p>addr: {{ member.addr }}</p>
    <p>position: {{ member.position }}</p>
    <input v-model="member.name" placeholder="input name" />
    <br />
    <input v-model="member.age" placeholder="input age" />
    <br />
    <input v-model="member.addr" placeholder="input addr" />
    <br />
    <input v-model="member.position" placeholder="input position" />
  </div>
</template>

<script setup>
import { reactive } from "vue";

const member = reactive({
  name: "ksm",
  age: 25,
  addr: "korea",
  position: "a",
});
</script>
