<template>
  <div class="min-h-screen flex flex-col">
    <!-- 헤더 -->
    <header
      class="bg-white shadow-md px-6 py-4 flex items-center justify-between"
    >
      <RouterLink to="/">
        <h1 class="text-xl font-bold text-gray-800">MyApp</h1>
      </RouterLink>
      <nav class="flex items-center space-x-4">
        <RouterLink to="/postlist" class="text-gray-700 hover:text-blue-600">
          게시글
        </RouterLink>
        <RouterLink to="/userlist" class="text-gray-700 hover:text-blue-600">
          사용자 목록
        </RouterLink>
        <RouterLink to="/setcolor" class="text-gray-700 hover:text-blue-600">
          테마 선택
        </RouterLink>
        <RouterLink to="/profile" class="text-gray-700 hover:text-blue-600">
          프로필
        </RouterLink>
        <button
          @click="openModal('logout')"
          class="text-red-600 hover:text-red-700 font-medium"
        >
          로그아웃
        </button>
      </nav>
    </header>

    <BaseModal v-model="showModal">
      <template v-if="modalType === 'logout'">
        <h2 class="text-lg font-bold mb-10">로그아웃 하시겠습니까?</h2>
        <div class="flex justify-end gap-3">
          <button
            @click="handleLogout"
            class="text-red-600 hover:text-red-800 font-semibold"
          >
            네
          </button>
        </div>
      </template>
    </BaseModal>

    <!-- 메인 콘텐츠 -->
    <main
      :style="{ backgroundColor: themeStore.color }"
      class="flex-1 px-4 py-6 bg-gray-50"
    >
      <router-view />
    </main>

    <!-- 푸터 -->
    <footer class="bg-gray-200 text-center py-4 text-sm text-gray-600">
      © 2025 MyApp. All rights reserved.
    </footer>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";
import { useAuthStore } from "./stores/auth";
import { useThemeStore } from "@/stores/theme";
import BaseModal from "@/components/common/BaseModal.vue";

const showModal = ref(false);
const modalType = ref("");
const openModal = (type) => {
  modalType.value = type;
  showModal.value = true;
};
const router = useRouter();
const themeStore = useThemeStore();
const AuthStore = useAuthStore();
const isLogin = AuthStore.isLogin;

if (isLogin != "true") {
  router.push("/login");
}

const handleLogout = () => {
  useAuthStore().setLogin("false");
  router.push("/login");
};
</script>
