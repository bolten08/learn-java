import {axiosClient} from '../axiosClient';

import type {AxiosResponse} from 'axios';
import type {ISigninRequestDto} from '@/api/user/types/ISigninRequestDto';
import type {IJwtResponseDto} from '@/api/user/types/IJwtResponseDto';
import type {ISignupRequestDto} from '@/api/user/types/ISignupRequestDto';
import type {IUserDto} from '@/api/user/types/IUserDto';


const endpoints = {
    SIGN_IN: 'user/signin',
    SIGN_UP: 'user/signup',
    GET_USER: 'user',
};

export function loginUser(data: ISigninRequestDto): Promise<AxiosResponse<IJwtResponseDto>> {
    return axiosClient.post(endpoints.SIGN_IN, data);
}

export function registerUser(data: ISignupRequestDto): Promise<AxiosResponse> {
    return axiosClient.post(endpoints.SIGN_UP, data);
}

export function fetchUser(): Promise<AxiosResponse<IUserDto>> {
    return axiosClient.get(endpoints.GET_USER);
}
