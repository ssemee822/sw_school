<template>
  <div class="min-h-screen bg-gray-100 p-4 flex justify-center items-start">
    <div class="w-full max-w-2xl space-y-4">
      <h2 class="text-2xl font-bold text-gray-800 text-center mb-4">
        📝 게시글 목록
      </h2>
      <div class="flex justify-end">
        <RouterLink to="/postcreate">
          <BaseButton optionClass="w-40">게시글 작성</BaseButton>
        </RouterLink>
      </div>
      <div class="space-y-4 h-[90vh] overflow-y-auto">
        <PostCard v-for="post in postList" :key="post.boardId" :post="post" />
      </div>
    </div>
  </div>
</template>

<script setup>
import { reactive } from "vue";
import { useBoardApi } from "../api/board";
import PostCard from "../components/PostCard.vue";
import BaseButton from "@/components/common/BaseButton.vue";

const { list } = useBoardApi();

const postList = reactive([]);

const getUserList = async () => {
  try {
    const res = await list();
    console.log(res.data);

    if (res.data) {
      postList.push(...res.data);
    }
  } catch (err) {
    console.error("데이터 불러오기 실패", err);
  }
};

getUserList();
</script>
