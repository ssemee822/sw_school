import { defineStore } from "pinia";

export const useThemeStore = defineStore("theme", {
  state: () => ({
    color: "gray",
  }),
  actions: {
    setColor(newColor) {
      this.color = newColor;
    },
  },
  persist: true, // ✅ 자동으로 localStorage에 저장됨
});
