import { Outlet } from "react-router-dom";
import Header from "../components/common/Header";
import Footer from "../components/common/Footer";

export default function MainLayout() {
  const categories = [
    {
      name: "all",
      text: "전체보기",
    },
    {
      name: "business",
      text: "비즈니스",
    },
    {
      name: "entertainment",
      text: "엔터테인먼트",
    },
    {
      name: "health",
      text: "건강",
    },
    {
      name: "sport",
      text: "스포츠",
    },
    {
      name: "technology",
      text: "기술",
    },
  ];
  return (
    <div className="pt-20 pb-16 min-h-screen bg-gray-50">
      <Header categories={categories} />
      <main className="max-w-7xl mx-auto px-4 py-6">
        <Outlet />
      </main>
      <Footer />
    </div>
  );
}
