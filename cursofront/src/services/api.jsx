import axios from 'axios';
import headerAuthorization from './authHeaders';

export class Api {
  constructor(url) {
    this.baseApi = axios.create({
      baseURL: `http://localhost:8080${url}`,
    });
    const headers = headerAuthorization();
    this.baseApi.defaults.headers.common['Authorization'] = headers.Authorization;
  }

  async listar(id = undefined) {
    try {
      if (id === undefined) {
        return await this.baseApi.get();
      } else {
        return await this.baseApi.get(`/${id}`);
      }
    } catch (error) {
      return Promise.reject(error);
    }
  }

  async salvar(dados) {
    try {
      if (dados.id === undefined) {
        return await this.baseApi.post('/', { ...dados });
      } else {
        return await this.baseApi.put(`/${dados.id}`, { ...dados });
      }
    } catch (error) {
      return Promise.reject(error);
    }
  }

  async remover(id) {
    try {
      return await this.baseApi.delete(`/${id}`);
    } catch (error) {
      return Promise.reject(error);
    }
  }
}