import axios from "./axiosInstance";

export const useCommentApi = () => {
  const commentList = async (id) => {
    return await axios.get(`/api/comment/list/${id}`);
  };

  const commentNew = async (boardId, content, email) => {
    return await axios.post(`/api/comment/new`, { boardId, content, email });
  };
  return { commentList, commentNew };
};
