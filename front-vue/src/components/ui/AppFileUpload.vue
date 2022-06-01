<template>
    <div class="block aspect-w-300 aspect-h-450">
        <img v-if="preview"
             class="object-cover rounded-lg cursor-pointer"
             alt="Uploaded Image"
             :src="preview "/>

        <div v-else
             class="flex flex-col items-center justify-center pt-5 pb-6 border-1 border-gray-300 border-dashed rounded-lg bg-gray-50 dark:hover:bg-bray-800 dark:bg-gray-700 hover:bg-gray-100 dark:border-gray-600 dark:hover:border-gray-500 dark:hover:bg-gray-600">
            <svg class="w-10 h-10 mb-3 text-gray-400" fill="none" stroke="currentColor" viewBox="0 0 24 24"
                 xmlns="http://www.w3.org/2000/svg">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                      d="M7 16a4 4 0 01-.88-7.903A5 5 0 1115.9 6L16 6a5 5 0 011 9.9M15 13l-3-3m0 0l-3 3m3-3v12"></path>
            </svg>
            <p class="mb-2 text-sm text-gray-500 dark:text-gray-400 font-semibold">
                Click to upload
            </p>
        </div>

        <label class="cursor-pointer">
            <input
                type="file"
                class="hidden"
                @change="onChange"
            />
        </label>
    </div>
</template>

<script lang="ts" setup>
    import {computed, ref} from 'vue';
    import type {Ref} from 'vue';

    const props = defineProps({
        preview: {
            type: String,
        },
    });
    const emits = defineEmits([
        'change',
    ]);

    const imageFile: Ref<string | ArrayBuffer | null> = ref(null);

    // Methods
    // const uploadImage = (e) => {
    //     const target = e.target;
    //     if (target.files) {
    //         const reader = new FileReader();
    //         reader.onload = (e) => {
    //             imagePreview.value = e.target.result;
    //         };
    //         reader.readAsDataURL(target.files[0]);
    //         imageFile.value = target.files[0];
    //     }
    //     emits('update:modelValue', imageFile);
    // };

    const onChange = (e) => {
        console.log('onChange');
        emits('change', e.target.files[0]);
    };
</script>
