<template>
  <div class="min-h-screen flex justify-center items-start bg-gray-100 p-6">
    <form
      class="w-full max-w-2xl bg-white p-6 rounded shadow space-y-4"
      @submit.prevent="submitPost"
    >
      <h2 class="text-xl font-bold text-gray-800 mb-4">✏️ 게시글 작성</h2>

      <BaseSelect
        v-model="post.categoryId"
        :categories="categories"
      ></BaseSelect>

      <BaseInput
        v-model="post.title"
        placeholder="제목을 입력하세요"
        required
      />

      <BaseInput
        v-model="post.email"
        placeholder="작성자 이름"
        required
        disabled
      />

      <textarea
        v-model="post.content"
        rows="8"
        placeholder="내용을 입력하세요"
        class="w-full border px-4 py-2 rounded text-sm resize-none"
        required
      ></textarea>

      <input type="file" accept="image/*" @change="handleFileChange" />

      <div v-if="previewUrl" class="mt-4">
        <img
          :src="previewUrl"
          alt="미리보기"
          class="max-h-60 rounded mx-auto"
        />
      </div>

      <div class="flex justify-end">
        <BaseButton type="submit">게시글 등록</BaseButton>
      </div>
    </form>
  </div>
</template>

<script setup>
import { onMounted, reactive, ref } from "vue";
import { useRouter } from "vue-router";
import { useAuthStore } from "@/stores/auth";
import { useBoardApi } from "../api/board";
import { useCategoryApi } from "../api/category";
import { storage } from "@/api/firebase";
import BaseButton from "@/components/common/BaseButton.vue";
import BaseSelect from "../components/common/BaseSelect.vue";
import BaseInput from "../components/common/BaseInput.vue";

const { boardNew } = useBoardApi();
const { categoryList } = useCategoryApi();
const AuthStore = useAuthStore();
const userEmail = AuthStore.email;
const router = useRouter();

const file = ref(null);
const previewUrl = ref(null);
const categories = reactive([]);

const post = ref({
  title: "",
  email: userEmail,
  content: "",
  img: null,
  categoryId: "",
});

onMounted(async () => {
  const res = await categoryList();
  console.log(res.data);
  categories.push(...res.data);
});

function handleFileChange(event) {
  file.value = event.target.files[0];
  if (file) {
    previewUrl.value = URL.createObjectURL(file.value);
  } else {
    post.value.img = "";
    previewUrl.value = "";
  }
}

const submitPost = async () => {
  console.log("게시글 제출됨:", post.value);

  if (file.value) {
    const storageRef = storage.ref();
    const fileRef = storageRef.child(`board/${userEmail}/${post.value.title}`);

    await fileRef.put(file.value);
    const url = await fileRef.getDownloadURL();

    post.value.img = url;
  }
  const res = boardNew(
    post.value.title,
    post.value.content,
    post.value.categoryId,
    post.value.email,
    post.value.img
  );
  alert("게시글이 등록되었습니다.");
  router.push("/postlist");
};
</script>
