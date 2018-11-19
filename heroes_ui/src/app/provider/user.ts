import { Injectable } from '@angular/core';
import { ApiProvider } from './api';

@Injectable()
export class UserProvider {

    constructor(
        private api: ApiProvider
    ) { }

    public signIn(info: any) {
        return this.api.post('user/sign-in', info);
    }

    public signUp(info: any) {
        return this.api.post('user/sign-up', info);
    }

}