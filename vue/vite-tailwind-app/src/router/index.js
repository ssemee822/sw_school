import { createRouter, createWebHistory } from "vue-router";
import UserList from "../pages/UserList.vue";
import SignupForm from "../pages/SignupForm.vue";
import LoginForm from "../pages/LoginForm.vue";
import Layout from "../Layout.vue";

const routes = [
  {
    path: "/",
    component: Layout,
    children: [
      { path: "", component: UserList },
      { path: "userlist", component: UserList },
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
