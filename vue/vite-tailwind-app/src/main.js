import { createApp } from "vue";
import App from "./App.vue";
import "./assets/tailwind.css";
import router from "./router";
import { createPinia } from "pinia";
import piniaPluginPersistedstate from "pinia-plugin-persistedstate";

const app = createApp(App);

// Pinia 플러그인 연결
const pinia = createPinia();
pinia.use(piniaPluginPersistedstate);

// 전체 앱 설정
app.use(pinia); // ✅ 상태 관리
app.use(router); // ✅ 라우터 등록
app.mount("#app"); // ✅ 마운트
