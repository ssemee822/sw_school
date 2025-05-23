import { createRouter, createWebHistory } from "vue-router";
import UserList from "../pages/UserList.vue";
import SignupForm from "../pages/SignupForm.vue";
import LoginForm from "../pages/LoginForm.vue";
import SetColor from "../pages/SetColor.vue";
import Profile from "../pages/Profile.vue";
import PostList from "../pages/PostList.vue";
import PostDetail from "../pages/PostDetail.vue";
import PostCreate from "../pages/PostCreate.vue";
import UserDetail from "../pages/UserDetail.vue";
import Layout from "../Layout.vue";

const routes = [
  {
    path: "/",
    component: Layout,
    children: [
      { path: "", component: PostList },
      { path: "userlist", component: UserList },
      { path: "setcolor", component: SetColor },
      { path: "profile", component: Profile },
      { path: "postlist", component: PostList },
      { path: "postcreate", component: PostCreate },
      {
        path: "/postdetail/:postId",
        name: "PostDetail",
        component: PostDetail,
      },
      {
        path: "/userdetail/:userId",
        name: "UserDetail",
        component: UserDetail,
      },
    ],
  },
  { path: "/signup", component: SignupForm },
  { path: "/login", component: LoginForm },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
