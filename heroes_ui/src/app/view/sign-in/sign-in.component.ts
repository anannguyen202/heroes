import { Component, OnInit } from '@angular/core';
import { UserProvider } from 'src/app/provider/user';
import { Router } from '@angular/router';

@Component({
    selector: 'app-sign-in',
    templateUrl: './sign-in.component.html',
    styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {

    private userName;
    private password;
    private messageError;

    constructor(
        private userProvider: UserProvider,
        private router: Router
    ) { }

    ngOnInit() {
    }

    signIn() {
        const info = { userName: this.userName, password: this.password };
        this.userProvider.signIn(info)
            .subscribe((rsp:any) => {
                if(rsp.status == "error")
                    return this.messageError = rsp.message;
                localStorage.setItem("userName", rsp.result.userName);
                this.router.navigateByUrl('/dashboard');
                console.log(rsp);
            });
    }

}
