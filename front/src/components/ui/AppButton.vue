<template>
    <button class="py-2 px-4 font-semibold rounded-lg shadow-md text-white bg-blue-500 hover:bg-blue-700"
            :class="classList"
            :type="type"
            @click="onClick">
        <slot/>
    </button>
</template>


<script lang="ts" setup>
    import {computed} from 'vue';

    const props = defineProps({
        type: {
            type: String,
            default: 'button',
        },
        block: {
            type: Boolean,
            default: false,
        },
    });
    const emits = defineEmits([
        'click',
    ]);

    const classList = computed(() => ({
        'w-full': props.block,
    }));

    const onClick = (): void => {
        emits('click');
    };
</script>
