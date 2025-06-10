<template>
  <div>
    <h3>child component</h3>
    <button @click="send">send to p</button>
  </div>
</template>

<script setup>
const emit = defineEmits(["send-message"]);

const send = () => {
  emit("send-message", "hello");
};
</script>

<!-- const message = ref("");
const handleMessage = (payload) => {
  message.value = payload;
}; -->
