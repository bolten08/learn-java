<template>
    <AppCard class="mt-6">
        <form class="flex" @submit.prevent="emits('submit')">
            <div class="flex-shrink-0 w-1/3 mr-6">
                <h6 class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">
                    Постер
                </h6>
                <AppFileUpload
                    :preview="poster !== null ? poster.src : undefined"
                    @change="onImageUpload"
                />
            </div>

            <div class="w-full">
                <AppInput
                    :model-value="name"
                    class="mb-4"
                    label="Название"
                    name="name"
                    @update:modelValue="$emit('update:name', $event)"
                />
                <AppInput
                    :model-value="description"
                    class="mb-4"
                    label="Описание"
                    name="description"
                    @update:modelValue="$emit('update:description', $event)"
                />
                <AppInput
                    :model-value="releaseDate"
                    class="mb-4"
                    label="Дата выхода"
                    name="releaseDate"
                    type="number"
                    @update:modelValue="$emit('update:releaseDate', $event)"
                />

                <div>
                    <h6 class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">
                        Жанр
                    </h6>
                    <Multiselect
                        :model-value="genres"
                        mode="tags"
                        :options="genresOptions"
                        searchable
                        createTag
                        valueProp="id"
                        label="name"
                        trackBy="name"
                        object
                        @update:modelValue="$emit('update:genres', $event)"
                    />
                </div>

                <AppButton class="mt-6 "
                           type="submit">
                    Добавить фильм
                </AppButton>
            </div>
        </form>
    </AppCard>
</template>

<script lang="ts" setup>
    import AppButton from '@/components/ui/AppButton.vue';
    import AppCard from '@/components/ui/AppCard.vue';
    import AppFileUpload from '@/components/ui/AppFileUpload.vue';
    import AppInput from '@/components/ui/AppInput.vue';
    import Multiselect from '@vueform/multiselect';
    import type {Prop, PropType} from 'vue';
    import type {IGenreDto} from '@/api/genre/types/IGenreDto';
    import {uploadImage} from '@/api/images/imagesApi';
    import type {IImageDto} from '@/api/images/types/IImageDto';

    const props = defineProps({
        poster: {
            type: Object as PropType<IImageDto>,
        },
        name: {
            type: String as PropType<string>,
        },
        description: {
            type: String as PropType<string>,
        },
        genres: {
            type: Array as PropType<Array<IGenreDto>>,
        },
        releaseDate: {
            type: [String, Number] as Prop<string | number>,
        },
        genresOptions: {
            type: Array as PropType<Array<IGenreDto>>,
        },
    });

    const emits = defineEmits([
        'update:name',
        'update:description',
        'update:releaseDate',
        'update:genres',
        'update:poster',
        'submit',
    ]);

    // Methods
    const onImageUpload = async (file) => {
        const formData = new FormData();
        formData.append('image', file);
        const {data: image} = await uploadImage(formData);
        emits('update:poster', image);
    };

</script>
