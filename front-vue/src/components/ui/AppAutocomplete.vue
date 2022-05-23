<template>
    <Combobox v-model="selected">
        <div class="relative mt-1">
            <div
                class="relative w-full cursor-default overflow-hidden rounded-lg bg-white text-left shadow-md focus:outline-none focus-visible:ring-2 focus-visible:ring-white focus-visible:ring-opacity-75 focus-visible:ring-offset-2 focus-visible:ring-offset-teal-300 sm:text-sm">

                <ComboboxInput
                    class="w-full border-none py-2 pl-3 pr-10 text-sm leading-5 text-gray-900 focus:ring-0"
                    :displayValue="(person) => person.name"
                    @change="query = $event.target.value"
                />
            </div>

            <TransitionRoot leave="transition ease-in duration-100"
                            leaveFrom="opacity-100"
                            leaveTo="opacity-0"
                            @after-leave="query = ''">
                <ComboboxOptions
                    class="absolute mt-1 max-h-60 w-full overflow-auto rounded-md bg-white py-1 text-base shadow-lg ring-1 ring-black ring-opacity-5 focus:outline-none sm:text-sm">

                    <ComboboxOption v-for="item in items"
                                    as="template"
                                    :key="item.id"
                                    :value="item.name"
                                    v-slot="{ selected, active }">
                        <li class="relative cursor-default select-none py-2 pl-10 pr-4"
                            :class="{
                              'bg-teal-600 text-white': active,
                              'text-gray-900': !active,
                            }">
                            <span class="block truncate"
                                  :class="{ 'font-medium': selected, 'font-normal': !selected }">
                              {{ person.name }}
                            </span>
                        </li>
                    </ComboboxOption>
                </ComboboxOptions>
            </TransitionRoot>
        </div>
    </Combobox>
</template>

<script lang="ts" setup>
    import {ref, computed} from 'vue';
    import {
        Combobox,
        ComboboxInput,
        ComboboxButton,
        ComboboxOptions,
        ComboboxOption,
        TransitionRoot,
    } from '@headlessui/vue';
    import type {IGenreDto} from '@/api/genre/types/IGenreDto';

    import type {PropType} from 'vue';

    const props = defineProps({
        items: Array as PropType<Array<IGenreDto>>,
        default: () => [],
    });

    const people = [
        {id: 1, name: 'Wade Cooper'},
        {id: 2, name: 'Arlene Mccoy'},
        {id: 3, name: 'Devon Webb'},
        {id: 4, name: 'Tom Cook'},
        {id: 5, name: 'Tanya Fox'},
        {id: 6, name: 'Hellen Schmidt'},
    ];

    let selected = ref('');
    let query = ref('');

    let filteredPeople = computed(() =>
        query.value === ''
            ? people
            : people.filter((person) =>
                person.name
                    .toLowerCase()
                    .replace(/\s+/g, '')
                    .includes(query.value.toLowerCase().replace(/\s+/g, '')),
            ),
    );
</script>
