import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

/**
 * API is a generic REST Api handler. Set your API url first.
 */
@Injectable()
export class ApiProvider {
    public apiUrl = '';

    constructor(private http: HttpClient, private rou: Router) {
        this.apiUrl = "localhost:8080/";
    }

    setHeaders() {
        const headers = {
            'Content-Type': 'application/json'
        }
        return new Headers(headers);
    }

    public post(endpoint: string, body: any, reqOpts?: any) {
        if (!reqOpts) {
            let h = new Headers({ 'Content-Type': 'application/json' });
            // h = h.append('Authorization', this.getToken());
            reqOpts = { headers: h };
        }
        console.log(body);
        return this.http.post(this.apiUrl + endpoint, JSON.stringify(body), reqOpts);
    }

    public getUserId(): string {
        let t = localStorage.getItem('CURRENT_TOKEN');
        let json = JSON.parse(t);

        if (json === null) {
            t = "";
        } else {
            t = json.userId;
        }

        return t;
    }
}