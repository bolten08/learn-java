import type {IGenreDto} from '@/api/genre/types/IGenreDto';

export interface IMovieDto {
    id?: number;
    name: string;
    description: string;
    releaseDate: string;
    genres: Array<IGenreDto>;
}
