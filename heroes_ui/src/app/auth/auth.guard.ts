import { Injectable, Inject } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';

@Injectable()

export class AuthGuard implements CanActivate {

    constructor(
        private router: Router
    ) {}

    canActivate(
        next: ActivatedRouteSnapshot,
        state: RouterStateSnapshot
    ): boolean {
        if(localStorage.getItem('key') != null)
            return true;
        this.router.navigate(['/sign-in']);   
        return false; 
    }

}