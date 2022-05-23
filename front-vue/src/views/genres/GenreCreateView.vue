<template>
    <div>
        <h1 class="mb-8">
            Добавить новый жанр
        </h1>

        <AppCard>
            <form @submit.prevent="onSubmit">
                <AppInput
                    v-model="genre"
                    class="mb-4"
                    label="Название жанра"
                />

                <AppButton type="submit">
                    Сохранить
                </AppButton>
            </form>
        </AppCard>
    </div>
</template>

<script lang="ts" setup>
    import {ref} from 'vue';

    import AppCard from '@/components/ui/AppCard.vue';
    import AppInput from '@/components/ui/AppInput.vue';
    import {createGenre} from '@/api';
    import AppButton from '@/components/ui/AppButton.vue';

    const genre = ref('');

    const onSubmit = async () => {
        await createGenre({
            name: genre,
        });
    };
</script>
