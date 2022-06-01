<template>
    <div class="flex">
        <div class="flex-shrink-0 w-1/3">
            <div class="aspect-w-300 aspect-h-450">
                <img class="object-cover rounded-lg"
                     :src="movie.poster ? movie.poster.src : '#'"/>
            </div>

            <AppButton class="block w-full mt-4"
                       @click="onMovieDelete">
                Удалить
            </AppButton>
            <AppButton class="block w-full mt-2"
                       @click="onMovieEdit">
                Изменить
            </AppButton>
        </div>

        <div class="w-full ml-10">
            <h1 class="text-4xl font-semibold">
                {{ movie.name }}
            </h1>

            <h2 class="text-2xl font-semibold mt-4">
                О фильме
            </h2>

            <div>
                <div>
                    <div>
                        Год производства
                    </div>
                    <div>
                        {{ movie.releaseDate }}
                    </div>
                </div>
                <div>
                    <div>
                        Жанр
                    </div>
                    <div>
                        <template v-for="genre in movie.genres">
                            {{ genre.name }}
                        </template>
                    </div>
                </div>
            </div>

            <div class="mt-4">
                {{ movie.description }}
            </div>
        </div>
    </div>
</template>

<script lang="ts" setup>
    import AppButton from '../../components/ui/AppButton.vue';
    import {useRoute, useRouter} from 'vue-router';
    import {onMounted, ref} from 'vue';
    import {deleteMovie, fetchMovieById} from '@/api/movies/moviesApi';

    const router = useRouter();
    const route = useRoute();

    const movie = ref({});

    onMounted(async () => {
        const res = await fetchMovieById(route.params.id);
        movie.value = res.data;
    });

    const onMovieDelete = async () => {
        await deleteMovie(route.params.id);
        router.push('/movies/');
    };

    const onMovieEdit = () => {
        router.push(`/movies/${route.params.id}/edit`);
    };
</script>
