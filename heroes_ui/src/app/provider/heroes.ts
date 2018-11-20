import { Injectable } from '@angular/core';
import { ApiProvider } from './api';

@Injectable()
export class HeroesProvider {

    constructor(
        private api: ApiProvider
    ) { }

    public getHeroes() {
        return this.api.get('hero/get');
    }

    public getHero(id: any) {
        return this.api.get('hero/getById/' + id);
    }

}