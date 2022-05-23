import {defineNuxtConfig} from 'nuxt';

// const API_URL = process.env.API_URL || 'http://localhost:8081/';
const API_URL = 'http://localhost:8081/';

// https://v3.nuxtjs.org/api/configuration/nuxt.config
export default defineNuxtConfig({
    srcDir: 'src/',

    buildModules: [
        'nuxt-windicss',
    ],

    vite: {
        server: {
            proxy: {
                '/api': {
                    target: API_URL,
                    secure: false,
                    changeOrigin: true,
                },
            },
        },
    },
});
