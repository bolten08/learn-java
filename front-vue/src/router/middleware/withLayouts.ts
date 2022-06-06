import type {RouteLocationNormalized, Router} from 'vue-router';
import {AppLayoutsEnum, AppLayoutToFileMap} from '@/layouts/layouts.types';


export const withLayouts = (router: Router): Router => {
    router.beforeEach(async (route: RouteLocationNormalized): Promise<void> => {
        const {layout} = route.meta;
        const layoutName = layout || AppLayoutsEnum.default;
        const fileName = AppLayoutToFileMap[layoutName];

        const component = await import(`../../layouts/${fileName}`);
        route.meta.layoutComponent = component.default;
    });
    return router;
};
