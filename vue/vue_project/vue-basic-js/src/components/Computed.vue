<template>
  <div style="padding: 2rem">
    <h2>computed example</h2>
    <input type="text" v-model.number="num1" placeholder="input num 1" />
    <input type="text" v-model.number="num2" placeholder="input num 2" />
    <p>sum : {{ sum }}</p>
  </div>
</template>

<script setup>
import { ref, computed } from "vue";

const num1 = ref(0);
const num2 = ref(0);

// computed는 의존하는 값이 변경될때만 재계산됨
const sum = computed(() => {
  console.log("sum");
  return num1.value + num2.value;
});

// const sum = () => {
//   console.log("sum");
//   return num1.value + num2.value;
// };
</script>

<style scoped>
input {
  padding: 8px;
  margin-right: 8px;
  width: 120px;
}
p {
  margin-top: 1rem;
  font-size: 20px;
  font-weight: bold;
}
</style>
