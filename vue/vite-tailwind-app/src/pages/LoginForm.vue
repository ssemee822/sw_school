<!-- src/pages/LoginForm.vue -->
<template>
  <div class="min-h-screen flex items-center justify-center bg-gray-100 px-4">
    <form
      class="bg-white p-6 rounded-lg shadow-md w-full max-w-md space-y-4"
      @submit.prevent="handleLogin"
    >
      <h2 class="text-2xl font-bold text-center text-gray-800 mb-4">로그인</h2>

      <BaseInput label="이메일" v-model="form.email" type="email" required />
      <FormFeedback :message="formInfo.email" />

      <BaseInput label="비밀번호" v-model="form.pwd" type="password" required />
      <FormFeedback :message="formInfo.pwd" />

      <BaseButton :disabled="isDisabled">로그인</BaseButton>

      <!-- 회원가입 버튼 추가 -->
      <div class="text-center mt-4">
        <p class="text-sm text-gray-600">아직 계정이 없으신가요?</p>
        <RouterLink
          to="/signup"
          class="inline-block mt-2 text-blue-600 hover:text-blue-800 font-medium"
        >
          회원가입 하기
        </RouterLink>
      </div>
    </form>
  </div>
  <BaseModal v-model="showModal">
    <template v-if="modalType === 'failLogin'">
      <h2 class="text-lg font-bold mb-5">로그인 실패</h2>
      <p class="mb-10">잘못된 이메일 또는 비밀번호</p>
      <div class="flex justify-end gap-3">
        <button
          @click="showModal = false"
          class="hover:text-red-800 font-semibold"
        >
          닫기
        </button>
      </div>
    </template>
    <template v-else-if="modalType === 'failServerLogin'">
      <h2 class="text-lg font-bold mb-5">로그인 실패</h2>
      <p class="mb-10">서버 오류</p>
      <div class="flex justify-end gap-3">
        <button
          @click="showModal = false"
          class="hover:text-red-800 font-semibold"
        >
          닫기
        </button>
      </div>
    </template>
  </BaseModal>
</template>

<script setup>
import { reactive, ref, watch } from "vue";
import { useRouter } from "vue-router";
import axios from "axios";
import { useAuthStore } from "@/stores/auth";
import BaseInput from "../components/common/BaseInput.vue";
import BaseButton from "../components/common/BaseButton.vue";
import BaseModal from "@/components/common/BaseModal.vue";
import FormFeedback from "../components/common/FormFeedback.vue";

const showModal = ref(false);
const modalType = ref("");
const router = useRouter();
const isDisabled = ref(true);
const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
const AuthStore = useAuthStore();
const isLogin = AuthStore.isLogin;
const form = reactive({
  email: "",
  pwd: "",
});
const formInfo = reactive({
  email: "",
  pwd: "",
});
const openModal = (type) => {
  modalType.value = type;
  showModal.value = true;
};

if (isLogin == "true") {
  useAuthStore().setLogin("false");
  useAuthStore().setEmail("");
}
watch(form, () => {
  formInfo.email = emailPattern.test(form.email)
    ? ""
    : "이메일 형식으로 입력해주세요.";
  formInfo.pwd =
    form.pwd.length >= 4 ? "" : "비밀번호는 4자 이상이어야 합니다.";
  isDisabled.value = !!formInfo.email || !!formInfo.pwd;
});

const handleLogin = async () => {
  try {
    const payload = {
      email: form.email,
      pwd: form.pwd,
    };

    const res = await axios.post(
      "http://222.117.237.119:8111/auth/login",
      payload
    );

    if (res.data) {
      useAuthStore().setLogin("true");
      useAuthStore().setEmail(form.email);
      router.push("/");
    } else {
      openModal("failLogin");
    }
  } catch (err) {
    console.error(err);
    openModal("failServerLogin");
  }
};
</script>
