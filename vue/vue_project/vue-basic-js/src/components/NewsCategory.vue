<template>
  <div class="category-list">
    <button class="category" @click="changeCategory('전체')">전체</button>
    <button class="category" @click="changeCategory('정치')">정치</button>
    <button class="category" @click="changeCategory('경제')">경제</button>
    <button class="category" @click="changeCategory('사회')">사회</button>
    <button class="category" @click="changeCategory('문화')">문화</button>
    <button class="category" @click="changeCategory('과학')">과학</button>
  </div>
</template>

<script setup>
import { ref } from "vue";

const seletedCategory = ref(" ");
const emit = defineEmits(["change-category"]);

const changeCategory = (c) => {
  seletedCategory.value = c;
  emit("change-category", seletedCategory.value);
};
</script>
