<template>
    <AppHeader/>

    <main :class="$style.AppLayout"
          class="p-4">
        <slot/>
    </main>

    <AppFooter/>
</template>

<script setup lang="ts">
    import {useLifecycleLogger} from '@/hooks/lifecycleLogger';

    import AppHeader from '@/components/layouts/AppHeader.vue';
    import AppFooter from '@/components/layouts/AppFooter.vue';

    useLifecycleLogger({name: 'AppLayoutError'});
</script>

<style lang="scss" module>
    .AppLayout {
        min-height: calc(100vh - var(--header-h) - var(--footer-h));
    }
</style>
