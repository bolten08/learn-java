<template>
    <div>
        <h1 class="text-2xl font-semibold">
            Доавить новый фильм
        </h1>

        <AppCard class="mt-6">
            <form class="flex" @submit.prevent="onFormSubmit">
                <div class="flex-shrink-0 w-1/3 mr-6">
                    <h6 class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">
                        Постер
                    </h6>
                    <AppFileUpload
                        v-model="values.poster"
                        name="poster"
                    />
                </div>

                <div class="w-full">
                    <AppInput
                        v-model="values.name"
                        class="mb-4"
                        label="Название"
                        name="name"
                    />
                    <AppInput
                        v-model="values.description"
                        class="mb-4"
                        label="Описание"
                        name="description"
                    />
                    <AppInput
                        v-model="values.releaseDate"
                        class="mb-4"
                        label="Дата выхода"
                        name="releaseDate"
                    />

                    <div>
                        <h6 class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">
                            Жанр
                        </h6>
                        <Multiselect
                            v-model="values.genres"
                            mode="tags"
                            :options="genres"
                            searchable
                            createTag
                            valueProp="id"
                            label="name"
                            trackBy="name"
                            object
                        />
                    </div>

                    <AppButton class="mt-6 "
                               type="submit">
                        Добавить фильм
                    </AppButton>
                </div>
            </form>
        </AppCard>
    </div>
</template>

<script lang="ts" setup>
    import {onMounted, ref, reactive} from 'vue';
    import {fetchGenres} from '@/api/genre/genreApi';

    // Components
    import AppCard from '../../components/ui/AppCard.vue';
    import AppAutocomplete from '../../components/ui/AppAutocomplete.vue';
    import AppInput from '@/components/ui/AppInput.vue';
    import AppFileUpload from '@/components/ui/AppFileUpload.vue';
    import Multiselect from '@vueform/multiselect';

    // Types
    import type {Ref} from 'vue';
    import type {IGenreDto} from '@/api/genre/types/IGenreDto';
    import {useRouter} from 'vue-router';
    import AppButton from '@/components/ui/AppButton.vue';
    import {createMovie} from '@/api/movies/moviesApi';
    import {axiosClient} from '@/api/axiosClient';

    const router = useRouter();
    const genres: Ref<Array<IGenreDto>> = ref([]);
    const values = reactive({
        name: '',
        description: '',
        releaseDate: '',
        genres: [],
        poster: '',
    });

    // Methods
    onMounted(async () => {
        const genresRes = await fetchGenres();
        genres.value = genresRes.data;
    });

    const onFormSubmit = async (e) => {
        const formData = new FormData(e.target);
        formData.append('genres', values.genres);
        for (let pair of formData.entries()) {
            console.log(pair[0] + ', ' + pair[1]);
        }

        // console.log(values.poster);
        try {
            // await createMovie({
            //     ...values,
            //     genres: values.genres.map((g: IGenreDto) => {
            //         return typeof g.id === 'string'
            //             ? {id: null, name: g.name}
            //             : g;
            //     }),
            // });

            //@ts-ignore
            await createMovie(formData);
            // router.push('/movies');

            // const formData = new FormData();
            // formData.append('file', values.poster);
            // axiosClient.post('/upload', formData);
        } catch (err) {
            console.error(err);
        }
    };
</script>
