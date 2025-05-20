<template>
  <img
    :src="validSrc"
    @error="setDefaultImage"
    alt="아바타"
    class="w-16 h-16 rounded-full object-cover border border-gray-300"
    v-bind="$attrs"
  />
</template>

<script setup>
import { computed } from "vue";
const props = defineProps({
  src: String,
  defaultSrc: {
    type: String,
    default: "/default_profile.png",
  },
});

const validSrc = computed(() => props.src || props.defaultSrc);

function setDefaultImage(e) {
  e.target.src = props.defaultSrc;
}
</script>
