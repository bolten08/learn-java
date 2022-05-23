import {axiosClient} from '@/api/axiosClient';

const TOKEN_KEY = 'access_token';

export function getToken(): string | null {
    return localStorage.getItem(TOKEN_KEY);
}

export function setToken(token: string): void {
    localStorage.setItem(TOKEN_KEY, token);
}

export function removeToken(): void {
    localStorage.removeItem(TOKEN_KEY);
}

export function setAuthHeader(token: string) {
    axiosClient.defaults.headers.common.Authorization = 'Bearer ' + token;
}

export function removeAuthHeader() {
    delete axiosClient.defaults.headers.common.Authorization;
}
