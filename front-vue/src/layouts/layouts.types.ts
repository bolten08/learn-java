export enum AppLayoutsEnum {
    default = 'default',
    login = 'login',
    error = 'error',
}

export const AppLayoutToFileMap: Record<AppLayoutsEnum, string> = {
    [AppLayoutsEnum.default]: 'AppLayoutDefault.vue',
    [AppLayoutsEnum.login]: 'AppLayoutLogin.vue',
    [AppLayoutsEnum.error]: 'AppLayoutError.vue',
};
