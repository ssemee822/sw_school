import { Link } from "react-router-dom";

export default function Header({ categories }) {
  return (
    <header className="fixed top-0 left-0 right-0 bg-white border-b shadow z-50">
      <div className="max-w-7xl mx-auto px-4 py-4 flex items-center justify-between">
        <h1 className="text-2xl font-bold text-blue-600">NewsToday</h1>
        <nav className="space-x-4">
          {categories.map((category) => (
            <Link
              key={category.name}
              to={`/${category.name}`}
              className="text-gray-700 hover:text-blue-500 transition"
            >
              {category.text}
            </Link>
          ))}
        </nav>
      </div>
    </header>
  );
}
