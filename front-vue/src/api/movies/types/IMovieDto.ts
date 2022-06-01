import type {IGenreDto} from '@/api/genre/types/IGenreDto';
import type {IImageDto} from '@/api/images/types/IImageDto';

export interface IMovieDto {
    id?: number;
    name: string;
    description: string;
    releaseDate: string;
    genres: Array<IGenreDto>;
    poster: IImageDto;
}
