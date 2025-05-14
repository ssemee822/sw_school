<template>
  <!-- UI 구조 작성 -->
  <h2>{{ refName }}</h2>
  <h2>{{ name }}</h2>
  <input :value="refName" @input="updateName($event)" />
</template>

<script setup>
// 데이터 로직 정의
// ref : 원시 값을 감싸는 반응형 래퍼
import { ref } from "vue"; // 구조 분해, {}: 해당 모듈에서 ref만 가져옴

let name = "ksm";
const refName = ref("ref");

const updateName = (e) => {
  refName.value = e.target.value;
};
</script>
