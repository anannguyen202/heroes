import { Component, OnInit } from '@angular/core';
import { HeroService } from '../../hero.service';
import { Hero } from '../../hero';
import { Router } from '@angular/router';
import { HeroesProvider } from 'src/app/provider/heroes';

@Component({
    selector: 'app-dashboard',
    templateUrl: './dashboard.component.html',
    styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

    heroes: Hero[];

    constructor(
        private heroProvider: HeroesProvider,
        private router: Router
    ) { }

    ngOnInit() {
        this.getHeroes();
    }

    getHeroes(): void {
        this.heroProvider.getHeroes()
            .subscribe((rsp: any) => this.heroes = rsp.result.slice(1, 5));
    }

    signOut() {
        localStorage.clear();
        // this.router.navigateByUrl('/dashboard');
    }

}
