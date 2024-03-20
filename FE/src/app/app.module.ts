import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ImageManagerComponent } from './common/image-manager/image-manager.component';
import { ImgListComponent } from './common/img-list/img-list.component';
import { SlideshowPlayerComponent } from './common/slideshow-player/slideshow-player.component';
import { APIService } from './services/api.service';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    ImageManagerComponent,
    ImgListComponent,
    SlideshowPlayerComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule 
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
