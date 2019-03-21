import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable()
export class AppService {

  private headers;
  private readonly host;
  private readonly schema;
  private domain;

  constructor(private http: HttpClient) {
    this.host = '//localhost:9091/';
    this.schema = window.location.protocol;
    this.domain = this.schema + this.host;

    this.headers = new HttpHeaders(
      {
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*'
      }
    );
  }


  public get(url: string, success: any = (s) => s, error: any = (e) => e): any {
    return this.http.get(this.domain + url).subscribe(success, error);
  }

  public post(url: string, success: any = (s) => s, error: any = (e) => e): any {
    return this.http.post(this.domain + url, {
      headers: this.headers
    }).subscribe(success, error);
  }

  public delete(url: string, success: any = (s) => s, error: any = (e) => e): any {
    return this.http.delete(this.domain + url, {
      headers: this.headers
    }).subscribe(success, error);
  }

}
