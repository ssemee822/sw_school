<template>
  <div>
    <input type="text" v-model="name" placeholder="name" />
    <br />
    <input type="text" v-model.number="age" placeholder="age" />
    <p>이름 : {{ name }}</p>
    <p>나이 : {{ age }}</p>
    <p>{{ isAdult ? "성인입니다" : "성인이 아닙니다." }}</p>
    <p>나이 변경 로그 : {{ ageLog }}</p>
  </div>
</template>

<script setup>
import { ref, reactive, computed, watch, onMounted } from "vue";

const name = ref("ksm");
const age = ref(25);
const ageLog = reactive([]);

const isAdult = computed(() => {
  console.log("isAdult");
  if (age.value >= 20) return true;
  else return false;
});

watch(age, (newVar, oldVar) => {
  console.log("watch");
  ageLog.push(oldVar);
});

onMounted(() => {
  console.log("컴포넌트가 마운트됨");
});
</script>
