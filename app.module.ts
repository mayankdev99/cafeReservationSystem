import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { ReservationComponent } from './reservation/reservation.component';
import { BookatableComponent } from './bookatable/bookatable.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { DatePipe } from '@angular/common';
import { ContactComponent } from './contact/contact.component';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { HomeComponent } from './home/home.component';
import { AdminhomeComponent } from './adminhome/adminhome.component';
import { RegisterComponent } from './register/register.component';
import { UserComponent } from './user/user.component';
import { UserhomeComponent } from './userhome/userhome.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatTabsModule } from '@angular/material/tabs';
import { MenuTableComponent } from './menu-table/menu-table.component';
import { MenuAdminComponent } from './menu-admin/menu-admin.component';
import { MenuCardComponent } from './menu-card/menu-card.component';
import { ChangepasswordComponent } from './changepassword/changepassword.component';
import { CreateAdminComponent } from './create-admin/create-admin.component';
import { UpdateProfileComponent } from './update-profile/update-profile.component';
import { UserService } from './service/user.service';
import { WelcomeComponent } from './welcome/welcome.component';



const routes: Routes = [
  { path: '', redirectTo: 'home' , pathMatch:'full' },
  { path: 'adminlogin', component: AdminComponent },
  { path: 'home', component: HomeComponent },
  { path : 'register' , component: RegisterComponent},
  { path : 'userlogin' , component :UserComponent},
  { path : 'adminhome' , component: AdminhomeComponent},
  { path : 'userhome' , component: UserhomeComponent},
  { path:'reservation',component:ReservationComponent},
  { path: 'bookatable', component: BookatableComponent },
  { path: 'contact', component: ContactComponent },
  { path: 'menu-table', component: MenuTableComponent },
  { path: 'menu-admin/edit/:id', component: MenuAdminComponent },
  { path: 'menu-card', component:MenuCardComponent},
  { path: 'menu-admin', component: MenuAdminComponent },
  { path: 'changepassword', component: ChangepasswordComponent },
  { path: 'create-admin', component: CreateAdminComponent },
  { path: 'update-profile', component: UpdateProfileComponent},
  { path: 'welcome', component:WelcomeComponent}
  
  ];


@NgModule({
  declarations: [
    AppComponent,
    ReservationComponent,
    BookatableComponent,
    HomeComponent,
    RegisterComponent,
    UserComponent,
    AdminComponent,
    UserhomeComponent,
    AdminhomeComponent,
    ContactComponent,
    MenuTableComponent,
    MenuAdminComponent,
    MenuCardComponent,
    ChangepasswordComponent,
    CreateAdminComponent,
    UpdateProfileComponent,
    WelcomeComponent
   
    
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
    MatTabsModule,
    BrowserAnimationsModule
  ],
  providers: [DatePipe,UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
