<template>
    <div>
        <h6 v-if="label"
            class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">
            {{ label }}
        </h6>
        <input
            v-model="model"
            class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
            :type="type">
    </div>
</template>

<script lang="ts" setup>
    const props = defineProps({
        modelValue: {
            type: [String, Number],
            default: null,
        },
        label: {
            type: String,
            default: '',
        },
        type: {
            type: String,
            default: 'text',
        },
    });
    const emits = defineEmits([
        'update:modelValue',
    ]);

    const model = computed({
        get: () => props.modelValue,
        set: (value) => emits('update:modelValue', value),
    });
</script>
