import { Component } from '@angular/core';
import { inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Pokeapiresponse } from '../interfaces/pokeapiresponse';
import { ChangeDetectorRef } from '@angular/core';
import { Usuarioresponse } from '../interfaces/usuarioresponse';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-prueba1',
  imports: [FormsModule],
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
  listaUsuarios: Usuarioresponse[] = [];
  listaUsuariosProtegidos: Usuarioresponse[] = [];
  textoGenerativo: string = "";

  private http = inject(HttpClient);
  private cdr = inject(ChangeDetectorRef);

  constructor() {
    this.recuperarInformacionPokemon();
    this.recuperarInformacionPokemon2();
    this.recuperarListaUsuarios();
    this.recuperarToken();
    this.recuperarListaUsuariosToken();
  }

  private recuperarInformacionPokemon(): void {
    this.http.get('https://pokeapi.co/api/v2/pokemon/ditto').subscribe((data) => console.log(data));
  }

  private recuperarInformacionPokemon2(): void {
    this.http.get<Pokeapiresponse>('https://pokeapi.co/api/v2/pokemon/ditto').subscribe((p) => {
      this.pokemon = p;
      this.cdr.detectChanges();
    });
  }

  private recuperarListaUsuarios(): void {
    this.http
      .get<Usuarioresponse[]>('http://localhost:8081/usuarios/unprotected')
      .subscribe((p) => {
        this.listaUsuarios = p;
        this.cdr.detectChanges();
      });
  }

  private recuperarToken(): void {
    this.http
      .post(
        'http://localhost:8081/usuarios/login',
        { usuario: 'user', password: 'password' },
        { responseType: 'text', observe: 'response' },
      )
      .subscribe({
        next: (p) => {
          if (p.status === 200) {
            if (typeof p.body === 'string') {
              localStorage.setItem('token', p.body);
              console.log('Token recuperado correctamente');
            }
          }
        },
        error: () => {
          console.log('Error al recuperar el token');
        },
      });
  }

  private recuperarListaUsuariosToken(): void {
    this.http
      .get<Usuarioresponse[]>('http://localhost:8081/usuarios', {
        headers: {
          Authorization: `${localStorage.getItem('token')}`,
        },
      })
      .subscribe((p) => {
        this.listaUsuariosProtegidos = p;
        this.cdr.detectChanges();
      });
  }

  public mostrarTextoGenerativo(): void{
    console.log(this.textoGenerativo);
  }
}
