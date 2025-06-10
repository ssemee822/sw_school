import { Outlet, Link } from "react-router-dom";

const Layout = () => {
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
    <>
      <header className="fixed top-0 left-0 right-0 bg-white shadow z-50">
        <div className="max-w-7xl mx-auto px-4 py-3 flex justify-between items-center">
          <h1 className="text-2xl font-bold text-gray-800">News Portal</h1>
          <nav className="space-x-4">
            {categories.map((category) => (
              <Link
                key={category}
                to={`/${category}`}
                className="text-gray-600 hover:text-blue-600 transition"
              >
                {category.text}
              </Link>
            ))}
          </nav>
        </div>
      </header>
      <main>
        <Outlet />
      </main>
      <footer className="fixed bottom-0 left-0 right-0 bg-gray-100 text-center py-3 text-sm text-gray-500 shadow-inner">
        © 2025 News Portal. All rights reserved.
      </footer>
    </>
  );
};

export default Layout;
