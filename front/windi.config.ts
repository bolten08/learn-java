import {defineConfig} from 'windicss/helpers';

export default defineConfig({
    theme: {
        extend: {
            boxShadow: {
                'xl': '0 10px 25px 0 rgba(0, 0, 0, 0.1), 0 10px 10px -5px rgba(0, 0, 0, 0.04)',
            },
        },
    },
    shortcuts: {
        'card': 'py-4 px-8 bg-white rounded-lg shadow-xl shadow-slate-300/60',
        'btn': 'py-2 px-4 font-semibold rounded-lg shadow-md',
        'btn-green': 'text-white bg-green-500 hover:bg-green-700',
        'input': 'bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full pl-10 p-2.5  dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500',
    },
});
