import {axiosClient} from '@/api/axiosClient';

import type {AxiosResponse} from 'axios';
import type {IImageDto} from '@/api/images/types/IImageDto';

const endpoints = {
    UPLOAD: 'upload/images',
};

export function uploadImage(body: FormData): Promise<AxiosResponse<Array<IImageDto>>> {
    return axiosClient.post(endpoints.UPLOAD, body);
}

