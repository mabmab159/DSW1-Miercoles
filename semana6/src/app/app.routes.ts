import { Routes } from '@angular/router';
import { Prueba1 } from './prueba1/prueba1';
import { Prueba2 } from './prueba2/prueba2';
import { Prueba3 } from './prueba3/prueba3';

export const routes: Routes = [
  { path: '', component: Prueba1 },
  { path: 'prueba2', component: Prueba2 },
  { path: 'prueba3/**', component: Prueba3 },
];
