import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Img {
  url: string;
  display_name: string;
  duration: number;
}
@Injectable({
    providedIn: 'root'
})
export class APIService {
    private apiUrl = 'http://localhost:8080'; // Replace with your API endpoint

    constructor(private http: HttpClient) { }

    // POST method to create a new image
    createImage(image: Img): Observable<Img> {
        return this.http.post<Img>(this.apiUrl + '/addImage', image);
    }

    // GET method to retrieve all images
    // getImages(): Observable<Img[]> {
    //     return this.http.get<Img[]>(this.apiUrl);
    // }

    getImages(): Observable<Img[]> {
        return this.http.get<Img[]>(this.apiUrl + '/images');
    }

    // DELETE method to delete an image by ID
    deleteImage(imageId: string): Observable<void> {
        const url = `${this.apiUrl}/deleteImage/${imageId}`;
        return this.http.delete<void>(url);
    }
}