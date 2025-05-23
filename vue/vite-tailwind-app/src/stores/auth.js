import { defineStore } from "pinia";

export const useAuthStore = defineStore("auth", {
  state: () => ({
    isLogin: "false",
    email: "",
  }),
  actions: {
    setLogin(newLogin) {
      this.isLogin = newLogin;
    },
    setEmail(newEmail) {
      this.email = newEmail;
    },
  },
  persist: true, // ✅ 자동으로 localStorage에 저장됨
});
