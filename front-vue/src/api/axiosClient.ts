import axios from 'axios';

// const baseURL = process.env.API_BASE_URL
//     ? process.env.API_BASE_URL
//     : `/`;
const baseURL = '/api';

export const axiosClient = axios.create({
    baseURL,
    withCredentials: true,
});
