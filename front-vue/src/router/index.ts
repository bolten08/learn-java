import {createRouter, createWebHistory} from 'vue-router';
import {AppLayoutsEnum} from '@/layouts/layouts.types';
import {withLayouts} from '@/router/middleware/withLayouts';
import {withAuth} from '@/router/middleware/withAuth';
import {withProgress} from '@/router/middleware/withProgress';

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
            path: '/:pathMatch(.*)*',
            name: 'not-found',
            component: () => import('@/views/NotFound.vue'),
            meta: {
                layout: AppLayoutsEnum.login,
            },
        },
    ],
});

export default withProgress(withAuth(withLayouts(router)));
