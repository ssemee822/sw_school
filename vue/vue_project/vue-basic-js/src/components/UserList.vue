<template>
  <div class="user-list">
    <div class="user-card" v-for="user in userList">
      <div class="user-cont">
        <img
          :src="validProfileUrl(user.image)"
          @error="setDefaultImage"
          alt="프로필 이미지"
        />
        <div class="user-txt">
          <h4>{{ user.name ? user.name : "이름 없음" }}</h4>
          <p>email : {{ user.email ? user.email : "이메일 없음" }}</p>
          <p>가입일 : {{ formatKoreanDate(user.regDate) }}</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, reactive, watch, computed } from "vue";
import axios from "axios";
import dayjs from "dayjs";

const userList = reactive([]);

function validProfileUrl(ele) {
  if (ele) return ele;
  else return "../../public/default_profile.png";
}

function setDefaultImage(event) {
  event.target.src = "../../public/default_profile.png";
}

function formatKoreanDate(dateString) {
  return dayjs(dateString).format("YYYY년 MM월 DD일 HH:mm");
}

const getUserList = async () => {
  try {
    const res = await axios.get("http://222.117.237.119:8111/users/list");

    if (res.data) {
      userList.push(...res.data);
      console.log(res.data);
    } else {
      console.log("nooooo");
    }
  } catch (err) {
    console.error(err);
  }
};
getUserList();
</script>

<style scoped>
.user-list {
  background-color: rgb(249, 244, 238);
  padding: 10px;
  height: 90vh;
  width: 80vw;
  max-width: 700px;
  min-width: 350px;
  overflow-x: scroll;
  overflow-y: scroll;
  margin: 0;
}
.user-card {
  background-color: white;
  height: 130px;
  margin: 10px;
  display: flex;
  flex-direction: column;
  justify-content: center;
}
.user-cont {
  display: flex;
  justify-content: center;
}
h4 {
  margin: 5px;
}
p {
  margin: 0;
}
.user-cont img {
  max-width: 80px;
  max-height: 80px;
  margin-left: 20px;
  left: 0;
  flex: 1;
}
.user-txt {
  flex: 2;
}
</style>
