<template>
  <div class="card">
    <h2>{{ user.name }}</h2>
    <p>age : {{ user.age }}</p>
    <p>address : {{ user.address }}</p>
    <p>{{ user.isAdult ? "is adult" : "not adult" }}</p>
  </div>
</template>

<script setup>
const props = defineProps({
  user: Object,
});
</script>

<style scoped>
.card {
  border: 1px solid #ccc;
  padding: 1rem;
  border-radius: 6px;
  width: 300px;
  background-color: bisque;
  margin: 1rem auto;
}
</style>
