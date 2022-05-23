<template>
    <header :class="$style.AppHeader"
            class="flex items-center px-4 bg-dark-500">
        <AppLogo/>

        <nav class="flex items-center h-full ml-10">
            <RouterLink class="flex items-center h-full text-gray-300 hover:text-gray-100 transition-colors"
                        to="/movies">
                Фильмы
            </RouterLink>

            <RouterLink class="flex items-center h-full text-gray-300 hover:text-gray-100 transition-colors ml-4"
                        to="/genres">
                Жанры
            </RouterLink>
        </nav>

        <AppLogout class="ml-auto"/>
    </header>
</template>

<script lang="ts" setup>
    import AppLogo from '@/components/AppLogo.vue';
    import AppLogout from '@/components/AppLogout.vue';
</script>

<style lang="scss" module>
    .AppHeader {
        height: var(--header-h);
    }
</style>
