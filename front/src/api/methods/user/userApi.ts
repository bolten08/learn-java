import {AxiosResponse} from 'axios';
import {get, post} from '../../utils/axiosInstance';
import {IUserLoginDto} from './models/IUserLoginDto';
import {IUserRegistrationDto} from '~/api/methods/user/models/IUserRegistrationDto';


const urls = {
    LOGIN: 'user/signin',
    REGISTER: 'user/signup',
    USER: 'user',
};

export function loginUser(data: IUserLoginDto): Promise<AxiosResponse> {
    return post(urls.LOGIN, data);
}

export function registerUser(data: IUserRegistrationDto): Promise<AxiosResponse> {
    return post(urls.REGISTER, data);
}

export function fetchUser(): Promise<AxiosResponse> {
    return get(urls.USER);
}
