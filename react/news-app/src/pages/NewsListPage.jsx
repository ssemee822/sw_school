import NewsCard from "../components/NewsCard";
import { useEffect, useState } from "react";
import axios from "axios";
import { useParams } from "react-router-dom";

export default function NewsListPage() {
  const [articles, setArticles] = useState([]);
  const { category } = useParams();

  useEffect(() => {
    if (category == "all") {
      axios
        .get("https://newsapi.org/v2/top-headlines", {
          params: {
            country: "us",
            apiKey: "6fcc97844c8f45e48e556ac46095e753",
          },
        })
        .then((response) => {
          setArticles(response.data.articles);
        })
        .catch((error) => {
          console.error("Error fetching news:", error);
        });
    } else {
      axios
        .get("https://newsapi.org/v2/top-headlines", {
          params: {
            category: category,
            country: "us",
            apiKey: "6fcc97844c8f45e48e556ac46095e753",
          },
        })
        .then((response) => {
          setArticles(response.data.articles);
        })
        .catch((error) => {
          console.error("Error fetching news:", error);
        });
    }
  }, [category]);

  return (
    <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-6">
      {articles.map((news) => (
        <NewsCard
          key={news.url}
          url={news.url}
          image={news.urlToImage}
          title={news.title}
          content={news.content}
          date={news.publishedAt}
        />
      ))}
    </div>
  );
}
