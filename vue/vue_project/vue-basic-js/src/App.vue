<script setup>
import { ref } from "vue";
import DataBinding from "./components/DataBinding.vue";
import ConditionRender from "./components/ConditionRender.vue";
import iterArr from "./components/iterArr.vue";
import ClassBinding from "./components/ClassBinding.vue";
import Reacitve from "./components/Reactive.vue";
import Computed from "./components/Computed.vue";
import Watch from "./components/Watch.vue";
import ex_1 from "./components/ex_1.vue";
import Card from "./components/Cardview.vue";
import ex_2 from "./components/ex_2.vue";
import Usercard from "./components/UserCard.vue";
</script>

<template>
  <!-- <h3>Vue > APP.vue</h3> -->
  <!-- <DataBinding></DataBinding> -->
  <!-- <ConditionRender></ConditionRender> -->
  <!-- <iterArr></iterArr> -->
  <!-- <ClassBinding></ClassBinding> -->
  <!-- <Reacitve></Reacitve> -->
  <!-- <Computed></Computed> -->
  <!-- <Watch></Watch> -->
  <!-- <ex_1> </ex_1> -->
  <!-- <input v-model="inputName" placeholder="input name" />
  <br />
  <input v-model="inputJob" placeholder="input job" />
  <br />
  <input v-model.number="inputAge" placeholder="input age" />
  <Card :name="inputName" :job="inputJob" :age="inputAge"></Card> -->
  <!-- <ex_2 :userList="usersObject"></ex_2> -->
  <Usercard></Usercard>
</template>

<style scoped>
h1 {
  font-size: 24px;
  color: royalblue;
}
input {
  padding: 8px;
  font-size: 18px;
  margin-top: 10px;
}
</style>
