import {fileURLToPath, URL} from 'url';

import {defineConfig} from 'vite';
import vue from '@vitejs/plugin-vue';
import WindiCSS from 'vite-plugin-windicss';

const API_URL = 'http://localhost:8081/';


// https://vitejs.dev/config/
export default defineConfig({
    plugins: [vue(), WindiCSS()],
    resolve: {
        alias: {
            '@': fileURLToPath(new URL('./src', import.meta.url)),
        },
    },
    server: {
        proxy: {
            '/api': {
                target: API_URL,
                secure: false,
                changeOrigin: true,
            },
        },
    },
});
