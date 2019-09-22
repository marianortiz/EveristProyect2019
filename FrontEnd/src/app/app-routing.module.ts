import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './component/home/home.component';
import { PlanetasComponent } from './component/planetas/planetas.component';
import { EstrellasComponent } from './component/estrellas/estrellas.component';
import { PlanetaComponent } from './component/planetas/planeta/planeta.component';
import { EstrellaComponent } from './component/estrellas/estrella/estrella.component';


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'planetas', component: PlanetasComponent},
  {path: 'estrellas', component: EstrellasComponent},
  {path: 'estrellas/:id', component: EstrellaComponent },
  {path: 'planetas/:id', component: PlanetaComponent},
  {path: 'planetas/0', component: PlanetaComponent},
  {path: 'estrellas/0', component: EstrellaComponent},
  


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
