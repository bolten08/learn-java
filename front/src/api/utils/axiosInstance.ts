import axios, {AxiosResponse} from 'axios';

// const baseURL = process.env.API_BASE_URL
//     ? process.env.API_BASE_URL
//     : `/`;
const baseURL = '/api';

export const axiosInstance = axios.create({
    baseURL,
    // withCredentials: true, // send cookies when cross-domain requests
    // timeout: 5000 // request timeout
});

export function get(url = '', config?: Record<string, any>): Promise<AxiosResponse> {
    return axiosInstance.get(url, config);
}

export function post(url = '', data?: Record<string, any>, config?: Record<string, any>): Promise<AxiosResponse> {
    return axiosInstance.post(url, data, config);
}

export function del(url = '', config?: Record<string, any>): Promise<AxiosResponse> {
    return axiosInstance.delete(url, config);
}

export function patch(url = '', data?: Record<string, any>, config?: Record<string, any>): Promise<AxiosResponse> {
    return axiosInstance.patch(url, data, config);
}

export function put(url = '', data?: Record<string, any>, config?: Record<string, any>): Promise<AxiosResponse> {
    return axiosInstance.put(url, data, config);
}
