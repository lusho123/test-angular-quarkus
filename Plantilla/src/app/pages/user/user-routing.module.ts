import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";

// import { UserComponent } from "./user.component";
import { ShowUsersComponent } from "./show-users/show-users.component";
import { RegisterUserComponent } from './register-user/register-user.component';

const routes: Routes = [
  { 
    path: "", 
    component: ShowUsersComponent 
  },
  { 
    path: "register", 
    component: RegisterUserComponent 
  },
  // { 
  //   path: "stadistics", 
  //   component:  
  // },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class UserRoutingModule {}
