// postcss.config.cjs
module.exports = {
  plugins: {
    "@tailwindcss/postcss": {}, // ✅ Tailwind v4 전용
    autoprefixer: {},
  },
};
