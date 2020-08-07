import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";

import { UserRoutingModule } from "./user-routing.module";
import { UserComponent } from "./user.component";
import { RegisterUserComponent } from "./register-user/register-user.component";
import { ShowUsersComponent } from "./show-users/show-users.component";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import {
  NbListModule,
  NbCardModule,
  NbButtonModule,
  NbDialogModule,
  NbToastrModule,
  NbSelectModule,
  NbInputModule,
} from "@nebular/theme";
import { Ng2SmartTableModule } from "ng2-smart-table";
import { EditUserComponent } from "./edit-user/edit-user.component";

@NgModule({
  declarations: [
    UserComponent,
    RegisterUserComponent,
    ShowUsersComponent,
    EditUserComponent,
  ],
  imports: [
    CommonModule,
    UserRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    NbCardModule,
    NbButtonModule,
    NbDialogModule.forChild(),
    NbToastrModule.forRoot(),
    NbSelectModule,
    Ng2SmartTableModule,
    NbListModule,
    NbInputModule
  ],
})
export class UserModule {}
