<template>
  <div class="container">
    <h2>User Info</h2>
    <UserItem v-for="user in users" :key="user.name" :user="user"></UserItem>
  </div>
</template>

<script setup>
import { reactive, onMounted } from "vue";
import UserItem from "../components/UserItem.vue";

const users = reactive([]);
const fetchedData = [
  { name: "홍길동", age: 28, address: "서울특별시 강남구", isAdult: true },
  { name: "김민수", age: 17, address: "부산광역시 해운대구", isAdult: false },
  { name: "이영희", age: 35, address: "대전광역시 유성구", isAdult: true },
  { name: "박철수", age: 45, address: "경기도 성남시 분당구", isAdult: true },
  { name: "최지우", age: 15, address: "인천광역시 남동구", isAdult: false },
  { name: "정우성", age: 22, address: "강원도 춘천시", isAdult: true },
  { name: "한가인", age: 19, address: "제주특별자치도 제주시", isAdult: false },
  { name: "서준호", age: 31, address: "경상남도 창원시", isAdult: true },
  { name: "배수지", age: 27, address: "전라북도 전주시", isAdult: true },
  { name: "문재현", age: 16, address: "충청북도 청주시", isAdult: false },
];

onMounted(() => {
  users.push(...fetchedData);
});
</script>

<style scoped>
.container {
  width: 500px;
  margin: 40px auto;
  text-align: center;
  background-color: antiquewhite;
}
</style>
