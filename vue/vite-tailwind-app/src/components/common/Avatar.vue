<template>
  <img
    :src="validSrc"
    @error="setDefaultImage"
    alt="아바타"
    :class="imgSize"
    class="rounded-full object-cover border border-gray-300"
    v-bind="$attrs"
  />
</template>

<script setup>
import { computed } from "vue";

const props = defineProps({
  src: String,
  size: String,
  defaultSrc: {
    type: String,
    default: "/default_profile.png",
  },
});

const validSrc = computed(() => props.src || props.defaultSrc);
const imgSize = computed(() => (props.size ? props.size : "w-16 h-16"));

function setDefaultImage(e) {
  e.target.src = props.defaultSrc;
}
</script>
