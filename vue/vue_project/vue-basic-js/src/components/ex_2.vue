<template>
  <div class="userList" v-for="user in userList">
    <div class="user">
      <h3>{{ user.name }}</h3>
      <p>나이: {{ user.age }}세</p>
      <p>주소: {{ user.address }}</p>
      <p>{{ user.isAdult ? "성인입니다." : "성인이 아닙니다." }}</p>
    </div>
  </div>
</template>

<script setup>
const props = defineProps({
  userList: Object,
});
</script>

<style scoped>
.user {
  border: 1px solid black;
  margin-bottom: 10px;
  width: 40rem;
}
</style>
