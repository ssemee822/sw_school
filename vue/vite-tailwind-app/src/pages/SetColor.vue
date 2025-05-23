<template>
  <div class="min-h-screen bg-gray-100 p-4 flex justify-center items-start">
    <div class="w-full max-w-2xl space-y-4">
      <h2 class="text-2xl font-bold text-gray-800 text-center mb-4">
        🎨 테마 색상 선택
      </h2>
      <div class="space-y-4">
        <BaseCard
          class="rounded text-black font-medium shadow"
          v-for="c in colors"
          :key="c"
          @click="setColor(c)"
          :style="{ backgroundColor: c }"
        >
          color : {{ c }}
        </BaseCard>
      </div>
    </div>
  </div>
</template>

<script setup>
import { useThemeStore } from "@/stores/theme";
import BaseCard from "../components/common/BaseCard.vue";

const themeStore = useThemeStore();
const setColor = themeStore.setColor;
const colors = [
  "#F3F4F6",
  "#D6D3D1",
  "#CBD5E1",
  "#E5E5E5",
  "#F0EAD2",
  "#E0F2F1",
  "#F3E8FF",
  "#EEDDE0",
  "#E0E7FF",
  "#F9EBC8",
  "#F5F5DC",
];
</script>
