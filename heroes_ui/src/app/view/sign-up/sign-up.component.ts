import { Component, OnInit } from '@angular/core';
import { UserProvider } from 'src/app/provider/user';
import { FormControl, FormGroup, FormBuilder } from '@angular/forms';

@Component({
    selector: 'app-sign-up',
    templateUrl: './sign-up.component.html',
    styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

    signUpForm: FormGroup;

    constructor(
        private user: UserProvider,
        private fb: FormBuilder
    ) { }

    ngOnInit() {
        this.signUpForm = this.fb.group({
            userName: [],
            password: [],
            email: [],
            firstName: [],
            lastName: []
        });
    }

    onSubmit() {
        console.log(this.signUpForm.value);
        const info = {
            userName: "an",
            password: "123"
        };
        this.user.signUp(info)
            .subscribe(rsp => {
                console.log(rsp);
            })
    }

}
