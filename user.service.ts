import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {
    private userId: number = -1; // Store the user's ID
  
    setUserId(id: number) {
      this.userId = id;
    }
  
    getUserId(): number {
      return this.userId;
    }
}
