<template>
    <main>
        <div class="h-screen flex justify-center items-center">
            <slot/>
        </div>
    </main>
</template>

<script setup lang="ts">
    import {useLifecycleLogger} from '@/hooks/lifecycleLogger';

    useLifecycleLogger({name: 'AppLayoutLogin'});
</script>
