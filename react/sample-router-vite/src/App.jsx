import "./App.css";
import NewsListPage from "./pages/NewsList";
import Layout from "./Layout";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";

function App() {
  return (
    <Router>
      <Routes>
        <Route element={<Layout />}>
          <Route path="/" element={<NewsListPage />} />
        </Route>
      </Routes>
    </Router>
  );
}

export default App;
