<template>
    <main>
        <div>
            AppLayoutError
        </div>
        <slot/>
    </main>
</template>

<script setup lang="ts">
    import {useLifecycleLogger} from '@/hooks/lifecycleLogger';

    useLifecycleLogger({name: 'AppLayoutError'});
</script>
