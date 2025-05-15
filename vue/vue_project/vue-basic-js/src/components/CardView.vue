<template>
  <div class="card">
    <h2>name : {{ name }}</h2>
    <p>job : {{ job }}</p>
    <p>age : {{ age }}</p>
  </div>
</template>

<script setup>
const props = defineProps({
  name: String,
  job: String,
  age: Number,
});
</script>

<style scoped>
.card {
  border: 1px solid #ccc;
  padding: 1rem;
  border-radius: 8px;
}
</style>
