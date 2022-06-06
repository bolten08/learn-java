import {useUserStore} from '@/stores/user';
import type {RouteLocationNormalized, Router} from 'vue-router';

const WHITE_LIST = ['/signin', '/signup'];

export const withAuth = (router: Router): Router => {
    router.beforeEach((to: RouteLocationNormalized) => {
        const userStore = useUserStore();

        if (userStore.user && (to.path === '/signin' || to.path === '/signup')) {
            return '/movies';
        }
        if (!userStore.user && WHITE_LIST.indexOf(to.path) === -1) {
            return `/signin?redirect=${to.path}`;
        }
    });
    return router;

    // router.beforeEach(async (to, from) => {
    //     const userStore = useUserStore();
    //     const token = getToken();
    //     if (token && !userStore.user) {
    //         try {
    //             const userRes = await fetchUser();
    //             userStore.setUser(userRes.data);
    //         } catch (err) {
    //             console.log(err);
    //         }
    //     }
    //
    //     if (userStore.user && (to.path === '/signin' || to.path === '/signup')) {
    //         return '/movies';
    //     }
    //     if (!userStore.user && WHITE_LIST.indexOf(to.path) === -1) {
    //         return `/signin?redirect=${to.path}`;
    //     }
    // });
};
