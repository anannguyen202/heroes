import { Component, OnInit } from '@angular/core';
import { UserProvider } from 'src/app/provider/user';
import { FormControl, FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
    selector: 'app-sign-up',
    templateUrl: './sign-up.component.html',
    styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

    signUpForm: FormGroup;
    messageError;

    constructor(
        private user: UserProvider,
        private fb: FormBuilder,
        private router: Router
    ) { }

    ngOnInit() {
        this.signUpForm = this.fb.group({
            userName: ['',[Validators.required]],
            password: ['',[Validators.required]],
            email: [],
            firstName: [],
            lastName: []
        });
    }

    onSubmit() {
        this.user.signUp(this.signUpForm.value)
            .subscribe((rsp:any) => {
                if(rsp.status == "error")
                    return this.messageError = rsp.message;
                this.router.navigateByUrl('/dashboard');
                console.log(rsp);
            })
    }

}
