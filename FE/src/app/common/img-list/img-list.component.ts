import { Component, EventEmitter, Input, Output } from '@angular/core';
import { APIService } from 'src/app/services/api.service';
import { Img } from 'src/app/services/api.service';
@Component({
  selector: 'app-img-list',
  templateUrl: './img-list.component.html',
  styleUrls: ['./img-list.component.css']
})
export class ImgListComponent {

  
  @Input()
  imagesInput: Img[] | undefined;
  @Output() updateImage = new EventEmitter<Img[]>();

  
url: any;
imgDisplayName: any;
imgUrl: any;
imgDuration: any;

constructor(private api: APIService) { }


addImg(url: string, display_name: string, duration: number) {
  const input = {
    url: url,
    display_name: display_name,
    duration: duration
  };


  this.api.createImage(input).subscribe((data: Img) => {
    this.imagesInput  = this.imagesInput? this.imagesInput.concat(input): [input];
    this.updateImage.emit(this.imagesInput);
    }
  );

}

deleteImg(name: string)  {

  this.imagesInput = this.imagesInput? this.imagesInput.filter((img) => img.display_name !== name): [];
    this.api.deleteImage(name).subscribe(() => {
      console.log('Image deleted');
      this.updateImage.emit(this.imagesInput);
    });  
    }
}





