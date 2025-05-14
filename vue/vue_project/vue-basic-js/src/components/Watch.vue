<template>
  <div style="padding: 2rem">
    <h2>watch example</h2>
    <input type="text" v-model="search" placeholder="input search keyword" />
    <p>current keyword : {{ search }}</p>
    <p>recent keyword : {{ recent }}</p>
  </div>
</template>

<script setup>
import { ref, watch } from "vue";

const search = ref("");
const recent = ref("");

watch(search, (newVar, oldVar) => {
  console.log(`search keyword: ${oldVar} to ${newVar}`);
  recent.value = newVar;
});
</script>

<style scoped>
input {
  padding: 8px;
  width: 200px;
  margin-bottom: 1rem;
}
p {
  font-size: 20px;
  margin: 4px 0;
}
</style>
