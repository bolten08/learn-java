<template>
    <button class="text-gray-300 hover:text-gray-100 transition-colors"
            @click="onLogout">
        Выйти
    </button>
</template>

<script lang="ts" setup>
    import {useRouter} from 'vue-router';
    import {removeAuthHeader, removeToken} from '@/services/jwtService';

    const router = useRouter();

    // Methods
    const onLogout = async (): Promise<void> => {
        removeToken();
        removeAuthHeader();
        router.push('/signin');
    };
</script>
