<template>
    <div>
        <h1 class="text-2xl font-semibold">
            Жанры
        </h1>

        <div class="flex mt-8 -mx-2">
            <div v-for="genre in genres"
                 :key="genre.id"
                 class="p-2">
                <RouterLink :to="`/movies?genre=${genre.id}`"
                            class="px-4 py-2 bg-white rounded-lg shadow-xl shadow-slate-300/60">
                    {{ genre.name }}
                </RouterLink>
            </div>
        </div>
    </div>
</template>


<script lang="ts" setup>
    import {onMounted, ref} from 'vue';
    import {useRouter} from 'vue-router';
    import {fetchGenres} from '@/api/genre/genreApi';

    import type {Ref} from 'vue';
    import type {IGenreDto} from '@/api/genre/types/IGenreDto';
    import AppCard from '@/components/ui/AppCard.vue';

    const router = useRouter();
    const genres: Ref<Array<IGenreDto>> = ref([]);

    onMounted(async () => {
        try {
            const res = await fetchGenres();
            genres.value = res.data;
        } catch (err) {
            console.error(err);
        }
    });
</script>
