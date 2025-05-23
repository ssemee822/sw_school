<template>
  <BaseCard class="flex items-center hover:bg-gray-50 transition">
    <RouterLink
      :to="{ name: 'PostDetail', params: { postId: post.boardId } }"
      class="flex items-center hover:bg-gray-50 transition"
    >
      <Avatar :src="post.img" size="w-20 h-20" />
      <div class="ml-4 flex-1">
        <h3 class="text-lg font-semibold text-gray-900">
          {{ post.title || " " }}
        </h3>
        <p class="text-xs text-gray-500">
          작성일: {{ formatKoreanDate(post.regDate) }}
        </p>
        <p class="text-xs text-gray-500">작성자: {{ post.email }}</p>
        <p class="text-sm text-gray-500">
          {{
            post.content.length > 30
              ? post.content.slice(0, 30) + "..."
              : post.content
          }}
        </p>
      </div>
    </RouterLink>
  </BaseCard>
</template>

<script setup>
import BaseCard from "./common/BaseCard.vue";
import Avatar from "./common/Avatar.vue";
import dayjs from "dayjs";
import { useAuthStore } from "@/stores/auth";

const AuthStore = useAuthStore();
const postEmail = AuthStore.email;

const props = defineProps({
  post: {
    type: Object,
    required: true,
  },
});

function formatKoreanDate(date) {
  return dayjs(date).format("YYYY년 MM월 DD일 HH:mm");
}
</script>
