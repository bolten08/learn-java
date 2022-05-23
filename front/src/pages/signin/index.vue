<template>
    <div class="min-h-screen flex flex-col justify-center px-8 py-16">
        <AppCard class="mx-auto w-96">
            <form>
                <AppInput
                    v-model="values.email"
                    class="mb-4"
                    label="Email"
                />
                <AppInput
                    v-model="values.password"
                    label="Password"
                />

                <hr class="my-6 border-t">

                <AppButton class="mb-6"
                           type="submit"
                           block>
                    Sign in
                </AppButton>

                <div class="flex justify-center">
                    <nuxt-link class="inline-block text-sm text-blue-500 align-baseline hover:text-blue-800"
                               to="/signup">
                        Don't have an account? Sign up!
                    </nuxt-link>
                </div>
            </form>
        </AppCard>
    </div>
</template>

<script lang="ts" setup>
    import AppInput from '~/components/ui/AppInput.vue';
    import AppCard from '~/components/ui/AppCard.vue';
    import AppButton from '~/components/ui/AppButton.vue';
    import {reactive} from 'vue';

    definePageMeta({
        layout: 'empty',
    });

    const values = reactive({
        email: '',
        password: '',
    });
</script>
