// @ts-ignore
import NProgress from 'nprogress';
import 'nprogress/nprogress.css';
import type {Router} from 'vue-router';

export const withProgress = (router: Router): Router => {
    router.beforeEach(() => {
        NProgress.start();
    });

    router.afterEach(() => {
        NProgress.done();
    });

    return router;
};
