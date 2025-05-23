<template>
  <div class="min-h-screen flex items-center justify-center bg-gray-100 px-4">
    <form
      class="bg-white p-6 rounded-lg shadow-md w-full max-w-md space-y-4"
      @submit.prevent="handleSubmit"
    >
      <h2 class="text-2xl font-bold text-center text-gray-800 mb-4">
        회원가입
      </h2>

      <BaseInput label="이메일" v-model="form.email" required />
      <FormFeedback :message="formInfo.email" />

      <BaseInput label="비밀번호" type="password" v-model="form.pwd" required />
      <FormFeedback :message="formInfo.pwd" />

      <BaseInput
        label="비밀번호 확인"
        type="password"
        v-model="form.confirm"
        required
      />
      <FormFeedback :message="formInfo.confirm" />

      <BaseInput label="이름" v-model="form.name" required />
      <FormFeedback :message="formInfo.name" />

      <BaseButton :disabled="isDisabled">회원가입</BaseButton>
    </form>
  </div>
  <BaseModal v-model="showModal">
    <template v-if="modalType === 'failSignup'">
      <h2 class="text-lg font-bold mb-10">회원가입 실패</h2>
      <div class="flex justify-end gap-3">
        <button
          @click="showModal = false"
          class="hover:text-red-800 font-semibold"
        >
          닫기
        </button>
      </div>
    </template>
    <template v-else-if="modalType === 'failServerSignup'">
      <h2 class="text-lg font-bold mb-5">회원가입 실패</h2>
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
    <template v-else-if="modalType === 'succSignup'">
      <h2 class="text-lg font-bold mb-5">회원가입 성공</h2>
      <p class="mb-10">로그인 후 이용해주세요</p>
      <div class="flex justify-end gap-3">
        <RouterLink to="/login">
          <button class="hover:text-red-800 font-semibold">닫기</button>
        </RouterLink>
      </div>
    </template>
  </BaseModal>
</template>

<script setup>
import { ref, reactive, watch } from "vue";
import { useAuthApi } from "../api/auth";
import BaseInput from "../components/common/BaseInput.vue";
import BaseButton from "../components/common/BaseButton.vue";
import FormFeedback from "../components/common/FormFeedback.vue";
import BaseModal from "@/components/common/BaseModal.vue";

const { signup } = useAuthApi();

const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
const pwdPattern = /^(?=.*[a-zA-Z])(?=.*\d)[A-Za-z\d]{8,}$/;

const showModal = ref(false);
const modalType = ref("");
const isDisabled = ref(true);
const form = reactive({
  email: "",
  pwd: "",
  confirm: "",
  name: "",
});
const formInfo = reactive({
  email: "",
  pwd: "",
  confirm: "",
  name: "",
});
const openModal = (type) => {
  modalType.value = type;
  showModal.value = true;
};

watch(form, () => {
  formInfo.email = emailPattern.test(form.email)
    ? ""
    : "이메일 형식으로 입력해주세요.";
  formInfo.pwd = pwdPattern.test(form.pwd)
    ? ""
    : "영문자+숫자 조합 8자 이상이어야 합니다.";
  formInfo.confirm =
    form.pwd === form.confirm ? "" : "비밀번호가 일치하지 않습니다.";
  formInfo.name = form.name ? "" : "이름을 입력해주세요.";

  isDisabled.value =
    !!formInfo.email || !!formInfo.pwd || !!formInfo.confirm || !!formInfo.name;
});

const handleSubmit = async () => {
  const res = await signup(form.email, form.pwd, form.name);
  if (res.data) {
    console.log("회원 가입 성공");
    openModal("succSignup");
  } else {
    openModal("failSignup");
  }
};
</script>
