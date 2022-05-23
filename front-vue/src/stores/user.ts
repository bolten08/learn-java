import {defineStore} from 'pinia';
import {removeAuthHeader, removeToken} from '@/services/jwtService';
import type {IUserDto} from '@/api/user/types/IUserDto';

export type UserState = {
    user: IUserDto | null;
};

export const useUserStore = defineStore({
    id: 'user',

    state: () => ({
        user: null,
    } as UserState),

    actions: {
        setUser(user: IUserDto) {
            this.user = user;
        },

        removeUser() {
            this.user = null;
            removeToken();
            removeAuthHeader();
        },
    },
});
