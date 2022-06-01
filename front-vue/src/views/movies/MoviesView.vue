<template>
    <div>
        <div class="flex justify-between align-center">
            <h1 class="text-2xl font-semibold">
                Все фильмы
            </h1>

            <AppButton @click="router.push('/movies/create')">
                Добавить фильм
            </AppButton>
        </div>

        <div class="grid grid-cols-4 gap-4 mt-8">
            <RouterLink v-for="movie in movies"
                        :key="movie.id"
                        :to="`/movies/${movie.id}`"
                        class="aspect-w-300 aspect-h-450">
                <img class="object-cover rounded-lg"
                     :src="movie.poster ? movie.poster.src : ''"/>
            </RouterLink>
        </div>
    </div>
</template>

<script lang="ts" setup>
    import {computed, onMounted, ref, watch} from 'vue';
    import {fetchMovies} from '@/api/movies/moviesApi';
    import type {Ref} from 'vue';
    import type {IMovieDto} from '@/api/movies/types/IMovieDto';
    import AppButton from '@/components/ui/AppButton.vue';
    import {useRoute, useRouter} from 'vue-router';

    const router = useRouter();
    const route = useRoute();
    const movies: Ref<Array<IMovieDto>> = ref([]);

    // Computed
    const genreId = computed(() => route.query.genre);

    // Watch
    watch(genreId, () => {
        loadMovies();
    });

    // Lifecycle
    onMounted(() => {
        loadMovies();
    });

    // Methods
    const loadMovies = async () => {
        try {
            const res = await fetchMovies({
                params: {
                    genre: route.query.genre,
                },
            });
            movies.value = res.data;
        } catch (err) {
            console.error(err);
        }
    };
</script>
