import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './component/home/home.component';
import { EstrellasComponent } from './component/estrellas/estrellas.component';
import { PlanetasComponent } from './component/planetas/planetas.component';
import { NavbarComponent } from './shared/navbar/navbar.component';
import { PlanetaService} from './Service/planeta.service';
import { EstrellaService} from './Service/estrella.service';
import { CommonModule } from '@angular/common';
import { HttpClientModule} from '@angular/common/http';
import { FormsModule} from '@angular/forms';
import { PlanetaComponent } from './component/planetas/planeta/planeta.component';
import { EstrellaComponent } from './component/estrellas/estrella/estrella.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    EstrellasComponent,
    PlanetasComponent,
    NavbarComponent,
    PlanetaComponent,
    EstrellaComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    CommonModule
  ],
  providers: [PlanetaService, EstrellaService],
  bootstrap: [AppComponent]
})
export class AppModule { }
