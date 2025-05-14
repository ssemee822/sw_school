<template>
  <ul>
    <li v-for="item in items" :key="item.id">{{ item.name }}</li>
  </ul>
</template>

<script setup>
const items = [
  { id: 1, name: "vue" },
  { id: 2, name: "react" },
  { id: 3, name: "swift" },
];
</script>
