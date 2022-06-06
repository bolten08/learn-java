<template>
    <div class="max-w-800px mx-auto">
        <h1 class="text-2xl font-semibold">
            Изменить информацию о фильме
        </h1>

        <MovieCreateCard
            v-model:name="values.name"
            v-model:description="values.description"
            v-model:genres="values.genres"
            v-model:release-date="values.releaseDate"
            v-model:poster-id="values.posterId"
            v-model:poster-src="values.posterSrc"
            :genres-options="genresOptions"
            @submit="onMovieUpdate"
        />
    </div>
</template>


<script lang="ts" setup>
    import {useRoute, useRouter} from 'vue-router';
    import {onMounted, reactive, ref, Ref} from 'vue';
    import {fetchMovieById, updateMovie} from '@/api/movies/moviesApi';
    import MovieCreateCard from '@/components/views/movies/MovieCreateCard.vue';
    import {IGenreDto} from '@/api/genre/types/IGenreDto';
    import {fetchGenres} from '@/api/genre/genreApi';

    const router = useRouter();
    const route = useRoute();

    const genresOptions: Ref<Array<IGenreDto>> = ref([]);
    const values = reactive({
        name: '',
        description: '',
        releaseDate: '',
        genres: [],
        posterId: null,
        posterSrc: '',
    });

    // Lifecycle
    onMounted(async () => {
        try {
            const [movieRes, genresRes] = await Promise.all([
                fetchMovieById(route.params.id),
                fetchGenres(),
            ]);
            genresOptions.value = genresRes.data;

            values.name = movieRes.data.name;
            values.description = movieRes.data.description;
            values.releaseDate = movieRes.data.releaseDate;
            values.genres = movieRes.data.genres;
            values.posterId = movieRes.data.poster?.id;
            values.posterSrc = movieRes.data.poster?.src || '';
        } catch (err) {
            console.error(err);
        }
    });

    // Methods
    const onMovieUpdate = async (e) => {
        const genres = values.genres.map((g: IGenreDto) => {
            return typeof g.id === 'string'
                ? {id: null, name: g.name}
                : g;
        });
        try {
            await updateMovie(route.params.id, {
                name: values.name,
                description: values.description,
                releaseDate: values.releaseDate,
                posterId: values.posterId,
                genres,
            });
            router.push(`/movies/${route.params.id}`);
        } catch (err) {
            console.error(err);
        }
    };
</script>
