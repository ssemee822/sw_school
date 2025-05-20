<template>
  <div class="min-h-screen flex flex-col">
    <!-- 헤더 -->
    <header
      class="bg-white shadow-md px-6 py-4 flex items-center justify-between"
    >
      <h1 class="text-xl font-bold text-gray-800">MyApp</h1>
      <nav class="flex items-center space-x-4">
        <RouterLink to="/userlist" class="text-gray-700 hover:text-blue-600">
          사용자 목록
        </RouterLink>
        <button
          @click="handleLogout"
          class="text-red-600 hover:text-red-700 font-medium"
        >
          로그아웃
        </button>
      </nav>
    </header>

    <!-- 메인 콘텐츠 -->
    <main class="flex-1 px-4 py-6 bg-gray-50">
      <router-view />
    </main>

    <!-- 푸터 -->
    <footer class="bg-gray-200 text-center py-4 text-sm text-gray-600">
      © 2025 MyApp. All rights reserved.
    </footer>
  </div>
</template>

<script setup>
import { useRouter } from "vue-router";

const router = useRouter();
const isLogin = localStorage.getItem("isLoggedIn");

if (isLogin != "true") router.push("/");

const handleLogout = () => {
  localStorage.removeItem("isLoggedIn");
  alert("로그아웃 되었습니다.");
  router.push("/login");
};
</script>
