export default function NewsCard({ url, image, title, content, date }) {
  const formatDate = (isoString) => {
    const dateObj = new Date(isoString);
    const yyyy = dateObj.getFullYear();
    const mm = String(dateObj.getMonth() + 1).padStart(2, "0");
    const dd = String(dateObj.getDate()).padStart(2, "0");
    const hh = String(dateObj.getHours()).padStart(2, "0");
    const min = String(dateObj.getMinutes()).padStart(2, "0");
    return `${yyyy}년 ${mm}월 ${dd}일 ${hh}:${min}`;
  };

  return (
    <div
      onClick={() => window.open(url, "_blank")}
      className="cursor-pointer bg-white rounded-2xl shadow p-4 hover:shadow-md transition"
    >
      <img
        src={image}
        alt={title}
        className="w-full h-48 object-cover rounded-xl mb-3"
      />
      <h2 className="text-lg font-semibold text-gray-800 mb-1">{title}</h2>
      <p className="text-xs text-gray-400">{formatDate(date)}</p>
      <p className="text-sm text-gray-600">{content}</p>
    </div>
  );
}
