import { Component, EventEmitter, Input, Output } from '@angular/core';
import { APIService } from '../../services/api.service';
import { Img } from '../../services/api.service';

@Component({
  selector: 'app-image-manager',
  templateUrl: './image-manager.component.html',
  styleUrls: ['./image-manager.component.css']
})

export class ImageManagerComponent {
callback($event: Img[]) {
  this.images = $event;
}
  @Input()
  imagesInput: Img[] | undefined;

  images : Img[] = [];

  constructor(private api: APIService) { 

    api.getImages().subscribe((data: Img[]) => {
      this.images = data;
    });
  }

}
