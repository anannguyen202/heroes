
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { config, environment } from '../../environments/environment';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

/**
 * API is a generic REST Api handler. Set your API url first.
 */
@Injectable()
export class ApiProvider {
    public apiUrl = '';
    public imgUrl = '';

    constructor(private http: HttpClient, private rou: Router) {
        if (environment.production) {
            let tmp = !config.apiUrl.startsWith(location.origin) ? location.origin : '';
            this.apiUrl = tmp + config.apiUrl;

            tmp = !config.imgUrl.startsWith(location.origin) ? location.origin : '';
            this.imgUrl = tmp + config.imgUrl;
        }
        else {
            this.apiUrl = config.apiUrl;
            this.imgUrl = config.imgUrl;
        }
    }
    
    public getx(endpoint: string): Observable<any> {
        return this.http.get(endpoint);
    }

    public get(endpoint: string, params?: any, reqOpts?: any) {
        if (!reqOpts) {
            reqOpts = {
                params: new HttpParams()
            };
        }

        // Support easy query params for GET requests
        if (params) {
            reqOpts.params = new HttpParams();
            for (let k in params) {
                reqOpts.params.set(k, params[k]);
            }
        }

        return this.http.get(this.apiUrl + endpoint, reqOpts);
    }

    public post(endpoint: string, body: any, reqOpts?: any) {
        if (!reqOpts) {
            let h = new HttpHeaders().set('Authorization', '')
            h = h.append('Content-Type', 'application/json');
            reqOpts = { headers: h };
        }

        return this.http.post(this.apiUrl + endpoint, body, reqOpts);
    }

    public put(endpoint: string, body: any, reqOpts?: any) {
        if (!reqOpts) {
            let h = new HttpHeaders().set('Authorization', '')
            h = h.append('Content-Type', 'application/json');
            reqOpts = { headers: h };
        }

        return this.http.put(this.apiUrl + endpoint, body, reqOpts);
    }

    public delete(endpoint: string, reqOpts?: any) {
        if (!reqOpts) {
            let h = new HttpHeaders().set('Authorization','')
            reqOpts = { headers: h };
        }

        return this.http.delete(this.apiUrl + endpoint, reqOpts);
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