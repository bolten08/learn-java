import {axiosClient} from '@/api/axiosClient';

import type {AxiosResponse} from 'axios';
import type {IGenreDto} from '@/api/genre/types/IGenreDto';


const urls = {
    GENRES: 'genres',
};

export function fetchGenres(): Promise<AxiosResponse<Array<IGenreDto>>> {
    return axiosClient.get(urls.GENRES);
}

export function createGenre(body: IGenreDto): Promise<AxiosResponse> {
    return axiosClient.post(urls.GENRES, body);
}

