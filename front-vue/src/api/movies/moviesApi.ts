import type {AxiosResponse} from 'axios';
import {axiosClient} from '@/api/axiosClient';
import type {IMovieDto} from '@/api/movies/types/IMovieDto';

interface IGenreQuery {
    genre: number;
}

const endpoints = {
    MOVIES: 'movies',
    MOVIE_DETAIL: (id: number) => `movies/${id}`,
};

export function fetchMovies(query?: IGenreQuery): Promise<AxiosResponse<Array<IMovieDto>>> {
    return axiosClient.get(endpoints.MOVIES, {
        params: query,
    });
}

export function createMovie(body: IMovieDto): Promise<AxiosResponse> {
    return axiosClient.post(endpoints.MOVIES, body);
}

export function updateMovie(id: number, body: IMovieDto): Promise<AxiosResponse> {
    return axiosClient.post(endpoints.MOVIE_DETAIL(id), body);
}

export function deleteMovie(id: number): Promise<AxiosResponse> {
    return axiosClient.post(endpoints.MOVIE_DETAIL(id));
}

