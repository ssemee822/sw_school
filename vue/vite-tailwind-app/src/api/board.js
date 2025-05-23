import axios from "./axiosInstance";

export const useBoardApi = () => {
  const list = async () => {
    return await axios.get(`/api/board/list`);
  };

  const detail = async (id) => {
    return await axios.get(`/api/board/detail/${id}`);
  };

  const boardNew = async (title, content, categoryId, email, img) => {
    return await axios.post("/api/board/new", {
      title,
      content,
      categoryId,
      email,
      img,
    });
  };

  const boardDelete = async (id) => {
    return await axios.delete(`/api/board/delete/${id}`);
  };

  const boardModify = async (id, title, content, categoryId, email, img) => {
    return await axios.post(`/api/board/modify/${id}`, {
      title,
      content,
      categoryId,
      email,
      img,
    });
  };
  return { list, detail, boardNew, boardDelete, boardModify };
};
