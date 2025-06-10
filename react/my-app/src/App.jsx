import { BrowserRouter, Routes, Route } from "react-router-dom";
import MainLayout from "../../news-app/src/layouts/MainLayout";
import NewsListPage from "../../news-app/src/pages/NewsListPage";

export default function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<MainLayout />}>
          <Route index element={<NewsListPage />} />
          <Route path=":category" element={<NewsListPage />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}
