<template>
    <div class="min-h-screen flex flex-column justify-center px-8 py-16">
        <AppCard class="mx-auto w-96">
            <h1 class="mb-4 text-center font-semibold text-xl">
                Create Account
            </h1>

            <form @submit.prevent="onFormSubmit">
                <AppInput
                    v-model="values.firstName"
                    class="mb-4"
                    label="First name"
                />
                <AppInput
                    v-model="values.lastName"
                    class="mb-4"
                    label="Second name"
                />
                <AppInput
                    v-model="values.email"
                    class="mb-4"
                    label="Email"
                />
                <AppInput
                    v-model="values.password"
                    class="mb-4"
                    label="Password"
                    type="password"
                />
                <AppInput
                    v-model="values.passwordConfirm"
                    label="Confirm password"
                    type="password"
                />

                <hr class="my-6 border-t">

                <AppButton class="mb-6"
                           type="submit"
                           block>
                    Confirm
                </AppButton>

                <div class="flex justify-center">
                    <nuxt-link class="inline-block mx-auto text-sm text-blue-500 align-baseline hover:text-blue-800"
                               to="/signin">
                        Already have an account? Login!
                    </nuxt-link>
                </div>
            </form>
        </AppCard>
    </div>
</template>

<script lang="ts" setup>
    import {reactive} from 'vue';
    import {useRouter} from 'vue-router';

    import AppInput from '~/components/ui/AppInput.vue';
    import AppCard from '~/components/ui/AppCard.vue';
    import AppButton from '~/components/ui/AppButton.vue';
    import {registerUser} from '~/api';

    definePageMeta({
        title: 'Create Account',
        layout: 'empty',
    });
    const router = useRouter();

    const values = reactive({
        firstName: '',
        lastName: '',
        email: '',
        password: '',
        passwordConfirm: '',
    });

    // Methods
    const onFormSubmit = async (e): Promise<void> => {
        e.preventDefault();
        console.log('onFormSubmit');
        try {
            await registerUser(values);
            router.push('/signin');
        } catch (err) {
            console.error('[Request Error] registerUser\n', err);
        }
    };
</script>
