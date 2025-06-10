<template>
  <div class="news-list">
    <div class="new-card" v-for="news in newsData">
      <div class="news-cont">
        <img src="../../public/news.jpeg" alt="" />
        <div class="news-txt">
          <h4>{{ news.title }}</h4>
          <p>{{ news.date }}</p>
          <p>{{ news.content }}</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
const props = defineProps({
  newsData: Object,
});

console.log(props[0]);
</script>

<style scoped>
.news-list {
  background-color: rgb(249, 244, 238);
  padding: 10px;
  height: 70vh;
  overflow-y: scroll;
}
.new-card {
  background-color: white;
  height: 130px;
  margin: 10px;
  display: flex;
  flex-direction: column;
  justify-content: center;
}
.news-cont {
  display: flex;
  justify-content: center;
}
h4 {
  margin: 5px;
}
p {
  margin: 0;
}
.news-cont img {
  width: 110px;
  margin-left: 20px;
  left: 0;
  flex: 1;
}
.news-txt {
  flex: 2;
}
</style>
