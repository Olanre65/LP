import http from "../http-common";

const getAll = (params) => {
  return http.get("/products", { params });
};

const get = id => {
  return http.get(`/products/${id}`);
};

const create = data => {
  return http.post("/products", data);
};

const update = (id, data) => {
  return http.put(`/products/${id}`, data);
};

const remove = id => {
  return http.delete(`/products/${id}`);
};


export default {
  getAll,
  get,
  create,
  update,
  remove,
  };