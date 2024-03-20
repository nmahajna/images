import { Component, Input } from '@angular/core';
interface Img {
  url: string;
  display_name: string;
  duration: number;
}
@Component({
  selector: 'app-slideshow-player',
  templateUrl: './slideshow-player.component.html',
  styleUrls: ['./slideshow-player.component.css']
})
export class SlideshowPlayerComponent {
  currentImg: Img | undefined;
  imgs: Img[] = [];
  size = 0;
  //initialize slideshowInterval
  slideshowInterval: any;

  @Input()
  imagesInput: Img[] | undefined;

  //listen to imagesInput change
  ngOnChanges() {
    if (this.imagesInput && this.imagesInput.length > 0) {
      this.imgs = this.imagesInput;
      this.size = this.imgs.length;
      this.currentImg = this.imgs[0];
      this.playSlideshow();
    }
 
  }
  playSlideshow() {
    
    let currentIndex = 0;
    if (this.slideshowInterval) {
      clearInterval(this.slideshowInterval);
    }
     this.slideshowInterval = setInterval(() => {
      this.currentImg = this.imgs[currentIndex];
      currentIndex = (currentIndex + 1) % this.imgs.length;
    }, this.currentImg? this.currentImg.duration : 0);
    
  }
}


