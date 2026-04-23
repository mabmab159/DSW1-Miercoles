import { Component } from '@angular/core';
import { inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Pokeapiresponse } from '../pokeapiresponse';
import { ChangeDetectorRef } from '@angular/core';

@Component({
  selector: 'app-prueba1',
  imports: [],
  templateUrl: './prueba1.html',
  styleUrl: './prueba1.css',
})
export class Prueba1 {
  nombre: string = 'Miguel Berrio';
  cantidad: number = 10;
  precio: number = 100;
  objeto: object = { nombre: 'Miguel Berrio', edad: 25 };
  pokemon: Pokeapiresponse = {} as Pokeapiresponse;
  nombres: string[] = ['Miguel Berrio', 'Juan Perez', 'Maria Garcia'];

  private http = inject(HttpClient);
  private cdr = inject(ChangeDetectorRef);

  constructor() {
    this.recuperarInformacionPokemon();
    this.recuperarInformacionPokemon2();
  }

  private recuperarInformacionPokemon(): void {
    this.http.get('https://pokeapi.co/api/v2/pokemon/ditto').subscribe((data) => console.log(data));
  }

  private recuperarInformacionPokemon2(): void {
    this.http.get<Pokeapiresponse>('https://pokeapi.co/api/v2/pokemon/ditto').subscribe(p => {
      this.pokemon = p;
      this.cdr.detectChanges();
    });
  }
}
