<template>
    <div class="max-w-800px mx-auto">
        <h1 class="text-2xl font-semibold">
            Добавить новый фильм
        </h1>

        <MovieCreateCard
            v-model:name="values.name"
            v-model:description="values.description"
            v-model:genres="values.genres"
            v-model:release-date="values.releaseDate"
            v-model:poster="values.poster"
            :genres-options="genresOptions"
            @submit="onMovieCreate"
        />
    </div>
</template>

<script lang="ts" setup>
    import {onMounted, ref, reactive} from 'vue';
    import {fetchGenres} from '@/api/genre/genreApi';
    import {useRouter} from 'vue-router';
    import {createMovie} from '@/api/movies/moviesApi';

    // Components
    import MovieCreateCard from '@/components/views/movies/MovieCreateCard.vue';

    // Types
    import type {Ref} from 'vue';
    import type {IGenreDto} from '@/api/genre/types/IGenreDto';

    const router = useRouter();
    const genresOptions: Ref<Array<IGenreDto>> = ref([]);
    const values = reactive({
        name: '',
        description: '',
        releaseDate: '',
        genres: [],
        poster: null,
    });

    // Lifecycle
    onMounted(async () => {
        const {data} = await fetchGenres();
        genresOptions.value = data;
    });

    // Methods
    const onMovieCreate = async (e) => {
        const genres = values.genres.map((g: IGenreDto) => {
            return typeof g.id === 'string'
                ? {id: null, name: g.name}
                : g;
        });
        try {
            await createMovie({
                ...values,
                genres,
            });
            router.push('/movies');
        } catch (err) {
            console.error(err);
        }
    };
</script>
