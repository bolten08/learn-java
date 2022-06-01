import {createRouter, createWebHistory} from 'vue-router';
import {loadLayoutMiddleware} from '@/router/middleware/loadLayout.middleware';
import {AppLayoutsEnum} from '@/layouts/layouts.types';
import {getToken, setAuthHeader} from '@/services/jwtService';
import {useUserStore} from '@/stores/user';
import {fetchUser} from '@/api/user/userApi';

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '/signin',
            name: 'signin',
            component: () => import('@/views/signin/SigninView.vue'),
            meta: {
                layout: AppLayoutsEnum.login,
            },
        },
        {
            path: '/signup',
            name: 'signup',
            component: () => import('@/views/signup/SignupView.vue'),
            meta: {
                layout: AppLayoutsEnum.login,
            },
        },
        {
            path: '/movies',
            name: 'movies',
            component: () => import('@/views/movies/MoviesView.vue'),
        },
        {
            path: '/movies/create',
            name: 'movie-create',
            component: () => import('@/views/movies/MovieCreateView.vue'),
        },
        {
            path: '/movies/:id',
            name: 'movie-detail',
            component: () => import('@/views/movies/MovieDetailView.vue'),
        },
        {
            path: '/movies/:id/edit',
            name: 'movie-edit',
            component: () => import('@/views/movies/MovieEditView.vue'),
        },
        {
            path: '/genres',
            name: 'genres',
            component: () => import('@/views/genres/GenresView.vue'),
        },
        {
            path: '/genres/create',
            name: 'genre-create',
            component: () => import('@/views/genres/GenreCreateView.vue'),
        },
        {
            path: '/:pathMatch(.*)*',
            name: 'not-found',
            component: () => import('@/views/NotFound.vue'),
            meta: {
                layout: AppLayoutsEnum.login,
            },
        },
    ],
});

router.beforeEach(loadLayoutMiddleware);

const WHITE_LIST = ['/signin', '/signup'];
router.beforeEach(async (to, from, next) => {
    const userStore = useUserStore();
    const token = getToken();

    if (token) {
        setAuthHeader(token);
        if (!userStore.user) {
            try {
                const resUser = await fetchUser();
                userStore.setUser(resUser.data);
            } catch (err) {
                console.log(err);
            }
        }
        //
        // if (to.path === '/login') {
        //     next({path: '/movies'});
        // } else {
        //     next();
        // }
    }
    // else if (WHITE_LIST.indexOf(to.path) !== -1) {
    //     next();
    // } else {
    //     next(`/login?redirect=${to.path}`);
    // }
    next();
});

export default router;
