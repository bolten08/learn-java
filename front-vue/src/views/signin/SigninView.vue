<template>
    <div class="min-h-screen flex flex-col justify-center px-8 py-16">
        <AppCard class="mx-auto w-96">
            <form @submit.prevent="onFormSubmit">
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
                    <RouterLink class="inline-block text-sm text-blue-500 align-baseline hover:text-blue-800"
                                to="/signup">
                        Don't have an account? Sign up!
                    </RouterLink>
                </div>
            </form>
        </AppCard>
    </div>
</template>

<script lang="ts" setup>
    import {reactive} from 'vue';
    import {loginUser} from '@/api/user/userApi';
    import {useRouter} from 'vue-router';
    import {setAuthHeader, setToken} from '@/services/jwtService';

    import AppInput from '@/components/ui/AppInput.vue';
    import AppCard from '@/components/ui/AppCard.vue';
    import AppButton from '@/components/ui/AppButton.vue';

    const router = useRouter();

    const values = reactive({
        email: '',
        password: '',
    });

    // Methods
    const onFormSubmit = async (e: Event): Promise<void> => {
        try {
            const tokenRes = await loginUser(values);
            setToken(tokenRes.data.token);
            setAuthHeader(tokenRes.data.token);
            router.push('/movies');
        } catch (err) {
            console.error('[Request Error] loginUser\n', err);
        }
    };
</script>
