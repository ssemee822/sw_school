export default function NewsCard({ image, title, content }) {
  const shortContent =
    content.length > 30 ? content.slice(0, 30) + "..." : content;
  return (
    <div className="bg-white rounded-2xl shadow p-4 hover:shadow-md transition">
      <img
        src={image}
        alt={title}
        className="w-full h-48 object-cover rounded-xl mb-3"
      />
      <h2 className="text-lg font-semibold text-gray-800 mb-1">{title}</h2>
      <p className="text-sm text-gray-600">{shortContent}</p>
    </div>
  );
}
