import 'virtual:windi.css';
import '@/assets/styles/global.scss';
import '@vueform/multiselect/themes/default.css';
import {createApp} from 'vue';
import {createPinia} from 'pinia';

import App from './App.vue';
import router from './router';
import {getToken, setAuthHeader} from '@/services/jwtService';
import {fetchUser} from '@/api/user/userApi';
import {useUserStore} from '@/stores/user';

const app = createApp(App);
app.use(createPinia());
app.use(router);
// app.mount('#app');

const jwtToken = getToken();
if (jwtToken) {
    console.log('jwtToken', jwtToken);
    setAuthHeader(jwtToken);
    fetchUser()
        .then((res) => {
            const userStore = useUserStore();
            userStore.setUser(res.data);
            app.mount('#app');
        })
        .catch((err) => {
            console.log('Error user, start app');
            app.mount('#app');
        });
} else {
    app.mount('#app');
}
//
// const startApp = () => {
//     const app = createApp(App);
//     app.use(createPinia());
//     app.use(router);
//     app.mount('#app');
// };

