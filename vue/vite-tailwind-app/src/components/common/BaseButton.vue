<template>
  <button
    :disabled="disabled"
    class="w-full px-4 py-2 rounded-md text-white font-semibold bg-blue-500 hover:bg-blue-600 disabled:bg-gray-300 disabled:cursor-not-allowed"
    :class="optionClass"
  >
    <slot></slot>
  </button>
</template>

<script setup>
defineProps({
  disabled: Boolean,
  optionClass: String,
});
</script>
