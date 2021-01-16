import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule} from '@angular/forms'
import { StorageServiceModule} from 'angular-webstorage-service';
 

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NameEditorComponent } from './services/name-editor/name-editor.component';
import { ProfileComponent } from './services/profile/profile.component';
import { ApigetComponent } from './services/apiget/apiget.component';
import { HttpClientModule } from '@angular/common/http';
import { HomepageComponent } from './services/homepage/homepage.component';

@NgModule({
  declarations: [
    AppComponent,
    NameEditorComponent,
    ProfileComponent,
    ApigetComponent,
    HomepageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule, 
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
