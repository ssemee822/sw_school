import axios from "./axiosInstance";

export const useCategoryApi = () => {
  const categoryList = async () => {
    return await axios.get(`/api/category/list`);
  };

  return { categoryList };
};
