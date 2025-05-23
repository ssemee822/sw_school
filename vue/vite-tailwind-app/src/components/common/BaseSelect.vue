<template>
  <select
    :value="modelValue"
    @change="$emit('update:modelValue', $event.target.value)"
    class="w-full border px-4 py-2 rounded text-sm"
    required
  >
    <option disabled value="">카테고리를 선택하세요</option>
    <option
      v-for="category in categories"
      :key="category"
      :value="category.categoryId"
    >
      {{ category.categoryName }}
    </option>
  </select>
</template>

<script setup>
defineProps({
  modelValue: String,
  categories: Array,
});

defineEmits(["update:modelValue"]);
</script>
