import { Component, OnInit } from '@angular/core';
import { UserProvider } from 'src/app/provider/user';
import { Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
    selector: 'app-sign-in',
    templateUrl: './sign-in.component.html',
    styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {

    public messageError;
    public formSignIn: FormGroup;

    constructor(
        private userProvider: UserProvider,
        private router: Router,
        private fb: FormBuilder
    ) { 
        this.formSignIn = this.fb.group({
            userName: ['', Validators.required],
            password: ['', Validators.required]
        });
    }

    ngOnInit() {
    }

    onSubmit() {
        this.userProvider.signIn(this.formSignIn.value)
            .subscribe((rsp:any) => {
                if(rsp.status == "error")
                    return this.messageError = rsp.message;
                localStorage.setItem("userName", rsp.result.userName);
                this.router.navigateByUrl('/dashboard');
                console.log(rsp);
            });
    }

}
