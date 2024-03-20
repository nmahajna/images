import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ImageManagerComponent } from './common/image-manager/image-manager.component';

const routes: Routes = [
  { path: 'image-manager', component: ImageManagerComponent },
  { path: '', redirectTo: 'image-manager', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
