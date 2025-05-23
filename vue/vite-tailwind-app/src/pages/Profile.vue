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
      <BaseInput label="이름" v-model="user.name" />
    </div>

    <div class="mb-4">
      <BaseInput
        label="비밀번호"
        v-model="user.password"
        type="password"
        disabled
      />
    </div>

    <div class="mb-4">
      <label class="block text-sm font-medium text-gray-700 mb-1"
        >프로필 이미지</label
      >
      <input type="file" accept="image/*" @change="handleFileChange" />
    </div>

    <div v-if="previewUrl" class="mb-4 flex justify-center">
      <Avatar :src="previewUrl" size="w-28 h-28" />
    </div>
    <BaseButton class="mt-6" @click="saveChanges">정보 수정</BaseButton>
  </div>
</template>

<script setup>
import { ref, onMounted, reactive } from "vue";
import { storage } from "@/api/firebase";
import { useMemberApi } from "../api/member";
import { useAuthStore } from "@/stores/auth";
import BaseButton from "@/components/common/BaseButton.vue";
import BaseInput from "@/components/common/BaseInput.vue";
import Avatar from "@/components/common/Avatar.vue";

const { detail, modify } = useMemberApi();
const AuthStore = useAuthStore();
const userEmail = AuthStore.email;

const selectedFile = ref(null);
const previewUrl = ref(null);
const getProfile = ref(null);
const file = ref(null);
const imageUrl = ref("");

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

function handleFileChange(event) {
  file.value = event.target.files[0];

  if (file.value) {
    selectedFile.value = file.value;
    previewUrl.value = URL.createObjectURL(file.value);
  }
}

const saveChanges = async () => {
  try {
    if (file.value) {
      const storageRef = storage.ref();
      const fileRef = storageRef.child(`profile/${userEmail}`);

      await fileRef.put(file.value);
      const url = await fileRef.getDownloadURL();

      imageUrl.value = url;
    } else {
      imageUrl.value = user.image;
    }
    const res = await modify(userEmail, imageUrl._value, user.name);
    window.location.reload();
  } catch (err) {
    console.log("업로드 실패: " + err);
  }
};
</script>

<style scoped>
input[type="file"] {
  display: block;
}
</style>
