import { Component, OnInit } from '@angular/core';
import { Hero } from '../../hero';
import { ActivatedRoute } from '@angular/router';
import { HeroService } from '../../hero.service';
import { Location } from '@angular/common'
import { HeroesProvider } from 'src/app/provider/heroes';

@Component({
  selector: 'app-hero-detail',
  templateUrl: './hero-detail.component.html',
  styleUrls: ['./hero-detail.component.css']
})
export class HeroDetailComponent implements OnInit {

  hero: Hero;

  constructor(
    private location: Location,
    private route: ActivatedRoute,
    private HeroesProvider: HeroesProvider
  ) { }

  ngOnInit() {
    this.getHero();
  }

  getHero():void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.HeroesProvider.getHero(id)
    .subscribe((rsp: any) => this.hero = rsp.result); 
  }

  goBack():void {
    this.location.back();
  }

  save():void {
    // this.heroService.updateHero(this.hero)
    // .subscribe(() => {
    //   this.goBack();
    // });
  }

}
