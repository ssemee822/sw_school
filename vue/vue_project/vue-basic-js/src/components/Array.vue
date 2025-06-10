<template>
  <div>
    <input v-model="inputText" @keydown.enter="addUser" />
    <button @click="addUser">추가</button>
    <ul>
      <li v-for="user in users" :key="user.id" @dblclick="removeUser(user.id)">
        {{ user.userName }}
      </li>
    </ul>
  </div>
</template>

<script setup>
import { ref, watch } from "vue";

const stored = localStorage.getItem("users");
const users = ref(
  stored
    ? JSON.parse(stored)
    : [
        { id: 1, userName: "Vue 학습 시작" },
        { id: 2, userName: "Composition API 익히기" },
      ]
);

const inputText = ref("");
const nextId = ref(users.value.length + 1);

const addUser = () => {
  if (!inputText.value.trim()) return;
  users.value.push({ id: nextId.value++, userName: inputText.value });
  inputText.value = "";
};

const removeUser = (id) => {
  users.value = users.value.filter((user) => user.id !== id);
};

watch(
  users,
  (newVal) => {
    localStorage.setItem("users", JSON.stringify(newVal));
  },
  { deep: true }
);
</script>
