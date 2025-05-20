<template>
  <BaseCard class="flex items-center hover:bg-gray-50 transition">
    <Avatar :src="user.image" />

    <div class="ml-4 flex-1">
      <h3 class="text-lg font-semibold text-gray-900">
        {{ user.name || "이름 없음" }}
      </h3>
      <p class="text-sm text-gray-600">
        📧 이메일: {{ user.email || "이메일 없음" }}
      </p>
      <p class="text-sm text-gray-500">
        🗓️ 가입일: {{ formatKoreanDate(user.regDate) }}
      </p>
    </div>
  </BaseCard>
</template>

<script setup>
import BaseCard from "./common/BaseCard.vue";
import Avatar from "./common/Avatar.vue";
import dayjs from "dayjs";

const props = defineProps({
  user: {
    type: Object,
    required: true,
  },
});

function formatKoreanDate(date) {
  return dayjs(date).format("YYYY년 MM월 DD일 HH:mm");
}
</script>
