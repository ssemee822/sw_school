import axios from "./axiosInstance";

export const useMemberApi = () => {
  const detail = async (email) => {
    return await axios.get(`/users/detail/${email}`);
  };

  const modify = async (email, image, name) => {
    return await axios.put(`/users/modify`, { email, image, name });
  };

  const list = async () => {
    return await axios.get(`/users/list`);
  };

  return { detail, modify, list };
};
