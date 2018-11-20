import { Component, OnInit } from '@angular/core';
import { Hero } from '../../hero';
import { HeroService } from '../../hero.service';
import { HeroesProvider } from 'src/app/provider/heroes';

@Component({
  selector: 'app-heroes',
  templateUrl: './heroes.component.html',
  styleUrls: ['./heroes.component.css']
})
export class HeroesComponent implements OnInit {

  heroes: Hero[];
  selectedHero: Hero;

  constructor(
    private heroesProvider: HeroesProvider
    ) {
  }

  onSelect(hero: Hero): void {
    this.selectedHero = hero;
  }

  addHero(heroName: string): void {
    const name = heroName.trim();
    if (!name) return;
   
  }

  deleteHero(hero: Hero): void {
    this.heroes = this.heroes.filter(h => h != hero);
    
  }

  getHeroes(): void {
    this.heroesProvider.getHeroes()
      .subscribe((rsp: any) => this.heroes = rsp.result);
  }

  ngOnInit() {
    this.getHeroes();
  }

}
