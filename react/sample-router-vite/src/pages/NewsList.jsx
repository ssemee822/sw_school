import NewsCard from "../components/NewsCard";

// Dummy data for UI
const dummyNews = [
  {
    id: 1,
    image: "https://via.placeholder.com/400x200",
    title: "Breaking News Title One",
    content:
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus pretium.",
  },
  {
    id: 2,
    image: "https://via.placeholder.com/400x200",
    title: "Technology Update",
    content:
      "Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia.",
  },
];

export default function NewsListPage() {
  return (
    <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-6">
      {dummyNews.map((news) => (
        <NewsCard
          key={news.id}
          image={news.image}
          title={news.title}
          content={news.content}
        />
      ))}
    </div>
  );
}
