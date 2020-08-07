import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { User, Profile } from '../../../shared/model/User';
// import { Response } from '../../../shared/model/Response';
import { UserService } from '../../../shared/services/user.service';
import { NbToastrService } from '@nebular/theme';

@Component({
  selector: 'ngx-register-user',
  templateUrl: './register-user.component.html',
  styleUrls: ['./register-user.component.scss']
})
export class RegisterUserComponent implements OnInit {

  public selectedItem = 1;
  public profiles: Profile[];
  public selected = '5f1b21f71149f05e456a55a4';
  private danger = { label: 'danger', flag: true};
  private basic = { label: 'basic', flag: false};

  public statusName = this.basic;
  public statuslastName = this.basic;
  public statusUser = this.basic;
  public statusPhone = this.basic;
  public statusEmail = this.basic;
  public statusProfile = this.basic;

  public userForm: FormGroup;
  public name: FormControl;
  public firstLastName: FormControl;
  public secondLastName: FormControl;
  public password: FormControl;
  public user: FormControl;
  public profile: FormControl;
  public email: FormControl;
  public phone: FormControl;

  constructor(private api: UserService, private toastrService: NbToastrService) { 
    this.createForm();
  }



  ngOnInit(): void {
    this.getProfiles();
  }

  getProfiles() {
    this.api.getProfile().subscribe(
      res => this.profiles = res.data,
      error => console.error('Pos valio')
    );
  }

  createUser() {
    if (this.userForm.valid) {
      const user: User = { 
        id: null,
        user: this.user.value,
        name: this.name.value, 
        firstLastName: this.firstLastName.value, 
        secondLastName: this.secondLastName.value, 
        password: this.password.value,
        idProfile: this.profile.value,
        idStatus: 1,
        email: this.email.value,
        phone: this.phone.value
      };
      this.api.postUser(user).subscribe(
        user => {
          this.userForm.reset();
          this.showToast('top-right', 'success', 'El usuario ha sido creado', 'Correcto');
        }, 
        error => {
          this.showToast('top-right', 'danger', 'No se creo el usuario', 'Error');
        }
      );
    } else {
      this.showToast('top-right', 'danger', 'Datos faltantes o erroneos', 'Error');
    }
    this.displayErrors();
  }

  createForm() {
    this.user = new FormControl('', [
      Validators.required
    ]);
    this.name = new FormControl('', [
      Validators.required
    ]);
    this.firstLastName = new FormControl('', [
      Validators.required
    ]);
    this.secondLastName = new FormControl('', [
      // Validators.required
    ]);
    this.password = new FormControl('', [
      Validators.required,
      Validators.minLength(8)
    ]);
    this.profile = new FormControl('', [
      Validators.required
    ]);
    this.email = new FormControl('', [
      Validators.required,
      Validators.email
    ]);
    this.phone = new FormControl('', [
      Validators.required,
      Validators.minLength(10)
    ]);
    this.userForm = new FormGroup({
      user: this.user,
      name: this.name,
      firstLastName: this.firstLastName,
      secondLastName: this.secondLastName,
      // password: this.password,
      profile: this.profile,
      email: this.email,
      phone: this.phone
    });
  }

  showToast(position, status, message, title) {
    this.toastrService.show(
      message,
      title,
      { position, status });
  }

  displayErrors() {
    this.statusName = this.name.invalid ? this.danger:this.basic; 
    this.statuslastName = this.firstLastName.invalid ? this.danger:this.basic;
    this.statusUser = this.user.invalid ? this.danger:this.basic;
    this.statusPhone = this.phone.invalid ? this.danger:this.basic;
    this.statusEmail = this.email.invalid ? this.danger:this.basic;
    this.statusProfile = this.profile.invalid ? this.danger:this.basic;
  }

  error(control: FormControl) {
    
    if (control.value && control.invalid ) {
      console.log('danger');
      
      return 'danger';
    }
    return 'basic'; 
  }

}
