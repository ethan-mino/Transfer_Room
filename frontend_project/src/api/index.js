import axios from "axios";

function apiInstance() {
  const instance = axios.create({
    baseURL: process.env.VUE_APP_API_BASE_URL,
    headers: {
      "Content-Type": "application/json; charset=uft-8",
    },
  });

  return instance;
}

function regionInstance() {
  const instance = axios.create({
    baseURL: process.env.VUE_APP_API_REGION_URL,
    headers: {
      "Content-Type": "application/json; charset=uft-8",
    },
  });

  return instance;
}

export { apiInstance, regionInstance };
