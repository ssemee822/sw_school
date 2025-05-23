<template>
  <div class="max-w-3xl mx-auto mt-10 p-6 bg-white shadow-md rounded-md">
    <h1 class="text-2xl font-bold text-gray-800 mb-4">{{ post.title }}</h1>

    <div class="flex items-center justify-between text-sm text-gray-500 mb-6">
      <span>
        <RouterLink
          :to="{
            name: 'UserDetail',
            params: { userId: post.author || 'none' },
          }"
        >
          작성자: {{ post.author }}
        </RouterLink>
      </span>
      <span>{{ post.createdAt }}</span>
    </div>

    <!-- 수정, 삭제 버튼 -->
    <div v-if="isMy" class="mb-8 flex justify-end gap-4">
      <!-- <BaseButton optionClass="w-40" @click="editPost">수정</BaseButton> -->
      <BaseButton
        optionClass="w-40"
        class="bg-red-500 hover:bg-red-600"
        @click="deletePost"
      >
        삭제
      </BaseButton>
    </div>

    <div class="mb-6">
      <img
        v-if="post.imageUrl"
        :src="post.imageUrl"
        alt="post image"
        class="w-full max-h-96 object-cover rounded"
      />
    </div>

    <div class="mb-10 text-gray-700 leading-relaxed whitespace-pre-line">
      {{ post.content }}
    </div>

    <!-- 댓글 목록 -->
    <div class="border-t pt-6">
      <h2 class="text-lg font-semibold mb-4">댓글</h2>

      <div v-if="comments.length === 0" class="text-gray-500 mb-4">
        아직 댓글이 없습니다.
      </div>

      <ul class="space-y-4 mb-6">
        <li
          v-for="(comment, index) in comments"
          :key="index"
          class="bg-gray-100 p-3 rounded"
        >
          <p class="text-sm text-gray-800">
            <RouterLink
              :to="{
                name: 'UserDetail',
                params: { userId: comment.author || 'none' },
              }"
            >
              작성자 : {{ comment.author }}
            </RouterLink>
          </p>
          <p class="text-gray-700">{{ comment.content }}</p>
        </li>
      </ul>

      <!-- 댓글 입력 -->
      <div class="flex flex-col gap-2">
        <textarea
          v-model="newComment.content"
          placeholder="댓글을 입력하세요"
          rows="3"
          class="border rounded px-3 py-2 text-sm resize-none"
        ></textarea>
        <button
          @click="submitComment"
          class="self-end bg-blue-500 hover:bg-blue-600 text-white text-sm px-4 py-2 rounded"
        >
          댓글 작성
        </button>
      </div>
    </div>
  </div>
</template>

<script setup>
import dayjs from "dayjs";
import { ref, onMounted, reactive } from "vue";
import { useRoute, useRouter } from "vue-router";
import { useAuthStore } from "@/stores/auth";
import { useBoardApi } from "../api/board";
import { useCommentApi } from "../api/comment";
import BaseButton from "@/components/common/BaseButton.vue";

const AuthStore = useAuthStore();
const userEmail = AuthStore.email;
const { detail, boardDelete } = useBoardApi();
const { commentList, commentNew } = useCommentApi();
const route = useRoute();
const router = useRouter();
const postId = route.params.postId;

const comments = reactive([]);
const isMy = ref(false);

const post = ref({
  title: "",
  author: "",
  createdAt: "",
  content: "",
  imageUrl: "",
});

const newComment = ref({
  author: userEmail,
  content: "",
});

onMounted(async () => {
  const postRes = await detail(postId);
  const postData = postRes.data;
  post.value = {
    title: postData.title,
    author: postData.email,
    createdAt: formatKoreanDate(postData.regDate),
    content: postData.content,
    imageUrl: postData.img,
  };
  isMy.value = userEmail == postData.email ? true : false;
  const commentRes = await commentList(postId);
  const commentData = commentRes.data;
  commentData.map((comment) => {
    comments.push({ author: comment.email, content: comment.content });
  });
});

const deletePost = async () => {
  console.log("del");
  const res = await boardDelete(postId);
  console.log(res);
  if (res.data) {
    alert("삭제 완료");
    router.push("/postlist");
  } else {
    alert("삭제 불가능");
  }
};

const editPost = () => {
  console.log("edit");
  router.push("/postedit/" + postId);
};

function submitComment() {
  if (!newComment.value.content) {
    alert("내용을 입력해주세요.");
    return;
  }
  comments.push({ ...newComment.value });
  const res = commentNew(
    postId,
    newComment.value.content,
    newComment.value.author
  );
  newComment.value.content = "";
}

function formatKoreanDate(date) {
  return dayjs(date).format("YYYY년 MM월 DD일 HH:mm");
}
</script>
