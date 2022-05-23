import {vi, describe, beforeEach, test, expect} from 'vitest';
import {loginUser, registerUser, fetchUser} from '../userApi';

import type {ISigninRequestDto} from '../types/ISigninRequestDto';
import type {IJwtResponseDto} from '../types/IJwtResponseDto';


const getMock = vi.fn();
const postMock = vi.fn();
vi.mock('../../../axiosClient', () => ({
    get: (...args: any[]) => getMock(...args),
    post: (...args: any[]) => postMock(...args),
}));

describe('userApi', () => {
    beforeEach(() => {
        getMock.mockReset();
        postMock.mockReset();
    });

    test('loginUser', async () => {
        const REQUEST_DATA: ISigninRequestDto = {
            email: 'email',
            password: '123',
        };
        const RESPONSE_DATA: IJwtResponseDto = {
            token: 'qwerty',
        };

        getMock.mockResolvedValue(RESPONSE_DATA);
        const response = await loginUser(REQUEST_DATA);
        expect(getMock).toHaveBeenCalledWith('user/signin', REQUEST_DATA);
        expect(response).toBe(RESPONSE_DATA);
    });

});
