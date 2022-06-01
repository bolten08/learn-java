import {axiosClient} from '@/api/axiosClient';

import type {AxiosRequestConfig, AxiosResponse} from 'axios';
import type {IMovieDto} from '@/api/movies/types/IMovieDto';

interface IGenreQuery {
    genre: number;
}

const endpoints = {
    MOVIES: 'movies',
    MOVIE_DETAIL: (id: string) => `movies/${id}`,
};

export function fetchMovies(config: AxiosRequestConfig): Promise<AxiosResponse<Array<IMovieDto>>> {
    return axiosClient.get(endpoints.MOVIES, config);
}

export function fetchMovieById(id: string): Promise<AxiosResponse<IMovieDto>> {
    return axiosClient.get(endpoints.MOVIE_DETAIL(id));
}

export function createMovie(body: IMovieDto): Promise<AxiosResponse> {
    return axiosClient.post(endpoints.MOVIES, body);
}

export function updateMovie(id: string, body: IMovieDto): Promise<AxiosResponse> {
    return axiosClient.put(endpoints.MOVIE_DETAIL(id), body);
}

export function deleteMovie(id: string): Promise<AxiosResponse> {
    return axiosClient.delete(endpoints.MOVIE_DETAIL(id));
}

