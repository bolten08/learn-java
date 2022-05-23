<template>
    <div>
        <div class="flex justify-between align-center">
            <h1>
                Movies
            </h1>

            <AppButton @click="router.push('/movies/create')">
                Добавить фильм
            </AppButton>
        </div>

        {{ movies }}
    </div>
</template>

<script lang="ts" setup>
    import {onMounted, ref} from 'vue';
    import {fetchMovies} from '@/api/movies/moviesApi';
    import type {Ref} from 'vue';
    import type {IMovieDto} from '@/api/movies/types/IMovieDto';
    import AppButton from '@/components/ui/AppButton.vue';
    import {useRouter} from 'vue-router';

    const router = useRouter();
    const movies: Ref<Array<IMovieDto>> = ref([]);

    onMounted(async () => {
        try {
            const res = await fetchMovies();
            movies.value = res.data;
        } catch (err) {
            console.error(err);
        }
    });
</script>
