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
</template>

<script setup>
import { ref, reactive, watch } from "vue";
import axios from "axios";
import BaseInput from "../components/common/BaseInput.vue";
import BaseButton from "../components/common/BaseButton.vue";
import FormFeedback from "../components/common/FormFeedback.vue";
import { useRouter } from "vue-router";

const router = useRouter();

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

const isDisabled = ref(true);
const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
const pwdPattern = /^(?=.*[a-zA-Z])(?=.*\d)[A-Za-z\d]{8,}$/;

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
  try {
    const payload = {
      email: form.email,
      pwd: form.pwd,
      name: form.name,
    };
    const res = await axios.post(
      "http://222.117.237.119:8111/auth/signup",
      payload
    );

    if (res.data) {
      console.log("회원 가입 성공");
      router.push("/login");
    } else {
      alert("회원 가입 실패");
    }
  } catch (err) {
    console.error(err);
    alert("가입 실패! 서버 오류 발생");
  }
};
</script>
