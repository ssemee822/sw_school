<template>
  <div class="max-w-md mx-auto bg-white p-6 rounded shadow mt-10">
    <h2 class="text-xl font-semibold mb-4">마이페이지</h2>
    <div class="mb-4 flex justify-center">
      <Avatar :src="user.image" size="w-36 h-36" />
    </div>

    <div class="mb-4">
      <BaseInput label="이메일" :modelValue="user.email" disabled />
    </div>

    <div class="mb-4">
      <BaseInput label="이름" v-model="user.name" disabled />
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted, reactive } from "vue";
import { useMemberApi } from "../api/member";
import BaseInput from "@/components/common/BaseInput.vue";
import Avatar from "@/components/common/Avatar.vue";
import { useRoute } from "vue-router";

const route = useRoute();
const { detail } = useMemberApi();
const userEmail = route.params.userId;

const getProfile = ref(null);

const user = reactive({
  email: "",
  name: "",
  password: "",
  image: "",
});

onMounted(async () => {
  const res = await detail(userEmail);
  const { data } = res;
  getProfile.value = data;
  user.email = data.email;
  user.name = data.name;
  user.password = data.pwd;
  user.image = data.image;
});
</script>

<style scoped>
input[type="file"] {
  display: block;
}
</style>
