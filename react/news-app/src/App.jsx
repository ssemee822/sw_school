import { BrowserRouter, Routes, Route } from "react-router-dom";
import MainLayout from "./layouts/MainLayout";
import NewsListPage from "../../news-app/src/pages/NewsListPage";
import UserStore from "./store/UserStore";

export default function App() {
  return (
    <UserStore>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<MainLayout />}>
            <Route index element={<NewsListPage />} />
            <Route path=":category" element={<NewsListPage />} />
          </Route>
        </Routes>
      </BrowserRouter>
    </UserStore>
  );
}
