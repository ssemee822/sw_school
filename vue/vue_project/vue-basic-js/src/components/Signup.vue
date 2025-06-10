<template>
  <h2>Signup</h2>
  <form action="">
    <label>
      아이디:
      <input v-model="form.email" required />
      <span class="feedback">{{ formInfo.email }}</span>
    </label>
    <label>
      비밀번호:
      <input type="password" v-model="form.pwd" required />
      <span class="feedback">{{ formInfo.pwd }}</span>
    </label>
    <label>
      비밀번호 확인:
      <input type="password" v-model="form.confirm" required />
      <span class="feedback">{{ formInfo.confirm }}</span>
    </label>
    <label>
      이름:
      <input v-model="form.name" required />
      <span class="feedback">{{ formInfo.name }}</span>
    </label>
    <button type="button" @click="handleSubmit" :disabled="isDisabled">
      회원가입
    </button>
  </form>
</template>

<script setup>
import { ref, reactive, watch } from "vue";
import axios from "axios";

const form = reactive({
  email: "",
  pwd: "",
  confirm: "",
  name: "",
});

const formInfo = reactive({
  email: "이메일 형식으로 입력해주세요.",
  pwd: "영문자+숫자 조합 8자 이상이어야 합니다.",
  confirm: "비밀번호가 일치하지 않습니다.",
  name: "이름을 입력해주세요.",
});

const isDisabled = ref(true);
const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
const pwdPattern = /^(?=.*[a-zA-Z])(?=.*\d)[A-Za-z\d]{8,}$/;

watch(form, (newVar, oldVar) => {
  formInfo.email = emailPattern.test(newVar.email)
    ? ""
    : "이메일 형식으로 입력해주세요.";
  formInfo.pwd = pwdPattern.test(newVar.pwd)
    ? ""
    : "영문자+숫자 조합 8자 이상이어야 합니다.";
  formInfo.confirm =
    newVar.pwd == newVar.confirm ? "" : "비밀번호가 일치하지 않습니다.";
  formInfo.name = newVar.name ? "" : "이름을 입력해주세요.";

  if (!formInfo.email && !formInfo.pwd && !formInfo.confirm && !formInfo.name) {
    isDisabled.value = false;
  }
});

const handleSubmit = async () => {
  try {
    const payload = {
      email: form.username,
      pwd: form.password,
      name: form.name,
    };
    const res = await axios.post(
      "http://222.117.237.119:8111/auth/signup",
      payload
    );

    if (res.data) {
      alert("회원 가입 성공");
    } else {
      alert("회원 가입 실패");
    }
  } catch (err) {
    console.error(err);
    alert("가입 실패! 서버 오류 발생");
  }
};
</script>

<style scoped>
body {
  font-family: Arial, sans-serif;
  padding: 20px;
  display: flex;
  flex-direction: column;
  align-items: center;
}

form {
  margin-bottom: 40px;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 8px;
  max-width: 400px;
}

label {
  display: block;
  margin-bottom: 10px;
}

input {
  width: 100%;
  padding: 8px;
  margin-top: 4px;
  box-sizing: border-box;
}

span.feedback {
  display: block;
  font-size: 12px;
  margin-top: 4px;
  color: red;
}

button {
  margin-top: 15px;
  padding: 10px;
  width: 100%;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

button:hover {
  background-color: #0056b3;
}

hr {
  margin: 40px 0;
}

#signup {
  width: 200px;
}

#signup > a {
  color: white;
  text-decoration: none;
}

button:disabled {
  background-color: #ccc;
  cursor: not-allowed;
}
</style>
