import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AppComponent } from './app.component';

import { NameEditorComponent } from './services/name-editor/name-editor.component';

import { ProfileComponent } from './services/profile/profile.component';

import { ApigetComponent } from './services/apiget/apiget.component';

import { HomepageComponent } from './services/homepage/homepage.component';
const routes: Routes = [
  { path: 'homepage', component: HomepageComponent },
    { path: 'calculator', component: NameEditorComponent },
    { path: 'register', component: ProfileComponent },
    { path: 'api', component: ApigetComponent },

    // otherwise redirect to home
    { path: '**', redirectTo: '' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
