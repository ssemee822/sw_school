<template>
  <h2>고정 클래스</h2>
  <div class="box">항상 적용되는 클래스</div>

  <h2>조건부 클래스 (객체 방식)</h2>
  <div :class="{ active: isActive, error: hasErr }" class="box">
    {{ isActive ? "active" : "" }} {{ hasErr ? "error" : "" }}
  </div>

  <h2>배열 클래스 (동적 조합)</h2>
  <div :class="['box', isActive ? 'active' : '', hasErr ? 'error' : '']"></div>

  <div style="margin-top: 20px">
    <button @click="isActive = !isActive">Toggle</button>
    <button @click="hasErr = !hasErr">Toggle</button>
  </div>
</template>

<script setup>
import { ref } from "vue";

const isActive = ref(true);
const hasErr = ref(false);
const status = "";
</script>

<style scoped>
.box {
  padding: 1rem;
  border: 1px solid #ccc;
  margin-bottom: 1rem;
}
.active {
  background-color: #d1fae5;
  border-color: #10b981;
}
.error {
  background-color: #fee2e2;
  border-color: #ef4444;
}
button {
  margin-right: 10px;
  padding: 6px 12px;
  background-color: #3b82f6;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}
</style>
