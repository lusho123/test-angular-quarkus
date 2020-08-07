import { Component, OnInit, Input } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { User, UserVO } from '../../../shared/model/User';
import { NbToastrService, NbDialogRef } from '@nebular/theme';
import { UserService } from '../../../shared/services/user.service';


@Component({
  selector: 'ngx-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.scss']
})
export class EditUserComponent implements OnInit {

  public userForm: FormGroup;
  public name: FormControl;
  public firstLastName: FormControl;
  public secondLastName: FormControl;
  public user: FormControl;
  public profile: FormControl;
  public email: FormControl;
  public phone: FormControl;
  public editUser: UserVO;

  @Input() 
  set id(id: any) {
    console.log(id);
    
    this.api.getUserById(id).subscribe(
      user => {
        this.editUser = user.data;
        console.log(this.editUser);
        
        this.fillForm();
      }
    );
  };

  constructor(private api: UserService, 
              protected dialogRef: NbDialogRef<EditUserComponent>,
              private toastrService: NbToastrService) { 
    this.createForm();
  }

  ngOnInit(): void {
  }

  createForm() {
    this.user = new FormControl('');
    this.name = new FormControl('');
    this.firstLastName = new FormControl('');
    this.secondLastName = new FormControl('');
    this.profile = new FormControl('');
    this.email = new FormControl('');
    this.phone = new FormControl('');
    this.userForm = new FormGroup({
      user: this.user,
      name: this.name,
      firstLastName: this.firstLastName,
      secondLastName: this.secondLastName,
      profile: this.profile,
      email: this.email,
      phone: this.phone
    });
  }

  fillForm() {
    this.userForm.get('name').setValue(this.editUser.name);
    this.userForm.get('firstLastName').setValue(this.editUser.firstLastName);
    this.userForm.get('secondLastName').setValue(this.editUser.secondLastName);
    this.userForm.get('profile').setValue(this.editUser.profile.id);
    this.userForm.get('phone').setValue(this.editUser.phone);
    this.userForm.get('email').setValue(this.editUser.email);
    this.userForm.get('user').setValue(this.editUser.user);
  }

  close(){
    this.dialogRef.close();
  }

  edit() {
    if (this.userForm.valid) {
      this.editUser.name = this.userForm.get('name').value;
      this.editUser.firstLastName = this.userForm.get('firstLastName').value;
      this.editUser.secondLastName = this.userForm.get('secondLastName').value;
      this.editUser.email = this.userForm.get('email').value;
      this.editUser.user = this.userForm.get('user').value;
      this.editUser.profile.id = this.profile.value;
      this.editUser.phone = this.phone.value;
      this.api.putUser(this.editUser).subscribe(
        user => {
          this.showToast('top-right', 'success', 'El usuario ha sido actualizado', 'Correcto');
          this.dialogRef.close(this.editUser);
        },
        error => {
          this.showToast('top-right', 'danger', 'No se actualizó el usuario', 'Error');
        }
      )
    }
  }

  delete(id: string) {
    this.api.deleteUser(id).subscribe(
      user => {
        // this.deleteFromUsers(id);
        this.showToast('top-right', 'success', 'El usuario ha sido eliminado', 'Correcto');
        this.dialogRef.close({ delId: id });
      },

      error => {
        this.showToast('top-right', 'danger', 'No se eliminó el usuario', 'Error');
      }
    )

  }

  showToast(position, status, message, title) {
    this.toastrService.show(
      message,
      title,
      { position, status });
  }

  cancel() {
    this.dialogRef.close();
  }

}
