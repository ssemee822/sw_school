<template>
  <div class="min-h-screen bg-gray-100 p-4 flex justify-center items-start">
    <div class="w-full max-w-2xl space-y-4">
      <h2 class="text-2xl font-bold text-gray-800 text-center mb-4">
        👥 사용자 목록
      </h2>
      <div class="space-y-4 h-[90vh] overflow-y-auto">
        <UserCard v-for="user in userList" :key="user.id" :user="user" />
      </div>
    </div>
  </div>
</template>

<script setup>
import { reactive } from "vue";
import { useMemberApi } from "../api/member";
import UserCard from "../components/UserCard.vue";

const { list } = useMemberApi();

const userList = reactive([]);

const getUserList = async () => {
  try {
    const res = await list();

    if (res.data) {
      userList.push(...res.data);
    }
  } catch (err) {
    console.error("데이터 불러오기 실패", err);
  }
};

getUserList();
</script>
